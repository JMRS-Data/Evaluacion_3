package jmrs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jmrs.dao.PersonaDAO;
import jmrs.dao.PersonaDAOImpl;
import jmrs.model.Persona;

/**
 * Servlet implementation class PersonaController
 */
@WebServlet("/PersonaController")
public class PersonaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Persona persona;
	private List<Persona> personas;
	private PersonaDAO personaDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonaController() {
		super();
		// TODO Auto-generated constructor stub
		persona = new Persona();
		personas = new ArrayList<Persona>();
		personaDAO = new PersonaDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("btn_save") != null) {
			persona.setNombre(request.getParameter("nombre"));
			persona.setEdad(request.getParameter("edad"));
			persona.setPeso(request.getParameter("peso"));
			if (persona.getId() == 0L) {
				personaDAO.createPersona(persona);

			} else {
				personaDAO.updatePersona(persona);

			}
			personas = personaDAO.readAllPersonas();
			request.setAttribute("personas", personas);
			request.getRequestDispatcher("persona_list.jsp").forward(request, response);

		} else if (request.getParameter("btn_new") != null) {
			persona = new Persona();
			request.getRequestDispatcher("persona_form.jsp").forward(request, response);
		} else if (request.getParameter("btn_edit") != null) {
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				persona = personaDAO.readPersona(id);
			} catch (IndexOutOfBoundsException e) {
				persona = new Persona();
			}
			request.setAttribute("persona", persona);
			request.getRequestDispatcher("persona_form.jsp").forward(request, response);
		} else if (request.getParameter("btn_delete") != null) {
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				personaDAO.deletePersona(id);
				personas = personaDAO.readAllPersonas();
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("personas", personas);
			request.getRequestDispatcher("persona_list.jsp").forward(request, response);
		} else {
			personas = personaDAO.readAllPersonas();
			request.setAttribute("personas", personas);
			request.getRequestDispatcher("persona_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

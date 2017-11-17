package jmrs.dao;

import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jmrs.model.Persona;

public class PersonaDAOImpl  implements PersonaDAO{
	
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public PersonaDAOImpl() {
		getConnection();
	}
	
	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_persona", "postgres", "utng");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void createPersona(Persona persona) {
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement("INSERT INTO tb_persona(nombre, edad, peso) VALUES (?, ?, ?);");

				preparedStatement.setString(1, persona.getNombre());
				preparedStatement.setString(2, persona.getEdad());
				preparedStatement.setString(3, persona.getPeso());

				preparedStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public Persona readPersona(Long id) {
		Persona persona = null;
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement("SELECT * FROM tb_persona WHERE id=?;");
				preparedStatement.setLong(1, id);
				resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					persona = new Persona(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
							resultSet.getString(4));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return persona;
	}

	@Override
	public List<Persona> readAllPersonas() {
		List<Persona> personas = new ArrayList<Persona>();
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement("SELECT * FROM tb_persona");
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					Persona item = new Persona(resultSet.getLong("id"), resultSet.getString("nombre"),resultSet.getString("edad"), resultSet.getString("peso"));
					personas.add(item);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return personas;
	}

	@Override
	public void updatePersona(Persona persona) {
		if (connection != null) {
			try {
				preparedStatement = connection
						.prepareStatement("UPDATE tb_persona SET nombre=?, edad=?, peso=? WHERE id=?;");

				preparedStatement.setString(1, persona.getNombre());
				preparedStatement.setString(2, persona.getEdad());
				preparedStatement.setString(3, persona.getPeso());
				preparedStatement.setLong(4, persona.getId());
				preparedStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void deletePersona(Long id) {
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement("DELETE FROM tb_persona WHERE id=?;");

				preparedStatement.setLong(1, id);
				preparedStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
	}
	
}

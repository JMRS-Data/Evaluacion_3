package jmrs.dao;

import java.util.List;

import jmrs.model.Persona;

public interface PersonaDAO {
	void createPersona(Persona persona);
	Persona readPersona(Long id);
	List<Persona> readAllPersonas();
	void updatePersona(Persona persona);
	void deletePersona(Long id);
}

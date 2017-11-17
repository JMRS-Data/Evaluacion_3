package jmrs.model;

public class Persona {
	private long id;
	private String nombre;
	private String edad;
	private String peso;
	/**
	 * @param id
	 * @param nombre
	 * @param edad
	 * @param peso
	 */
	public Persona(long id, String nombre, String edad, String peso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
	}
	/**
	 * 
	 */
	public Persona() {
		
		this(0L,"","","");

	}
	/**
	 * @return the idPersona
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param idPersona the idPersona to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the edad
	 */
	public String getEdad() {
		return edad;
	}
	/**
	 * @param edad the edad to set
	 */
	public void setEdad(String edad) {
		this.edad = edad;
	}
	/**
	 * @return the peso
	 */
	public String getPeso() {
		return peso;
	}
	/**
	 * @param peso the peso to set
	 */
	public void setPeso(String peso) {
		this.peso = peso;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + "]";
	}
	
	
}

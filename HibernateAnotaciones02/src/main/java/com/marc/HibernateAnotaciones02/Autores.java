// default package
// Generated 18 abr 2022 23:29:39 by Hibernate Tools 5.6.3.Final
package com.marc.HibernateAnotaciones02;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table; 

/**
 * Autores generated by hbm2java
 */

@Entity
@Table(name = "autores") 
public class Autores implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "cod", unique = true, nullable = false, length = 5)
	private String cod;
	
	@Column(name = "nombre", length = 60) 
	private String nombre;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "escribir", joinColumns = {
			@JoinColumn(name = "codautor", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "codlibro", nullable = false, updatable = false) })
	
	private Set<Libros> libroses = new HashSet<Libros>(0);

	public Autores() {
	}

	public Autores(String cod) {
		this.cod = cod;
	}

	public Autores(String cod, String nombre, Set<Libros> libroses) {
		this.cod = cod;
		this.nombre = nombre;
		this.libroses = libroses;
	}

	public String getCod() {
		return this.cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Libros> getLibroses() {
		return this.libroses;
	}

	public void setLibroses(Set<Libros> libroses) {
		this.libroses = libroses;
	}

}

package com.marc.HibernateAnotaciones01;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class App
{
	static SessionFactory sessionFactory = null;
	static Session session = null;
	
	public static void tearUp() {
		 sessionFactory = new Configuration().configure().buildSessionFactory();
		 session = sessionFactory.openSession();
	 }
	
	public static void tearDown() {
		session.close();
	 }
	
	public static void comprobarSesion() {
		 if (session != null) {
			 System.out.println("Sesión abierta");
		 } else {
			 System.out.println("Fallo en la sesión"); 
		 
		 }
	}
	
	public static void desactivarLog() {
		@SuppressWarnings("unused")
		org.jboss.logging.Logger logger =
		org.jboss.logging.Logger.getLogger("org.hibernate");
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.SEVERE);
	}
	
	public static void mostrarLibros() {
		Query<Libros> consulta = session.createQuery("from Libros");
		List<Libros> resultados = consulta.list();
		System.out.println("Mostrando los datos de los libros: ");
		for (Libros resultado : resultados) {
			System.out.println(resultado.getId()
			+ ": " + resultado.getTitulo() + ", de "
			+ (resultado.getAutores()!=null?resultado.getAutores().getNombre():"Anónimo"));
		}
	}
	
	public static void mostrarAutor() {
		Query<Autores> consulta = session.createQuery("from Autores");
		List<Autores> resultados = consulta.list();
		System.out.println("Mostrando los datos de los Autores: ");
		for (Autores resultado : resultados) {
			System.out.println("El autor " + resultado.getCod()
			+ " de nombre " + resultado.getNombre()
			+ " ha escrito :");
			resultado.getLibroses().forEach(e->System.out.println(e.getTitulo()));
		}
	}
	
	public static void main( String[] args )
	{
		desactivarLog();
		tearUp();
		comprobarSesion();
		mostrarLibros();
		mostrarAutor();
		tearDown();
	}
}
package daos;

import java.util.ArrayList;

import model.Curso;

/*
 * Interfaz donde creo los métodos que van a ser obligatorios implementar (las opciones de la aplicación)
 */

public interface CursosDAO {
	
	public void registrarCurso(Curso c);    //Setter: metodo para registrar el curso, que recibe parámetro tipo curso.
	
	public ArrayList<Curso> obtenerCursos();   //Getter: método para obtener los cursos(se indica tipo ArrayList) 
	
	public void borrarCurso(int indice);
	
	public Curso obtenerCursoId(int indice);
	
	public void editarCurso(String course, String platform, int hours, String category, double price, String type, int indice);
	
	
	
	

}

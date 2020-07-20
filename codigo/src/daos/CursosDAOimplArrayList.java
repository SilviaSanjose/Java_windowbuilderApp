package daos;
/*
 * Clase donde se gestiona las funcionalidades que tiene nuestra app, hereda de la interfaz.
NO USADA, YA QUE USAMOS LA CLASE IMPLEMENTADA DE ARCHIVOS: se deja para pruebas con arrayList
 */
import java.util.ArrayList;

import model.Curso;

public class CursosDAOimplArrayList implements CursosDAO{
	
	//creo objeto tipo ArrayList que recogera los datos mi curso
	ArrayList<Curso> cursos = new ArrayList<Curso>();

	@Override
	public void registrarCurso(Curso c) {
		cursos.add(c);  //añado al objeto cursos, los elementos que estaran guardado en el parametro que se le da al metodo
		
	}

	@Override
	public ArrayList<Curso> obtenerCursos() {
		// devuelvo el objeto cursos
		return cursos;
	}

	@Override
	public void borrarCurso(int indice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Curso obtenerCursoId(int indice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editarCurso(String course, String platform, int hours, String category, double price, String type,
			int indice) {
		// TODO Auto-generated method stub
		
	}

	
}

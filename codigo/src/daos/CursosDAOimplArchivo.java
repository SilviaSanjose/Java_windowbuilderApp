package daos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Curso;

public class CursosDAOimplArchivo implements CursosDAO{
	
	
	int prueba = 3;
	private final String ARCHIVO = "ficheroCursos.dat";  //constante para crear y trabajar con el fichero de almacenamiento
	
	File f = new File(ARCHIVO);  //creo el objeto file del archivo para usarlo al leer y escribir
	
	ArrayList<Curso> cursos = new ArrayList<Curso>();
	
	public CursosDAOimplArchivo() {
		// creo cosntructor para que cada vez que se llame al objeto del archivo, lo lea.
		this.leerArchivo();
	}
	
	private void escribirArchivo() {
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(cursos);
			oos.close();
			fos.close();
		} catch (IOException e) {
			System.out.println("Error al escribir en el archivo");
		}
	}

	private void leerArchivo() {
	  //aunque intente el try/catch, indicamos que se ejecute sólo si existe el fichero
		if(f.exists()) {
			try {
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				cursos = (ArrayList<Curso>)ois.readObject();
				ois.close();
				fis.close();
			} catch (IOException e) {
				System.out.println("Error al leer el archivo");
			} catch (ClassNotFoundException e) {
				System.out.println("No se encuentra la clase del objeto");
			}
		}//end if(f.exists())
	}
	
	
	@Override  //recogemos los datos y llamamos a la función para escribirlos en el archivo
	public void registrarCurso(Curso c) {
		cursos.add(c);
		escribirArchivo();
	}

	@Override // getter donde recupera los datos del objeto cursos
	public ArrayList<Curso> obtenerCursos() {
		return cursos;
	}

	@Override
	public void borrarCurso(int indice) {
		cursos.remove(indice);
		escribirArchivo();  //vuelvo a escribir para actualizar
	}

	@Override
	public Curso obtenerCursoId(int indice) {
		// obtener por el indice el curso
		return cursos.get(indice);
	}

	@Override
	public void editarCurso(String course, String platform, int hours, String category, double price, String type,
			int indice) {
		Curso c = cursos.get(indice);
		c.setCourse(course);
		c.setPlatform(platform);
		c.setHours(hours);
		c.setCategory(category);
		c.setPrice(price);
		c.setType(type);
		escribirArchivo();   //vuelvo a escribir para actualizar
		
	} 


}

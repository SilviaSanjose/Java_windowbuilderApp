package model;

import java.io.Serializable;

/*
 * Modelo de la clase Curso, que es el objeto que se va a crear en nuestra aplicación.
 */
public class Curso implements Serializable {
	
	private String course;
	private String platform;
	private int hours;
	private String category;
	private double price;
	private String type;
	
	private int id;
	private static int nextId= 1;
	
	public Curso() {
		this.id = nextId;  //el primer id sera 1(valor de nextId), y después ira incrementando en uno
		nextId++;
	}

	public Curso(String course, String platform, int hours, String category, double price, String type) {
		super();
		this.course = course;
		this.platform = platform;
		this.hours = hours;
		this.category = category;
		this.price = price;
		this.type = type;
		this.id = nextId++;
	}
//creo getter y setter para poder usar las variables fuera de la clase.
	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
 //creo método toString para almacenar todos los elementos del objeto cursos
	@Override
	public String toString() {
		return "-CURSO: " + course + "  (" + category + ") " + price + "€. > Horas: " + hours +
				".  Impartido por: " + platform + ", modalidad " + type ;
	}
	
	
}//end class

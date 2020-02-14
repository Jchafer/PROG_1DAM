package simarro;

public class Alumno {

	private int id;
	private String nombre;
	private double promedio;
	
	public Alumno() {
		this.id = 0;
		this.nombre = "";
		this.promedio = 0;
	}
	
	public Alumno(int id, String nombre, double promedio) {
		this.id = id;
		this.nombre = nombre;
		this.promedio = promedio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	
	@Override
	public boolean equals(Object obj) {
		Alumno a = (Alumno)obj;
		if(this.nombre.equals(a.getNombre()) &&
			this.id == a.getId() &&
			this.nombre == a.getNombre() &&
			this.promedio == a.getPromedio())
			return true;
		else {
			return false;
		}
	}
	
}

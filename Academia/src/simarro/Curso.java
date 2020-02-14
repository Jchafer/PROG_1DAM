package simarro;

import java.util.ArrayList;
import java.util.Scanner;

public class Curso {
	
	private String nombre;
	private ArrayList<Alumno> listaAlumnos;
	
	public Curso() {
		this.nombre = "";
		this.listaAlumnos = new ArrayList<Alumno>();
	}
	
	public Curso(String nombre) {
		this.nombre = nombre;
		this.listaAlumnos = new ArrayList<Alumno>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}

	public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}
	
	public boolean altaMatricula(Alumno a) {
		try {
			listaAlumnos.add(a);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean bajaMatricula(Alumno a) {
		if (listaAlumnos.isEmpty()) {
			return false;
		}
		else if(a.equals(null)){
			return false;
		}
		else {
			try {
				listaAlumnos.remove(a);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
	
	public boolean estaInscrito(Alumno a) {
		Scanner teclado = new Scanner (System.in);
		boolean esta = false;
		if(listaAlumnos.isEmpty()) {
			System.out.println("No hay alumnos");
		}
		else {
			for (Alumno alumno : listaAlumnos) {
				if(alumno.getId() == a.getId()) {
					esta = true;
				}
			}
		}
		return esta;
	}
	
	public Alumno crearAlumno() {
		Scanner teclado = new Scanner (System.in);
		boolean correcto=true;
		do {
			try {
				correcto=true;
				System.out.print("Introduce el id: ");
				int id = Integer.parseInt(teclado.nextLine());
				System.out.print("Introduce el nombre: ");
				String nom = teclado.nextLine();
				System.out.print("Introduce el promedio: ");
				Double prom = Double.parseDouble(teclado.nextLine());
				
				Alumno nuevo = new Alumno(id, nom, prom);
				return nuevo;
			}catch (Exception e) {
				System.out.println("Debes introducir un dato correcto.");
				correcto=false;
			}
		} while (correcto==false);
		return null;
		
	}
	
	public Alumno eliminarAlumno() {
		Scanner teclado = new Scanner (System.in);
		boolean correcto=true;
		boolean esta=false;
		do {
			try {
				correcto=true;
				for (Alumno alumno : listaAlumnos) {
					System.out.println("Nombre: "+alumno.getNombre());
				}
				System.out.print("Introduce el nombre del usuario a eliminar: ");
				String nom = teclado.nextLine();
				for (Alumno alumno : listaAlumnos) {
					if (alumno.getNombre().equals(nom)) {
						esta=true;
						return alumno;
					}
				}
			}catch (Exception e) {
				System.out.println("Debes introducir un dato correcto.");
				correcto=false;
			}
		} while (correcto==false);
		
		if(esta) {
			System.out.println("Alumno eliminado");
		}
		else {
			System.out.println("El alumno no se ha eliminados");
		}
		return null;
		
	}
	
	public void listarAlumnos() {
		for (Alumno alumno : listaAlumnos) {
			System.out.println("ID: "+alumno.getId()+" - Nombre: "+alumno.getNombre());
		}
	}
	
}

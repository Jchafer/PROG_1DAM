package simarro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Aplicación {

	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		ArrayList<Curso> listaCursos = new ArrayList<Curso>();
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		
		int opc=0;	
		do {
			menu1();
			try {
				opc = Integer.parseInt(teclado.nextLine());
				System.out.println();
			}catch (Exception e) {
				System.out.println("\n- - - - - - - - - - - - - - -");
				System.out.println("Debes introducir un número.");
				System.out.println("- - - - - - - - - - - - - - -");
				System.out.println();
			}
			switch (opc) {
			case 1:
				altaCursos(listaCursos);
				break;
			case 2:
				bajaCursos(listaCursos);
				break;
			case 3:
				gestionarCursos(listaCursos, alumnos);
				break;
			case 4:
				System.out.println("\nAdiós.");
				break;
			default:
				System.out.println("\n- - - - - - - - - - - - - - - - - - -");
				System.out.println("Debes introducir una opción del menú.");
				System.out.println("- - - - - - - - - - - - - - - - - - -");
				System.out.println();
				break;
			}
				
		}while(opc!=4);
		
	}
	public static void menu1() {
		System.out.println("********** MENU **********");
		System.out.println("\n1) Alta de cursos.");
		System.out.println("2) Baja de cursos.");
		System.out.println("3) Gestionar cursos.");
		System.out.println("4) Salir.");
		System.out.print("\nIntroduce una opción: ");
	}
	
	public static void menu2(String c) {
		System.out.println("********** GESTIONAR "+c+" **********");
		System.out.println("\n1) Alta de alumnos.");
		System.out.println("2) Baja de alumnos.");
		System.out.println("3) Alta de matrícula de alumnos.");
		System.out.println("4) Baja de matrícula de alumnos.");
		System.out.println("5) Comprobar si un alumno está matriculado en un curso.");
		System.out.println("6) Listar los alumnos matriculados en un curso.");
		System.out.println("7) Volver.");
		System.out.print("\nIntroduce una opción: ");
	}
	
	public static void altaCursos(ArrayList<Curso> l) {
		Scanner teclado = new Scanner (System.in);
		boolean correcto=true;
		do {
			try {
				correcto=true;
				System.out.print("Introduce el nombre: ");
				String nom = teclado.nextLine();
				System.out.println("Curso creado");
				System.out.println();
				Curso nuevo = new Curso(nom);
				l.add(nuevo);
				
			}catch (Exception e) {
				System.out.println("Debes introducir un dato correcto.");
				correcto=false;
			}
		} while (correcto==false);
	}
	
	public static void bajaCursos(ArrayList<Curso> l) {
		Scanner teclado = new Scanner (System.in);
		System.out.println("Lista de cursos");
		if(l.isEmpty()) {
			System.out.println("No hay cursos");
		}
		else {
			boolean correcto=false;
			int cont = 1;
			for (Curso curso : l) {
				System.out.println(cont+".- "+curso.getNombre());
				cont++;
			}
			do {
				try {
					System.out.print("Introduce el número del curso a eliminar: ");
					int num = Integer.parseInt(teclado.nextLine());
					l.remove(num-1);
					correcto=true;
				} catch (Exception e) {
					System.out.println("Debes introducir un número correcto");
				}
			} while (correcto==false);
			
		}
		
	}
	
	public static void gestionarCursos(ArrayList<Curso> l, ArrayList<Alumno> a) {
		Scanner teclado = new Scanner(System.in);
		try {
			if(!l.isEmpty()) {
				for (Curso curso : l) {
					System.out.println("Nombre del curso: "+curso.getNombre());
				}
				System.out.print("Introduce el nombre de la clase a gestionar: ");
				String nombre = teclado.nextLine();
			
				Iterator<Curso> it = l.iterator();
				while(it.hasNext()) {
					Curso c = (Curso)it.next();
					if(c.getNombre().equals(nombre)) {
						int opc=0;	
						do {
							menu2(c.getNombre());
							try {
								opc = Integer.parseInt(teclado.nextLine());
							}catch (Exception e) {
								System.out.println("\n- - - - - - - - - - - - - - -");
								System.out.println("Debes introducir un número.");
								System.out.println("- - - - - - - - - - - - - - -");
								System.out.println();
							}
							switch (opc) {
							case 1:
								a.add(c.crearAlumno());
								System.out.println("El alumno se ha creado");
								System.out.println();
								break;
							case 2:
								listarAlumnosSinMatri(a);
								boolean correcto=false;
								try {
									System.out.println("Introduce el número del alumno a eliminar");
									int numero = Integer.parseInt(teclado.nextLine());
									a.remove(numero-1);
									correcto=true;
								} catch (Exception e) {
									System.out.println("No has introducido un valor correcto");
								}
								if(correcto) {
									System.out.println("El alumno se ha eliminado");
								}
								else {
									System.out.println("El alumno no se ha eliminado");
								}
								break;
							case 3:
								listarAlumnosSinMatri(a);
								System.out.println("Introduce el número del alumno a matricular");
								int num = Integer.parseInt(teclado.nextLine());
								if (c.altaMatricula(a.get(num-1))) {
									System.out.println("El alumno se ha matriculado");
									a.remove(num-1);
								}
								else {
									System.out.println("El alumno no se ha matriculado");
								}
								break;
							case 4:
								if (c.bajaMatricula(c.eliminarAlumno())) {
									System.out.println("El alumno se ha dado de baja");
								}
								else {
									System.out.println("El alumno no se ha dado de baja");
								}
								break;
							case 5:
								if(c.estaInscrito(c.crearAlumno())) {
									System.out.println("El alumno está inscrito");
								}
								else {
									System.out.println("El alumno NO está inscrito");
								}
								break;
							case 6:
								listarAlumnos(l);
								break;
							case 7:
								break;
							default:
								System.out.println("\n- - - - - - - - - - - - - - - - - - -");
								System.out.println("Debes introducir una opción del menú.");
								System.out.println("- - - - - - - - - - - - - - - - - - -");
								System.out.println();
								break;
							}
							
						}while(opc!=7);
					}
					else if(!c.getNombre().equals(nombre)) {
						System.out.println("No hay ninguna clase con ese nombre");
						System.out.println();
					}
					
				}
			}
			else {
				System.out.println("No hay clases");
				System.out.println();
			}
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	
	public static void listarAlumnos(ArrayList<Curso> l) {
		Scanner teclado = new Scanner (System.in);
		boolean correcto=false;
		int pos=1;
		System.out.println("Lista de cursos: ");
		for (Curso curso : l) {
			System.out.println(pos+".- "+curso.getNombre());
			pos++;
		}
		do {
			try {
				System.out.print("Introduce el número del curso: ");
				int num = Integer.parseInt(teclado.nextLine());
				int posi=1;
				for (Alumno alumno : l.get(num-1).getListaAlumnos()) {
					System.out.println("ID: "+alumno.getId()+" Alumno: "+"- "+alumno.getNombre());
					posi++;
				}
				correcto=true;
			} catch (Exception e) {
				System.out.println("Debes introducir un número correcto");
			}
		} while (correcto==false);
		
	}
	
	public static void listarAlumnosSinMatri(ArrayList<Alumno> a) {
		int pos=1;
		System.out.println("Lista de Alumnos: ");
		for (Alumno alum : a) {
			System.out.println(pos+" Alumno: "+"- "+alum.getNombre());
			pos++;
		}		
	}
}

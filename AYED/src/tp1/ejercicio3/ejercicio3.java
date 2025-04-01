package tp1.ejercicio3;

public class ejercicio3 {
	public static void main(String[] args) {
		Estudiante[] arregloEstudiante = {new Estudiante(), new Estudiante()};
		arregloEstudiante[0].setNombre("Pepito"); 
		arregloEstudiante[0].setApellido("Gonzales");
		arregloEstudiante[0].setComision("1A");
		arregloEstudiante[0].setEmail("pepito@gmail.com");
		arregloEstudiante[0].setDireccion("Evergreen terrace");
		
		arregloEstudiante[1].setNombre("Juliana"); 
		arregloEstudiante[1].setApellido("Hernandez");
		arregloEstudiante[1].setComision("1B");
		arregloEstudiante[1].setEmail("juliana@gmail.com");
		arregloEstudiante[1].setDireccion("La Plata");
		
		Profesor[] arrayProfe = {new Profesor(), new Profesor(), new Profesor()};
		arrayProfe[0].setNombre("Lucas"); 
		arrayProfe[0].setApellido("Ramirez");
		arrayProfe[0].setCatedra("CADP");
		arrayProfe[0].setEmail("lucas@gmail.com");
		arrayProfe[0].setFacultad("Informatica");	
		
		arrayProfe[1].setNombre("Hernesto"); 
		arrayProfe[1].setApellido("Salanco");
		arrayProfe[1].setCatedra("Matematicas");
		arrayProfe[1].setEmail("hernest@yahoo.com");
		arrayProfe[1].setFacultad("Informatica");
		
		arrayProfe[2].setNombre("Juliano"); 
		arrayProfe[2].setApellido("Lucera");
		arrayProfe[2].setCatedra("Taller");
		arrayProfe[2].setEmail("Juliano@gmail.com");
		arrayProfe[2].setFacultad("Informatica ingenieria");
		
		for (Estudiante estudiante: arregloEstudiante) {
			System.out.println(estudiante.tusDatos());
		}
		
		for (Profesor profesor: arrayProfe) {
			System.out.println(profesor.tusDatos());
		}
		
		
		
	}
}

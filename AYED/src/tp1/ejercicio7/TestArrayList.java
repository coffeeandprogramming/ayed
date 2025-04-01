package tp1.ejercicio7;

import java.util.*;

public class TestArrayList {
	
	public static void puntoD () {
		Estudiante auxiliar = new Estudiante("Hernestito", "Lopez", "1A", "hermesto@email.com", "evergreen terrace");
		List<Estudiante> e = new ArrayList<>();
		e.add(auxiliar);
		auxiliar =  new Estudiante("Juliansito", "Gutierrez", "1B", "julian@email.com", "evergreen saca");
		e.add(auxiliar);
		auxiliar =  new Estudiante("Marina", "Sutiana", "1L", "marina@email.com", "Suipacha jose");
		e.add(auxiliar);
		List<Estudiante> e2 = new ArrayList<>();
		e2.addAll(e);
		
		/* Recorro la lista
		 * 
		 */
		for (Estudiante i: e) {
			System.out.println(i.tusDatos());
		}
		
		for (Estudiante i: e2) {
			System.out.println(i.tusDatos());
		}
		
		/* La modifico
		 * 
		 */
		auxiliar.setApellido("Modificado");
		
		/* la vuelvo a recorrer
		 * 
		 */
		for (Estudiante i: e) {
			System.out.println(i.tusDatos());
		}
			
		for (Estudiante i: e2) {
			System.out.println(i.tusDatos());
		}
		
		/* CONCLUSIÓNES: Al clonar la lista lo que se clona es la referencia del objeto es decir la direccion
		 * de memoria por ende si se modifica algun atributo del objeto el cambio impactara en ambas listas que
		 * tengan esa misma instancia del objeto. Al copiar una lista solo se copia la referencia del objeto.
		 */
		
		/* Existen 2 formas (al menos vistas en la teoria) de clonar una lista. Se puede utilizar el metodo "addAll()"
		 * haciendole new previamente a una lista nueva  o el metodo "clone()" la principal diferencia parte en que
		 * con clone se debe castear ya que devuelve un tipo generico Object.
		 */
		
		Scanner s = new Scanner(System.in);
		auxiliar = new Estudiante ("Marina", "Sutiana", "1L", "marina@email.com", "Suipacha jose");
		if (!e.contains(auxiliar)) {
			e.add(auxiliar);
		}
		else {
			System.out.println("Ya se encuentra");
		}
		s.close();
		
	}
	
	
	public static boolean esCapicua(ArrayList<Integer> lista) {
		int pos2 = lista.size();
		pos2 = pos2 - 1;
		int pos1 = 0;
		while (pos1 != pos2) {
			if (!(lista.get(pos1) == lista.get(pos2))) {
				return false;
			}
			else {
				pos1 = pos1 + 1;
				pos2 = pos2 - 1;
			}
		}
		return true;
	}
	
	
	
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>();
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while (n != -1) {
			a.add(n);
			n = s.nextInt();
		}
		for (Integer i: a) {
			System.out.println(i);
		}
		
		puntoD();
		System.out.println(esCapicua((ArrayList<Integer>)a ));
		s.close();
	}
}

/* B) La implementación seria identica ya que cambiaria solo el tipo de lista, esto no significa que un arraylist
 * funcione igual que un linkedlist sino que la implementacion en codigo seria similar.
 */

/* C) Sí, se puede hacer uso de iteradores para recorrer la lista
 */

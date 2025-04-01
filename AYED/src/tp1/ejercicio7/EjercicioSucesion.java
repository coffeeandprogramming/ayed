package tp1.ejercicio7;

import java.util.List;
import java.util.LinkedList;

public class EjercicioSucesion {
	public List<Integer> calcularSucesion (int n) {
		List<Integer> lista = new LinkedList<Integer>();
		calcularRecursivo(lista, n);
		return lista;
    }
	
	private void calcularRecursivo (List<Integer> lista, int n) {
		lista.add(n);
		if (n > 1) {
			if (n % 2 == 0) {
				n = n / 2;
				calcularRecursivo(lista, n);
			}
			else {
				n = 3 * n  + 1;
				calcularRecursivo(lista, n);
			}
	    }
	}


public static void main(String[] args) {
	EjercicioSucesion s = new EjercicioSucesion();
	List<Integer> lista;
	lista = s.calcularSucesion(6);
	for (Integer i: lista) {
		System.out.println(i);
	}
	
}


}
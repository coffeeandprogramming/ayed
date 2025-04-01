package tp1.ejercicio7;
import java.util.ArrayList;

public class InvertirArraylist {

	public void invertirArrayList(ArrayList<Integer> lista) {
		int pos2 = lista.size() - 1;
		int pos = 0;
		int valor = 0;
		for (Integer i: lista) {
			System.out.println(i);
		}
		invertirRecursivo(lista, pos2, pos, valor);
		for (Integer i: lista) {
			System.out.println(i);
		}
	}
	
	private void invertirRecursivo (ArrayList<Integer> lista, int pos2, int pos, int valor) {
		if (pos != pos2) {
			valor = lista.get(pos);
			lista.set(pos, lista.get(pos2));
			lista.set(pos2, valor);

			invertirRecursivo(lista, pos2-1, pos+1, valor);
		}
		
		
	}
	
	public static void main(String[] args) {
		InvertirArraylist s = new InvertirArraylist();
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		
		s.invertirArrayList(lista);
	}
}

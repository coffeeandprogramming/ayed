package tp1.ejercicio7;
import java.util.LinkedList;

public class SumaLinkedList {

	public int sumarLinkedList(LinkedList<Integer> lista) {
		int n = 0;
		int pos = 0;
		n = sumarRecursivo (lista, n, pos);
		return n;
	}
	
	private int sumarRecursivo(LinkedList<Integer> lista, int n, int pos) {
		n = lista.get(pos);
		if (pos < (lista.size()-1)) {
			n = n + sumarRecursivo(lista, n, pos+1);
		}
		return n;
	}
	
	public static void main (String[] args) {
		SumaLinkedList s = new SumaLinkedList();
		LinkedList<Integer> lista = new LinkedList<Integer>();
		lista.add(2);
		lista.add(4);
		lista.add(3);
		System.out.println (s.sumarLinkedList(lista));
	}
}

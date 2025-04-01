package tp1.ejercicio7;
import java.util.ArrayList;

public class CombinarOrdenado {
	public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
		ArrayList<Integer> listan = new ArrayList<>();
		int pos1 = 0;
		int pos2 = 0;
		while ((pos1 <= lista1.size()-1) && (pos2 <= lista2.size()-1)) {
			if (lista1.get(pos1) < lista2.get(pos2)) {
				listan.add(lista1.get(pos1));
				pos1++;
			}
			else {
				listan.add(lista2.get(pos2));
				pos2++;
			}
			
		}
		while (pos1 < lista1.size()) {
			listan.add(lista1.get(pos1));
			pos1++;
		}
		while (pos2 < lista2.size()) {
			listan.add(lista2.get(pos2));
			pos2++;
		}
		
		return listan;
		
	}
	
	public static void main(String[] args) {
		CombinarOrdenado s = new CombinarOrdenado();
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(-1);
		l1.add(-2);
		l1.add(-3);
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		l2.add(1);
		l2.add(2);
		l2.add(3);
		l2.add(4);
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.addAll(s.combinarOrdenado(l1, l2));
		
		for (Integer i: l1) {
			System.out.println(i);
		}
		for (Integer i: l2) {
			System.out.println(i);
		}
		for (Integer i: l) {
			System.out.println(i);
		}
	}

}

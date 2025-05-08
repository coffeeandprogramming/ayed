package tp3.ejercicio11;

import tp3.ejercicio1.GeneralTree;

import java.util.List;

import tp1.ejercicio8.Queue;

public class ParcialArboles {
	public static boolean resolver(GeneralTree<Integer> arbol) {
		boolean esCreciente = true;
		int nivel = 0;
		int cantActual = 0;
		GeneralTree<Integer> tree_aux;
		Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
		queue.enqueue(arbol);
		queue.enqueue(null);
		while (!queue.isEmpty() && esCreciente) {
			
			tree_aux = queue.dequeue();
			if (tree_aux != null) {
				cantActual++;
				if (tree_aux.hasChildren()) {
					List<GeneralTree<Integer>> children = tree_aux.getChildren();
					for (GeneralTree<Integer> child : children) {
						queue.enqueue(child);
					}	
				}		
			}
			else {
				if (!queue.isEmpty()) {
					nivel++;
					queue.enqueue(null);	
				}
				if ((cantActual != nivel)) {
					esCreciente = false;
				}
			}
		}
		return esCreciente;
	}
	// creo q se puede hacer más eficiente
	public static void main (String[] args) {
		
	}
}

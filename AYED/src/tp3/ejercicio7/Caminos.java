package tp3.ejercicio7;

import java.util.List;
import java.util.LinkedList;

import tp3.ejercicio5.GeneralTree;

public class Caminos {
	private GeneralTree<Integer> arbol;

	public Caminos(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}

	public GeneralTree<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}
	public List<Integer> caminoAHojaMasLejana () {
		List<Integer> max = new LinkedList<Integer>();
		List<Integer> actual = new LinkedList<Integer>();
		if (!this.arbol.isEmpty() && this.arbol.getData() != null) caminoAHojaMasLejanaRecursion(actual, max, this.arbol);
		return max;
	}
	
	private List<Integer> caminoAHojaMasLejanaRecursion (List<Integer> list, List<Integer> max, GeneralTree<Integer> tree) {
		list.add(tree.getData());
		if (tree.isLeaf()) {
			if (list.size() > max.size()) {
				max.clear();
				max.addAll(list);	
			}
			
		}
		else {
			List<GeneralTree<Integer>> children = tree.getChildren();
			for (GeneralTree<Integer> child : children) {
				max = caminoAHojaMasLejanaRecursion(list, max, child);
			}
			
		}
		return max;
	}
	
}

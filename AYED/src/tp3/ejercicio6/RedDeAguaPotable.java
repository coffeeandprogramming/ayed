package tp3.ejercicio6;

import java.util.List;
import tp3.ejercicio3.GeneralTree;

public class RedDeAguaPotable {
	private GeneralTree<Character> arbol;
	
	public RedDeAguaPotable(GeneralTree<Character> arbol) {
		this.arbol = arbol;
	}

	public double minimoCaudal(double caudal) {
		double min = Integer.MAX_VALUE;
		if ((this.arbol.isEmpty()) && (this.arbol != null)) minimoCaudalRecursion(caudal, min, this.arbol);
		return min;
	}
	
	private double minimoCaudalRecursion (double caudal, double min, GeneralTree<Character> tree) {
		if (tree.isLeaf()) {
			if (caudal < min) {
				min = caudal;
			}
		}
		else {
			List<GeneralTree<Character>> children = tree.getChildren();
			for (GeneralTree<Character> child : children) {
				min = minimoCaudalRecursion (caudal/children.size(), min, child);
			}
			
		}
		return min;
		
		
		
	}
}

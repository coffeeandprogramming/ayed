package parciales.parcialnivel;
import java.util.List;
import tp1.ejercicio8.Queue;
import java.util.LinkedList;

import tp3.ejercicio3.GeneralTree;


public class ParcialArboles {
	private GeneralTree<Integer> arbol;
	
	public ParcialArboles (GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public List<Integer> nivel (int num) {
		List<Integer> lista = new LinkedList<Integer>();
		return (arbol != null) && (!arbol.isEmpty()) ? recorrer(num, lista) : lista;
	}
	
	private List<Integer> recorrer (int num, List<Integer> lista) {
		GeneralTree<Integer> tree_aux;
		Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
		int cantNodos = 0;
		int cantHijos = 0;
		queue.enqueue(arbol);
		queue.enqueue(null);
		while (!queue.isEmpty()) {
			tree_aux = queue.dequeue();
			if (tree_aux != null) {
				cantNodos++;
				cantHijos = 0;
				if (tree_aux.hasChildren()) {
					List<GeneralTree<Integer>> children = tree_aux.getChildren();
					for (GeneralTree<Integer> child : children) {
						cantHijos++;
						queue.enqueue(child);
					}
					if (cantHijos == num) {
						lista.add(tree_aux.getData());
					}
				}
			}
			else {
				if (!queue.isEmpty()) {
					queue.enqueue(null);
					
				}
				if (cantNodos == lista.size()) {
					return lista;
				}
				else {
					lista.clear();
					cantNodos = 0;
				}
				
			}
			
		}
		return lista;
	}
	
	public static void main(String[] args) {
	    GeneralTree<Integer> root = new GeneralTree<>(10);

	    GeneralTree<Integer> n1 = new GeneralTree<>(8);
	    GeneralTree<Integer> n2 = new GeneralTree<>(-5);

	    GeneralTree<Integer> n3 = new GeneralTree<>(5);
	    GeneralTree<Integer> n4 = new GeneralTree<>(22);
	    GeneralTree<Integer> n5 = new GeneralTree<>(19);

	    GeneralTree<Integer> n6 = new GeneralTree<>(-6);
	    GeneralTree<Integer> n7 = new GeneralTree<>(2);
	    GeneralTree<Integer> n8 = new GeneralTree<>(8);

	    GeneralTree<Integer> n9 = new GeneralTree<>(6);
	    GeneralTree<Integer> n10 = new GeneralTree<>(28);
	    GeneralTree<Integer> n11 = new GeneralTree<>(55);

	    GeneralTree<Integer> n12 = new GeneralTree<>(18);

	    GeneralTree<Integer> n13 = new GeneralTree<>(-4);
	    GeneralTree<Integer> n14 = new GeneralTree<>(2);
	    // Armar el árbol desde abajo hacia arriba
	    n3.addChild(n6);
	    n3.addChild(n7);
	    n3.addChild(n8);

	    n4.addChild(n9);
	    n4.addChild(n10);
	    n4.addChild(n11);

	    n5.addChild(n12);
	    n5.addChild(n13);
	    n5.addChild(n14);
	    

	    n1.addChild(n3);
	    n1.addChild(n4);

	    n2.addChild(n5);

	    root.addChild(n1);
	    root.addChild(n2);

	    System.out.println("Árbol general creado con raíz: " + root.getData());
	    ParcialArboles test = new ParcialArboles(root);
	    List<Integer> lista = new LinkedList<Integer>();
	    lista = test.nivel(3);
	    if (!lista.isEmpty()) {
	    	for (Integer elem : lista) {
	    		System.out.println(elem);
	    	}
	    }
	    else {
	    	System.out.println("Lista Vacia");
	    }
	}
}

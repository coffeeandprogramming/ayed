package tp3.ejercicio2;
import java.util.*;

public class RecorridosAG {

	
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n) {
		List<Integer> lista = new ArrayList<Integer>();
		if (!(a.isEmpty())) {
			numerosImparesMayoresQuePreOrdenRecursivo (lista, a, n);
		}
		return lista;
	}
	
	private void numerosImparesMayoresQuePreOrdenRecursivo (List<Integer> lista, GeneralTree <Integer> a, Integer n) {
		if ((a.getData() % 2 != 0) & (a.getData() > n)) {
			lista.add(a.getData());
		}
		List<GeneralTree<Integer>> children = a.getChildren();
		for (GeneralTree<Integer> child : children) {
			this.numerosImparesMayoresQuePreOrdenRecursivo(lista, child, n);
		}
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n) {
		List<Integer> lista = new ArrayList<Integer>();
		if (!(a.isEmpty())) {
			numerosImparesMayoresQueInOrdenRecursivo (lista, a, n);
		}
		return lista;
	}
	
	private void numerosImparesMayoresQueInOrdenRecursivo (List<Integer> lista, GeneralTree <Integer> a, Integer n) {
		
		List<GeneralTree<Integer>> children = a.getChildren();
		Iterator<GeneralTree<Integer>> it = children.iterator();
		
		if (it.hasNext()) {
			numerosImparesMayoresQueInOrdenRecursivo(lista, it.next(), n);
		}
		
		if ((a.getData() % 2 != 0) & (a.getData() > n)) {
			lista.add(a.getData());
		}
		
		while (it.hasNext()) {
			numerosImparesMayoresQueInOrdenRecursivo(lista, it.next(), n);
		}	
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n) {
		List<Integer> lista = new ArrayList<Integer>();
		if (!(a.isEmpty())) {
			numerosImparesMayoresQuePostOrdenRecursivo (lista, a, n);
		}
		
		return lista;
	}
	
	private void numerosImparesMayoresQuePostOrdenRecursivo (List<Integer> lista, GeneralTree <Integer> a, Integer n) {
		
		List<GeneralTree<Integer>> children = a.getChildren();
		for (GeneralTree<Integer> child : children) {
			this.numerosImparesMayoresQuePreOrdenRecursivo(lista, child, n);
		}
		
		if ((a.getData() % 2 != 0) & (a.getData() > n)) {
			lista.add(a.getData());
		}
	}
	
	public List<Integer> NumerosImparesMayoresQuePorNiveles (GeneralTree<Integer> a, Integer n) {
		List<Integer> result = new LinkedList<Integer>();
		GeneralTree<Integer> tree_aux;
		Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
		queue.enqueue(a);
		while (!queue.isEmpty()) {
			tree_aux = queue.dequeue();
			if ((tree_aux.getData() % 2 != 0) & (tree_aux.getData() > n)) {
				result.add(tree_aux.getData());
			}
			List<GeneralTree<Integer>> children = tree_aux.getChildren();
			for	(GeneralTree<Integer> child : children) {
				queue.enqueue(child);
			}
		}
		return result;
	}
	
	
	/* B) si fuera en el procedimiento principal mepa que usaria el mismo arbol tipo lo llamaria a si mismos con this. y no pediria a los procedimientos publicos un arbol.
	
}

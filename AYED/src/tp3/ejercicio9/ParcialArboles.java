package tp3.ejercicio9;


import java.util.*;
import tp3.ejercicio3.GeneralTree;

public class ParcialArboles {

	
	public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
		Minimo min = new Minimo(Integer.MAX_VALUE);
		return (arbol != null && !arbol.isEmpty()) ? esDeSeleccionRecursion(arbol, true, min) : false;
	}
	
	private static boolean esDeSeleccionRecursion (GeneralTree<Integer> arbol, boolean resultado, Minimo min) {
		if (!arbol.isLeaf()) {	
			min.setValor(Integer.MAX_VALUE);
			List<GeneralTree<Integer>> children = arbol.getChildren();
			Iterator<GeneralTree<Integer>> it = children.iterator();
			int hijoMenor = Integer.MAX_VALUE;
			while (it.hasNext() && resultado) {
				GeneralTree<Integer> child = it.next();
				
				resultado = esDeSeleccionRecursion(child, resultado, min);
			}
			if (arbol.getData() == min.getValor()) {
				resultado = true;
			}
			else {
				resultado = false;
			}		
		}
		else {
			resultado = true;
		}
		minimo(arbol, min);
		return resultado;
		
	}
	
	private static Minimo minimo (GeneralTree<Integer> arbol, Minimo min) {
		if (arbol.getData() < min.getValor()) {
			min.setValor(arbol.getData());
		}
		return min;
	}
	
	public static void main (String[] args) {
		GeneralTree<Integer> root = new GeneralTree<>(12);

        GeneralTree<Integer> n1 = new GeneralTree<>(12);
        GeneralTree<Integer> n2 = new GeneralTree<>(25);

        GeneralTree<Integer> n3 = new GeneralTree<>(35);
        GeneralTree<Integer> n4 = new GeneralTree<>(12);

        GeneralTree<Integer> n5 = new GeneralTree<>(25);

        GeneralTree<Integer> n6 = new GeneralTree<>(35);
        GeneralTree<Integer> n7 = new GeneralTree<>(14);
        GeneralTree<Integer> n8 = new GeneralTree<>(12);
        GeneralTree<Integer> n9 = new GeneralTree<>(33);

        GeneralTree<Integer> n10 = new GeneralTree<>(35);
        GeneralTree<Integer> n11 = new GeneralTree<>(83);
        GeneralTree<Integer> n12 = new GeneralTree<>(90);
        GeneralTree<Integer> n13 = new GeneralTree<>(33);

        // Armar el árbol desde abajo hacia arriba
        n3.addChild(n6); // 35 -> 35

        n4.addChild(n7); // 12 -> 14
        n4.addChild(n8); // 12 -> 12
        n4.addChild(n9); // 12 -> 33

        n9.addChild(n10); // 33 -> 35
        n9.addChild(n11); // 33 -> 83
        n9.addChild(n12); // 33 -> 90
        n9.addChild(n13); // 33 -> 33

        n1.addChild(n3); // 12 -> 35
        n1.addChild(n4); // 12 -> 12

        n2.addChild(n5); // 25 -> 25

        root.addChild(n1); // root -> 12
        root.addChild(n2); // root -> 25

        System.out.println("Árbol general creado con raíz: " + root.getData());
        System.out.println ("Es de seleccion?" + esDeSeleccion(root));
	}
}

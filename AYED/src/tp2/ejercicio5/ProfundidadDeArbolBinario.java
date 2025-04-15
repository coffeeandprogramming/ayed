package tp2.ejercicio5;

import tp1.ejercicio8.Queue;
import tp2.ejercicio1.BinaryTree;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> arbol;
	
	public ProfundidadDeArbolBinario (BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}

	public int sumaElementosProfundidad (int p) {
		int suma = 0;
		BinaryTree<Integer> ab = null;
		Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
		cola.enqueue(this.arbol);
		cola.enqueue(null);
		while (!cola.isEmpty() && p > 0)  {
			ab = cola.dequeue();
			if (ab != null) {
				
				if (ab.hasLeftChild()) {
					cola.enqueue(ab.getLeftChild());
				}
				if (ab.hasRightChild()) {
					cola.enqueue(ab.getRightChild());
				}
		
			}
			else if (!cola.isEmpty()) {
				p--;
				cola.enqueue(null);
			}
	   }
		while (!cola.isEmpty())  {
			ab = cola.dequeue();
			if (ab != null) {
				suma += ab.getData();
			}
			else {
				break;
			}
		}
		return suma;
		
	}
	
	public static void main (String[] args) {
		BinaryTree<Integer> arbol = new BinaryTree<Integer>(2);
		BinaryTree<Integer> HI = new BinaryTree<Integer>(4);
		BinaryTree<Integer> HD = new BinaryTree<Integer>(6);
		BinaryTree<Integer> HI1 = new BinaryTree<Integer>(8);
		BinaryTree<Integer> HD1 = new BinaryTree<Integer>(1);
		BinaryTree<Integer> HI2 = new BinaryTree<Integer>(1);
		BinaryTree<Integer> HD2 = new BinaryTree<Integer>(1);
		
		BinaryTree<Integer> HI1I = new BinaryTree<Integer>(1);
		BinaryTree<Integer> HI1D = new BinaryTree<Integer>(2);
		BinaryTree<Integer> HD1I = new BinaryTree<Integer>(4);
		BinaryTree<Integer> HD1D = new BinaryTree<Integer>(10);
		
		BinaryTree<Integer> HI2I = new BinaryTree<Integer>(90);
		BinaryTree<Integer> HI2D = new BinaryTree<Integer>(1);
		BinaryTree<Integer> HD2I = new BinaryTree<Integer>(2);
		BinaryTree<Integer> HD2D = new BinaryTree<Integer>(4);
		arbol.addLeftChild(HI);
		arbol.addRightChild(HD);
		
		HI.addLeftChild(HI1);
		HI.addRightChild(HD1);
		HD.addLeftChild(HI2);
		HD.addRightChild(HD2);
		
		HI1.addLeftChild(HI1I);
		HI1.addRightChild(HI1D);
		HD1.addLeftChild(HD1I);
		HD1.addRightChild(HD1D);
		
		HI2.addLeftChild(HI2I);
		HI2.addRightChild(HI2D);
		HD2.addLeftChild(HD2I);
		HD2.addRightChild(HD2D);
		
		ProfundidadDeArbolBinario pr = new ProfundidadDeArbolBinario(arbol);
		System.out.println(pr.sumaElementosProfundidad(2));
	}
}

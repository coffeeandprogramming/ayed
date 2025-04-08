package tp2.ejercicio3;


import java.util.*;
import tp2.ejercicio2.BinaryTree;

public class ContadorArbol {
BinaryTree<Integer> arbol;

public ContadorArbol (BinaryTree<Integer> arbol) {
	this.arbol = arbol;
}
	

	public void contadorPares() {
		List<Integer> cant = new ArrayList<Integer>();
		inOrden(cant, this.arbol);
		for (Integer i: cant) {
			System.out.println(i);
		}
		cant.removeAll(cant);
		postOrden(cant, this.arbol);
		for (Integer i: cant) {
			System.out.println(i);
		}
	}
	
	public List<Integer> inOrden (List<Integer> cant, BinaryTree<Integer> arbol) {
		if (arbol.hasLeftChild()) {
			inOrden(cant, arbol.getLeftChild());		
		}
		
		if (arbol.getData() % 2 == 0) {
			cant.add(arbol.getData());
		}
		
		if (arbol.hasRightChild()) {
			inOrden(cant, arbol.getRightChild());
			}	
		return cant;
	}
	
	public List<Integer> postOrden (List<Integer> cant, BinaryTree<Integer> arbol) {
		if (arbol.hasLeftChild()) {
			postOrden(cant, arbol.getLeftChild());		
		}
		if (arbol.hasRightChild()) {
			postOrden(cant, arbol.getRightChild());
			}
		if (arbol.getData() % 2 == 0) {
			cant.add(arbol.getData());
		}
		return cant;	
	}
	
	


public static void main (String[] args) {
	BinaryTree<Integer> arbol = new BinaryTree<Integer>(2);
	BinaryTree<Integer> HI = new BinaryTree<Integer>(4);
	BinaryTree<Integer> HD = new BinaryTree<Integer>(6);
	BinaryTree<Integer> HI1 = new BinaryTree<Integer>(8);
	BinaryTree<Integer> HD1 = new BinaryTree<Integer>(1);
	BinaryTree<Integer> HI2 = new BinaryTree<Integer>(1);
	BinaryTree<Integer> HD2 = new BinaryTree<Integer>(1);
	arbol.addLeftChild(HI);
	arbol.addRightChild(HD);
	HI.addLeftChild(HI1);
	HI.addRightChild(HD1);
	HD.addLeftChild(HI2);
	HD.addRightChild(HD2);
	
	ContadorArbol c = new ContadorArbol(arbol);
	c.contadorPares();
}
}
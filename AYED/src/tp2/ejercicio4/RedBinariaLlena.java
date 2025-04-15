package tp2.ejercicio4;

import tp2.ejercicio2.BinaryTree;

public class RedBinariaLlena {

	
	// Utilice un recorrido en profundidad ya que hay que recorrer el arbol hijo por hijo y me parece de implementacion más simple que por niveles.
	
	public int retardoReenvio (BinaryTree<Integer> arbol) {
		int total1 = arbol.getData();
		int total2 = arbol.getData();
		if (!arbol.isLeaf()) {
			total1 += retardoReenvio(arbol.getRightChild());
			total2 += retardoReenvio(arbol.getLeftChild());
		}
		
		if (total1 > total2) {
			return total1;
		}
		else {
			return total2;
		}
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
	
	RedBinariaLlena test = new RedBinariaLlena();
	System.out.println(test.retardoReenvio(arbol));
}

}
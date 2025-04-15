package tp2.ejercicio6;

import tp2.ejercicio1.BinaryTree;

public class Transformacion {
	BinaryTree<Integer> arbol;
	public Transformacion (BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public BinaryTree<Integer> suma () {
		sumaRecursiva(this.arbol);
		return this.arbol;
	}
	
	private int sumaRecursiva (BinaryTree<Integer> arbol) {
		int suma = arbol.getData();

	    if (arbol.hasRightChild()) {
	    	suma += sumaRecursiva(arbol.getRightChild());
			
		}
		
		if (arbol.hasLeftChild()) {
			suma += sumaRecursiva(arbol.getLeftChild());
			
			}
		arbol.setData(suma - arbol.getData());
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
		
		Transformacion n = new Transformacion(arbol);
		arbol = n.suma();
		System.out.println(arbol.getData());
  }
}

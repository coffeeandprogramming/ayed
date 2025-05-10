package parcial.parcialnuevotree;

import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> arbol;

	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public BinaryTree<Integer> nuevoTree() {
		return (this.arbol != null) && (!this.arbol.isEmpty()) ? nuevoTreeRecursivo (this.arbol) : null;
	}
	
	private BinaryTree<Integer> nuevoTreeRecursivo (BinaryTree<Integer> tree) {
		BinaryTree<Integer> nuevo = new BinaryTree<Integer>(tree.getData());
		if (!tree.isLeaf()) {
			if (tree.hasLeftChild()) {
				nuevo.addLeftChild(nuevoTreeRecursivo(tree.getLeftChild()));
				nuevo.getLeftChild().setData(nuevo.getLeftChild().getData() + nuevo.getData());
			}
			
			if (tree.hasRightChild()) {
				nuevo.addRightChild(nuevoTreeRecursivo(tree.getRightChild()));
			}
		}
		return nuevo;
	}
	
	public static void main (String[] args) {
		BinaryTree<Integer> raiz = new BinaryTree<Integer>(0);
		BinaryTree<Integer> n1 = new BinaryTree<Integer>(1);
		BinaryTree<Integer> n2 = new BinaryTree<Integer>(2);
		BinaryTree<Integer> n3 = new BinaryTree<Integer>(3);
		raiz.addLeftChild(n1);
		raiz.addRightChild(n2);
		n2.addLeftChild(n3);
		ParcialArboles test = new ParcialArboles(raiz);
		BinaryTree<Integer> raiz2;
		raiz2 = test.nuevoTree();
		System.out.println("test.");
		
		
	}
}

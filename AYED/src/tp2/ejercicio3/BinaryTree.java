package tp2.ejercicio3;

import tp1.ejercicio8.Queue;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
		int cant = 0;
		BinaryTree<T> ab = null;
		Queue<BinaryTree<T>> cola = new Queue <BinaryTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			ab = cola.dequeue();
			if (ab != null) {
				cant++;
				if (ab.hasLeftChild()) {
					cola.enqueue(ab.getLeftChild());
				}
				if (ab.hasRightChild()) {
					cola.enqueue(ab.getLeftChild());	
				}
				
			}
			else if (!cola.isEmpty()) {
				cola.enqueue(null);
			}
		}
		
		return cant;
	}
		
		
    	 
    public BinaryTree<T> espejo(){
    	
    	if (this.data != null && this.isLeaf()) {
    		BinaryTree<T> raiz = new BinaryTree<T>();
    		raiz.setData(data);
    		return raiz;
    		
    	}
    	else if (data != null) {
    		if (this.hasLeftChild()) {
    			BinaryTree<T> ab = new BinaryTree<T>();
    			ab.setData(this.getLeftChild().getData());
    			this.addRightChild(ab);
    			
    		}
    		
    		
    	}
		       		  
 	   return null;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		
   }
		
}


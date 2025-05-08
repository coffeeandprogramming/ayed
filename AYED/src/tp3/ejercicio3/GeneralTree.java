package tp3.ejercicio3;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;
import tp1.ejercicio8.Queue;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 
		int longMax = Integer.MAX_VALUE;
		if (!this.isEmpty()) alturaRecursivo(this, 0, longMax);
		return longMax;
	}
	
	private int alturaRecursivo (GeneralTree<T> a, int longAct, int longMax) {
		longAct++;
		if (this.isLeaf()) {
			if (longAct > longMax) {
				longMax = longAct;
			}
		}
		else {
			List<GeneralTree<T>> children = this.getChildren();
		
			for (GeneralTree<T> child : children) {
				longMax = alturaRecursivo(child, longAct, longMax);
			}	
		}
		return longMax;	
	}	
	
	public int nivel(T dato){
		int sumaNivel = 0;
		boolean encontre = false;
		GeneralTree<T> aux;
		Queue <GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue (this);
		cola.enqueue(null);
		while(!cola.isEmpty() && !encontre) {
			aux = cola.dequeue();
			if (aux != null) {
				if (aux.getData() == dato) {
					encontre = true;
				}
				else {
					List<GeneralTree<T>> children = aux.getChildren();
					for (GeneralTree<T> child : children) {
						cola.enqueue(child);
					}
				}
			}
			else {
				if (!cola.isEmpty()) {
					sumaNivel++;
					cola.enqueue(null);
				}
			}
					
		}
		return encontre == true ? sumaNivel : -1;
	  }
	
	
		
		
	

	public int ancho(){
		int cant = 0;
		int cantMax = Integer.MIN_VALUE;
		GeneralTree<T> aux;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			aux = cola.dequeue();
			if (aux != null) {
				cant++;
				List<GeneralTree<T>> children = aux.getChildren();
				for (GeneralTree <T> child : children) {
					cola.enqueue(child);
				}
			}
			else {
				if (!cola.isEmpty()) {
					cola.enqueue(null);
				}
				if (cant > cantMax) {
					cantMax = cant;
				}
				cant = 0;
			}
		}
		
		return cantMax;																									
	}
	
	public static void main(String[] args) {
		  // Nivel 5 - 11 nodos
	    GeneralTree<Integer> n8 = new GeneralTree<>(8);
	    GeneralTree<Integer> n9 = new GeneralTree<>(9);
	    GeneralTree<Integer> n10 = new GeneralTree<>(10);
	    GeneralTree<Integer> n11 = new GeneralTree<>(11);
	    GeneralTree<Integer> n12 = new GeneralTree<>(12);
	    GeneralTree<Integer> n13 = new GeneralTree<>(13);
	    GeneralTree<Integer> n14 = new GeneralTree<>(14);
	    GeneralTree<Integer> n15 = new GeneralTree<>(15);
	    GeneralTree<Integer> n16 = new GeneralTree<>(16);
	    GeneralTree<Integer> n17 = new GeneralTree<>(17);
	    GeneralTree<Integer> n18 = new GeneralTree<>(18);

	    // Nivel 4 - nodo 7 con 11 hijos
	    GeneralTree<Integer> n7 = new GeneralTree<>(7);
	    n7.addChild(n8);
	    n7.addChild(n9);
	    n7.addChild(n10);
	    n7.addChild(n11);
	    n7.addChild(n12);
	    n7.addChild(n13);
	    n7.addChild(n14);
	    n7.addChild(n15);
	    n7.addChild(n16);
	    n7.addChild(n17);
	    

	    // Nivel 3
	    GeneralTree<Integer> n4 = new GeneralTree<>(4);
	    GeneralTree<Integer> n5 = new GeneralTree<>(5);
	    n5.addChild(n7);  // El nodo 5 es el que lleva a los 11 hijos
	    GeneralTree<Integer> n6 = new GeneralTree<>(6);
	    n6.addChild(n18);
	    // Nivel 2
	    GeneralTree<Integer> n3 = new GeneralTree<>(3);
	    n3.addChild(n4);
	    n3.addChild(n5);
	    n5.addChild(n6);

	    // Nivel 1
	    GeneralTree<Integer> n2 = new GeneralTree<>(2);
	    n2.addChild(n3);

	    // Raíz
	    GeneralTree<Integer> root = new GeneralTree<>(1);
	    root.addChild(n2);

	    // Ejecutar ancho
	    System.out.println("El ancho del árbol es: " + root.ancho());  // Debe imprimir 11
	}
}
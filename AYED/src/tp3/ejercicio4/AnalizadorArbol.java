package tp3.ejercicio4;

import tp3.ejercicio3.GeneralTree;
import tp1.ejercicio8.Queue;
import java.util.List;

public class AnalizadorArbol {
  
	// Uso el recorrido por niveles ya que tengo que conseguir el mayor promedio de los promedios de cada nivel que se consiguen sumando los elementos del mismo, no tengo que devolver un camino ni nada que requiera saber de quien es hijo cada nodo. Además que un algoritmo iterativo es mejor que uno recursivo en terminos de memoria.
	
	public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
		int cant = 0;
		int suma = 0;
		double maxProm = 0;
		GeneralTree<AreaEmpresa> tree_aux;
		Queue<GeneralTree<AreaEmpresa>> queue = new Queue<GeneralTree<AreaEmpresa>>();
		queue.enqueue(arbol);
		queue.enqueue(null);
		while (!queue.isEmpty()) {
			tree_aux = queue.dequeue();
			if (tree_aux != null) {
				cant++;
				suma += tree_aux.getData().getDelay();
				List<GeneralTree<AreaEmpresa>> children = tree_aux.getChildren();
				for (GeneralTree<AreaEmpresa> child : children) {
					queue.enqueue(child);
				}	
			}
			else {
				if ((suma / cant) > maxProm ) {
					maxProm = suma/cant;
				}
				if (!queue.isEmpty()) {
					queue.enqueue(null);
					cant = 0;
					suma = 0;
				}
				
			}
		}
		return maxProm;
	}
	
	
	public static void main (String[] args) {
		GeneralTree<AreaEmpresa> raiz = new GeneralTree<AreaEmpresa>(new AreaEmpresa("a", 2));
		GeneralTree<AreaEmpresa> n2 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("b", 3));
		GeneralTree<AreaEmpresa> n3 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("c", 3));
		GeneralTree<AreaEmpresa> n4 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("c", 4));
		GeneralTree<AreaEmpresa> n9 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("b", 30));
		GeneralTree<AreaEmpresa> n99 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("c", 30));
		n2.addChild(n9);
		n3.addChild(n99);
		raiz.addChild(n2);
		raiz.addChild(n3);
		raiz.addChild(n4);
		AnalizadorArbol prueba = new AnalizadorArbol();
		System.out.println("Maximo promedio: " + prueba.devolverMaximoPromedio(raiz));
		
	}
	
	
	
}

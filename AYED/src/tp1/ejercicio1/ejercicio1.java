package tp1.ejercicio1;

public class ejercicio1 {
private int a;
private int b;

public ejercicio1(int a, int b) {
	this.a = a;
	this.b = b;
}

public static void pedidoFor (int a, int b) {
	for (int i = a; i < b; i++) {
		System.out.println(i);
	}
}

public static void pedidoWhile (int a, int b) {
	int i = a +1;
	while (i < b) {
		System.out.println(i);
		i++;
	}
}

public static void pedidoSin (int a, int b) {
	a = a + 1;
	pedidoRecursion(a, b);
	return;
}

private static void pedidoRecursion (int a, int b) {
	if (a >= b) {
		return;
	}
	else {
		System.out.println(a);
		pedidoRecursion(a+1, b);
}
}


public static void main(String[] args) {
	int a = 1;
	int b = 5;
	pedidoSin(a, b);
}
}

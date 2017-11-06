package tp3;

public class Ejercicio1 {

	
	/**
	 * a) 
	 * Pila orig --->  Cola (igual orden)     
	 * 			 |-->  Pila (invertido)
	 * 
	 * Comparo y si hasta la mitad son iguales quiere decir que son capicua		
	 * 
	 * b) Tomo la pila dada A, la paso a otra B (para que se invierta); creo la pila destino y un conjunto. 
	 * 
	 *  . tomo el tope de B y lo pongo en el conjunto
	 *  . lo agrego a la pila destino
	 *  . desapilo B
	 *  
	 *  . tomo el tope de B, pregunto si esta en el conjunto
	 *  . si esta: no lo agrego al conjunto ni a la pila
	 *  . si no esta: lo agrego al conjunto y a la pila
	 *  . desapilo B
	 *  
	 * c) Para conocer la cantidad de elementos: Tomo la pila, la paso a una cola, cuando hago esto cuento los
	 * elementos.
	 * 
	 * d) Misma estrategia que en b pero acorde a lo que pide  
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
				
		int result = 9 / 2;
		
		System.out.println("El resultado es: " + result);
		
		System.exit(0);
	}
}

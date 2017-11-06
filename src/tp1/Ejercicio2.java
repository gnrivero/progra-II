package tp1;

import impl.estaticos.basicos.PilaTI;
import utils.PilaUtils;
import api.basicos.PilaTDA;


public class Ejercicio2 {

	public static void main(String[] args) {
				
		ejercicio2e();
		
		System.exit(0);
	}
	
	
	/**
	 * Pasar una Pila a otra (dejándola en orden inverso)
	 */
	private static void ejercicio2a(){

		PilaTDA pila = new PilaTI();
		pila.InicializarPila();
		
		pila.Apilar(5);
		pila.Apilar(2);
		pila.Apilar(10);
		pila.Apilar(7);
		
		
		PilaTDA pila2 = new PilaTI();
		pila2.InicializarPila();
				
		PilaUtils.pasarPila(pila, pila2);
	}
	
	
	/**
	 * Pasar una pila a otra dejándola en el mismo orden
	 */
	private static void ejercicio2b(){
		
		PilaTDA pila = new PilaTI();
		pila.InicializarPila();
		
		pila.Apilar(5);
		pila.Apilar(2);
		pila.Apilar(10);
		pila.Apilar(7);
		
		
		PilaTDA pilaDestino = new PilaTI();
		pilaDestino.InicializarPila();
		
		PilaTDA pilaAux = new PilaTI();
		pilaAux.InicializarPila();
						

		PilaUtils.pasarPila(pila, pilaAux);
		PilaUtils.pasarPila(pilaAux, pilaDestino);
	}
	
	
	/**
	 * Contar elementos de una pila
	 */
	private static void ejercicio2d() {
		
		PilaTDA pila = new PilaTI();
		pila.InicializarPila();
		
		pila.Apilar(5);
		pila.Apilar(2);
		pila.Apilar(10);
		pila.Apilar(7);
		
		int contador = 0;
		while (!pila.PilaVacia()){
			contador++;
			pila.Desapilar();
		}
		
		System.out.println("La pila tiene " + contador + " elementos" );
		
	}
	
	
	/**
	 * Sumar elementos de una pila
	 */
	private static void ejercicio2e() {
		
		PilaTDA pila = new PilaTI();
		pila.InicializarPila();
		
		pila.Apilar(5);
		pila.Apilar(2);
		pila.Apilar(10);
		pila.Apilar(7);
		
		int contador = 0;
		while (!pila.PilaVacia()){
			contador = pila.Tope() + contador;
			pila.Desapilar();
		}
		
		System.out.println("La pila suma un valor de  " + contador );
		
	}
	
}
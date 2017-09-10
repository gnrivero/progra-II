package tp1;

import utils.ColaUtils;
import utils.PilaUtils;
import api.ColaTDA;
import api.PilaTDA;
import impl.ColaPI;
import impl.ColaPU;
import impl.PilaTF;

public class TP_I_Cola {

	public static void main(String[] args) {				
		
		ejercicio4c();
		
		System.exit(0);
	}
	
	/**
	 * Pasar una cola a la otra
	 * 
	 * @return
	 */
	private static boolean ejercicio4a() {
		
		ColaTDA cola = new ColaPU();
		cola.InicializarCola();
		
		cola.Acolar(1);
		cola.Acolar(2);
		cola.Acolar(3);
		cola.Acolar(4);
		
		ColaTDA colaDestino = new ColaPU();
		colaDestino.InicializarCola();
	
		ColaUtils.pasarCola(cola, colaDestino);	
		
		return true;
	}
	
	/**
	 * Invertir cola
	 * 
	 * @return
	 */
	private static boolean ejercicio4b(){
		
		ColaTDA cola = new ColaPU();
		cola.InicializarCola();
		
		cola.Acolar(1);
		cola.Acolar(2);
		cola.Acolar(3);
		cola.Acolar(4);
		
		System.out.println("Primero de la cola original " + cola.Primero());
		
		PilaTDA pilaAux = new PilaTF();
		pilaAux.InicializarPila();
		
		ColaTDA colaDestino = new ColaPU();
		colaDestino.InicializarCola();
		
		
		ColaUtils.pasarCola(cola, pilaAux);		
		PilaUtils.pasarPila(pilaAux, colaDestino);
		
		System.out.println("Primero de la cola destino " + colaDestino.Primero());
		
		return true;
	}
	
	/**
	 * Invertir cola sin pilas auxiliares
	 * 
	 * @return
	 */
	private static boolean ejercicio4c(){
		
		ColaTDA cola = new ColaPU();
		cola.InicializarCola();
		
		cola.Acolar(1);
		cola.Acolar(2);
		cola.Acolar(3);
		cola.Acolar(4);
		
		System.out.println("Primero de la cola original " + cola.Primero());
		
		ColaTDA colaDestino = new ColaPI();
		colaDestino.InicializarCola();
		
		ColaUtils.pasarCola(cola, colaDestino);
		
		
		System.out.println("Primero de la cola destino " + colaDestino.Primero());
		
		return true;
	}
}
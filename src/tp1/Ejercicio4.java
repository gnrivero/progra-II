package tp1;

import impl.estaticos.basicos.ColaPI;
import impl.estaticos.basicos.ColaPU;
import impl.estaticos.basicos.PilaTF;
import utils.ColaUtils;
import utils.PilaUtils;
import api.basicos.ColaTDA;
import api.basicos.PilaTDA;

public class Ejercicio4 {

	public static void main(String[] args) {				
		
		ColaTDA cola1 = new ColaPU();
		ColaTDA cola2 = new ColaPU();
	
		cola1.InicializarCola();
		cola2.InicializarCola();
		
		cola1.Acolar(10);
		cola1.Acolar(8);
		cola1.Acolar(24);
		cola1.Acolar(59);
		cola1.Acolar(90);
		cola1.Acolar(43);

		cola2.Acolar(59);
		cola2.Acolar(24);
		cola2.Acolar(8);
		cola2.Acolar(10);
		//cola2.Acolar(90);
		
		String mensaje = "No es inversa";
				
		if( esInversa(cola1, cola2) )
			mensaje = "Es inversa";
				
		System.out.println(mensaje);
		
		System.exit(0);
	}
	
	/**
	 * Ejercicio 4f
	 * 
	 * @param cola1
	 * @param cola2
	 * @return
	 */
	private static boolean esInversa(ColaTDA cola1, ColaTDA cola2){
		
		
		PilaTDA pila = new PilaTF();
		pila.InicializarPila();
		
		while(!cola1.ColaVacia()){		
			pila.Apilar(cola1.Primero());
			cola1.Desacolar();			
		}
		
		boolean esInversa = true;
		
		while(!cola2.ColaVacia() && !pila.PilaVacia()){
			
			if(cola2.Primero() == pila.Tope()){				
				pila.Desapilar();
				cola2.Desacolar();		
			}else{
				esInversa = false;
				break;
			}			
		}
		
		if(!cola2.ColaVacia() || !pila.PilaVacia())
			esInversa = false;
		
		
		return esInversa;		
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
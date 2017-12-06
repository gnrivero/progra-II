package tp3;

import utils.ColaUtils;
import utils.PilaUtils;
import impl.dinamicos.basicos.ColaLD;
import impl.dinamicos.basicos.PilaLD;
import impl.dinamicos.conjuntos.ConjuntoLD;
import api.basicos.ColaTDA;
import api.basicos.PilaTDA;
import api.conjuntos.ConjuntoTDA;

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
	
	/**
	 * Permite conocer si una pila es capicúa
	 * 
	 * @param pila
	 * @return
	 */
	public static boolean punto_a(PilaTDA pila){
		
		//Utilizo esta cola para guardar los datos de la pila original
		ColaTDA colaCopia = new ColaLD();
		colaCopia.InicializarCola();
				
		PilaTDA pilaAux = new PilaLD();
		pilaAux.InicializarPila();
		
		ColaTDA colaAux = new ColaLD();
		colaAux.InicializarCola();
		
		
		int contadorElementos = 0;
		while(!pila.PilaVacia()){
			pilaAux.Apilar(pila.Tope());
			colaAux.Acolar(pila.Tope());
			
			colaCopia.Acolar(pila.Tope());
						
			pila.Desapilar();
			contadorElementos++;
		}
		
		int mitad = contadorElementos / 2;
		int index = 0;
		
		boolean esCapicua = true;
				
		while(esCapicua && index < mitad){
								
			if (colaAux.Primero() != pilaAux.Tope())
				esCapicua = false;
			
			colaAux.Desacolar();
			pilaAux.Desapilar();			
			
			index++;			
		}
		
		
		while(!colaCopia.ColaVacia()){
			pila.Apilar(colaCopia.Primero());
			colaCopia.Desacolar();
		}
		
		return esCapicua;
	}
	
	
	/**
	 * Elimina los repetidos de una pila
	 * @param pila
	 * @return
	 */
	public static PilaTDA punto_b(PilaTDA pila){
	
		PilaTDA pilaInvertida = new PilaLD();
		pilaInvertida.InicializarPila();
		
		PilaTDA pilaFinal = new PilaLD();
		pilaFinal.InicializarPila();
		
		ConjuntoTDA conjunto = new ConjuntoLD();
		conjunto.InicializarConjunto();
		
		//pasarPila(origen, destino)
		PilaUtils.pasarPila(pila, pilaInvertida);	
		
		pilaFinal.Apilar(pilaInvertida.Tope());
		conjunto.Agregar(pilaInvertida.Tope());
		pilaInvertida.Desapilar();
		
		while(!pilaInvertida.PilaVacia()){
			
			if(!conjunto.Pertenece(pilaInvertida.Tope())){
				conjunto.Agregar(pilaInvertida.Tope());
				pilaFinal.Apilar(pilaInvertida.Tope());				
			}			
			
			pilaInvertida.Desapilar();
		}
		
		return pilaFinal;
	}
	
	/**
	 * Parte una pila en dos mitades
	 * 
	 * @param pila
	 * @return
	 */
	public static int punto_c(PilaTDA pila){
		
		ColaTDA colaAux = new ColaLD();
		colaAux.InicializarCola();
		
		
		int cantidadDeElementos = 0;
		while(!pila.PilaVacia()){
			colaAux.Acolar(pila.Tope());
			pila.Desapilar();
			cantidadDeElementos++;
		}
		
		//Recupero la pila original
		ColaUtils.pasarCola(colaAux, pila);
		
		int mitad = cantidadDeElementos / 2;
		
		PilaTDA pilaMitad1 = new PilaLD();
		pilaMitad1.InicializarPila();
		PilaTDA pilaMitad2 = new PilaLD();
		pilaMitad2.InicializarPila();
		
		
		
		return cantidadDeElementos;
	}
	
	
	
}

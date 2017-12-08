package tp3;

import impl.dinamicos.basicos.ColaLD;
import impl.dinamicos.basicos.PilaLD;
import impl.dinamicos.conjuntos.ConjuntoLD;
import utils.PilaUtils;
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
		
		PilaTDA pila = new PilaLD();
		pila.InicializarPila();
		
		pila.Apilar(4);
		pila.Apilar(2);
		pila.Apilar(1);
		pila.Apilar(1);
		pila.Apilar(3);
		pila.Apilar(5);
		pila.Apilar(7);
		pila.Apilar(4);
		pila.Apilar(7);
		
		ConjuntoTDA repetidos = punto_d(pila);
		
		repetidos.Elegir();
		
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
	public static void punto_c(PilaTDA pila, PilaTDA pilaMitad1, PilaTDA pilaMitad2){
		
		PilaTDA pilaAux = new PilaLD();
		pilaAux.InicializarPila();
		
		
		int cantidadDeElementos = 0;
		while(!pila.PilaVacia()){
			pilaAux.Apilar(pila.Tope());
			pila.Desapilar();
			cantidadDeElementos++;
		}
		
		//Recupero la pila original
		PilaUtils.pasarPila(pilaAux, pila);
		
		int mitad = cantidadDeElementos / 2;
				
		pilaMitad1.InicializarPila();		
		pilaMitad2.InicializarPila();
		
		while (cantidadDeElementos > 0){
			
			if(cantidadDeElementos >= mitad){
				pilaMitad1.Apilar(pilaAux.Tope());
			}else{
				pilaMitad2.Apilar(pilaAux.Tope());
			}
			
			cantidadDeElementos--;
		}
		
	}
	
	/**
	 * Genera un conjunto de elementos repetidos de una pila
	 * 
	 * @return
	 */
	public static ConjuntoTDA punto_d(PilaTDA pila){
		
		ConjuntoTDA conjuntoAux = new ConjuntoLD();
		conjuntoAux.InicializarConjunto();
		ConjuntoTDA conjuntoDeRepetidos = new ConjuntoLD();
		conjuntoDeRepetidos.InicializarConjunto();
		
		PilaTDA pilaAux = new PilaLD();
		pilaAux.InicializarPila();
		
		PilaUtils.pasarPila(pila, pilaAux);
		
		
		conjuntoAux.Agregar(pilaAux.Tope());
		pila.Apilar(pilaAux.Tope());//para recuperar la pila original
		pilaAux.Desapilar();
		
		while(!pilaAux.PilaVacia()){
			
			if(conjuntoAux.Pertenece(pilaAux.Tope()))
				conjuntoDeRepetidos.Agregar(pilaAux.Tope()); 
						
			conjuntoAux.Agregar(pilaAux.Tope());			
			
			pila.Apilar(pilaAux.Tope());//para conservar la pila original 
			pilaAux.Desapilar();
		}
		
		return conjuntoDeRepetidos;
	}
	
	
	
}

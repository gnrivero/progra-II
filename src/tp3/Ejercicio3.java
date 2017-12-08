package tp3;

import impl.dinamicos.basicos.ColaLD;
import impl.dinamicos.basicos.PilaLD;
import impl.dinamicos.conjuntos.ConjuntoLD;
import utils.ColaUtils;
import utils.ConjuntoUtils;
import utils.PilaUtils;
import api.basicos.ColaTDA;
import api.basicos.PilaTDA;
import api.conjuntos.ConjuntoTDA;

public class Ejercicio3 {
	
	/**
	 * FALTAN: b, c , g
	 * 
	 * 
	 * e) Calcular cardinalidad
	 * 	. Elijo
	 * 	. Lo copio (cuento)
	 * 	. Lo saco
	 * 
	 * f) Paso la pila a un conjunto, la cola al mismo conjunto y calculo 
	 * la interseccion
	 * 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		ConjuntoTDA conjuntoA = new ConjuntoLD();		
		ConjuntoTDA conjuntoB = new ConjuntoLD();
		
		conjuntoA.InicializarConjunto();
		conjuntoB.InicializarConjunto();
		
		conjuntoA.Agregar(1);
		conjuntoA.Agregar(2);
		conjuntoA.Agregar(3);
		conjuntoA.Agregar(4);
		conjuntoA.Agregar(5);
		conjuntoA.Agregar(6);
		conjuntoA.Agregar(7);
		
		
		conjuntoB.Agregar(1);
		conjuntoB.Agregar(2);
		conjuntoB.Agregar(3);
		conjuntoB.Agregar(4);
		conjuntoB.Agregar(8);
		
		int cardinalidad = punto_e(conjuntoA);
		
		System.exit(0);
	}
	
	
	
	/**
	 * Diferencia simetrica
	 * 
	 * @param conjuntoA
	 * @param conjuntoB
	 * @return
	 */
	public static ConjuntoTDA punto_a(ConjuntoTDA conjuntoA, ConjuntoTDA conjuntoB){
		
		ConjuntoTDA conjuntoC = new ConjuntoLD();		
		conjuntoC.InicializarConjunto();
		
		ConjuntoUtils.pasarConjunto(conjuntoA, conjuntoC);		
		
		int elemento = 0;
		
		while(!conjuntoB.ConjuntoVacio()){
			
			elemento = conjuntoB.Elegir();
			
			if(conjuntoC.Pertenece(elemento)){
				conjuntoC.Sacar(elemento);				
			}else{
				conjuntoC.Agregar(elemento);
			}
			
			conjuntoB.Sacar(elemento);
		}
		
		return conjuntoC;		
	}
	
	
	/**
	 * Determinar si dos conjuntos son  iguales
	 * 
	 * @param conjuntoA
	 * @param conjuntoB
	 * @return
	 */
	public static boolean punto_d(ConjuntoTDA conjuntoA, ConjuntoTDA conjuntoB){
		
		boolean sonIguales = true;
	
		int e = 0;
		
		while(!conjuntoA.ConjuntoVacio()){
			
			e = conjuntoA.Elegir();
			
			if (!conjuntoB.Pertenece(e)){
				sonIguales = false;
				break;
			} else {
				conjuntoB.Sacar(e);
			}
					
			conjuntoA.Sacar(e);			
		}
		
		sonIguales = conjuntoB.ConjuntoVacio();		
		
		return sonIguales; 
	}
	
	
	/**
	 * Calcular cardinalidad
	 * 
	 * @return
	 */
	public static int punto_e(ConjuntoTDA conjunto){
		
		ConjuntoTDA conjuntoAux = new ConjuntoLD();
		conjuntoAux.InicializarConjunto();
						
		int cardinalidad = 0;
		
		while(!conjunto.ConjuntoVacio()){
			
			int elemento = conjunto.Elegir();
			
			conjuntoAux.Agregar(elemento);//para recuperar el original
			conjunto.Sacar(elemento);
			
			cardinalidad++;
		}
		
		conjunto = conjuntoAux;//para recuperar el original
		
		return cardinalidad;
	}
	
	/**
	 * Devuelve un conjunto con los elementos en común de la cola y la pila
	 * 
	 * @param pila
	 * @param cola
	 * @return
	 */
	public static ConjuntoTDA punto_f(PilaTDA pila, ColaTDA cola){
		
		
		ConjuntoTDA conjuntoAux = new ConjuntoLD();
		conjuntoAux.InicializarConjunto();
				
		PilaTDA pilaAux = new PilaLD();
		pilaAux.InicializarPila();
		
		PilaUtils.pasarPila(pila, pilaAux);		
		
		while(!pilaAux.PilaVacia()){
			
			conjuntoAux.Agregar(pilaAux.Tope());
			pila.Apilar(pilaAux.Tope());//para recuperar pila original
			
			pilaAux.Desapilar();
		}
		
		ConjuntoTDA conjuntoComunes = new ConjuntoLD();
		conjuntoComunes.InicializarConjunto();
		
		
		ColaTDA colaAux = new ColaLD();
		colaAux.InicializarCola();
		
		ColaUtils.pasarCola(cola, colaAux);
		
		while(!colaAux.ColaVacia()){
			
			if(conjuntoAux.Pertenece(colaAux.Primero()))
				conjuntoComunes.Agregar(colaAux.Primero());					
			
			cola.Acolar(colaAux.Primero());//Para recuperar cola original
			colaAux.Desacolar();
		}		
		
		return conjuntoComunes;
	}
	
}

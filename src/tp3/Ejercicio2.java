package tp3;

import impl.dinamicos.basicos.ColaLD;
import impl.dinamicos.conjuntos.ConjuntoLD;
import utils.ColaUtils;
import api.basicos.ColaTDA;
import api.conjuntos.ConjuntoTDA;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		ColaTDA colaREP = new ColaLD();		
		
		colaREP.Acolar(2);
		colaREP.Acolar(3);
		colaREP.Acolar(2);
		colaREP.Acolar(1);
		
		colaREP.Acolar(1);
		colaREP.Acolar(4);
		colaREP.Acolar(1);
		colaREP.Acolar(7);
		colaREP.Acolar(6);
		colaREP.Acolar(7);
		colaREP.Acolar(9);
		
		ConjuntoTDA conjunto = punto_c(colaREP);
		
		System.exit(0);
	}
	
	
	
	/**
	 * Elimina repetidos de una cola
	 * 
	 * @param cola
	 * @return
	 */
	public static ColaTDA punto_a(ColaTDA cola){
		
		ColaTDA colaAux = new ColaLD();
		colaAux.InicializarCola();
		
		ConjuntoTDA conjuntoAux = new ConjuntoLD();
		conjuntoAux.InicializarConjunto();
				
		conjuntoAux.Agregar(cola.Primero());
		colaAux.Acolar(cola.Primero());
		cola.Desacolar();
		
		while(!cola.ColaVacia()){
			
			if(!conjuntoAux.Pertenece(cola.Primero())){				
				colaAux.Acolar(cola.Primero());
				conjuntoAux.Agregar(cola.Primero());			
			}
									
			cola.Desacolar();
		}
		
		
		return colaAux;
	}
	
	
	/**
	 * Reparte la cola en dos mitades
	 * 
	 * @param cola
	 */
	public static void punto_b(ColaTDA cola, ColaTDA mitad_1, ColaTDA mitad_2){				
		
		ColaTDA colaAux = new ColaLD();
		colaAux.InicializarCola();
				
		int cantidadElementos = 0;
		while(!cola.ColaVacia()){
			
			colaAux.Acolar(cola.Primero());
			cola.Desacolar();
			
			cantidadElementos++;
		}
		
		int mitad = cantidadElementos / 2;
		
		while(cantidadElementos > 0){
			
			if(cantidadElementos >  mitad){
				mitad_1.Acolar(colaAux.Primero());
			} else {
				mitad_2.Acolar(colaAux.Primero());
			}
			
			//Recupero la cola original para evitar perder datos
			cola.Acolar(colaAux.Primero());
			
			colaAux.Desacolar();
			cantidadElementos--;
		}				
		
	}
	
	
	public static ConjuntoTDA punto_c(ColaTDA cola){
		
		ColaTDA colaAux = new ColaLD();
		colaAux.InicializarCola();
		
		ColaUtils.pasarCola(cola, colaAux);
		
		ConjuntoTDA conjuntoAux = new ConjuntoLD();
		conjuntoAux.InicializarConjunto();
		
		ConjuntoTDA conjuntoRepetidos = new ConjuntoLD();
		conjuntoRepetidos.InicializarConjunto();
		
		conjuntoAux.Agregar(colaAux.Primero());
		cola.Acolar(colaAux.Primero());//para recuperar pila original
		colaAux.Desacolar();
		
		while(!colaAux.ColaVacia()){
			
			if(conjuntoAux.Pertenece(colaAux.Primero()))
				conjuntoRepetidos.Agregar(colaAux.Primero());
			
			conjuntoAux.Agregar(colaAux.Primero());
			
			cola.Acolar(colaAux.Primero());//para recuperar pila original
			colaAux.Desacolar();
		}
		
		return conjuntoRepetidos;		
	}
	

}

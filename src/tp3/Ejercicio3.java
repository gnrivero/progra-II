package tp3;

import impl.dinamicos.basicos.PilaLD;
import impl.dinamicos.conjuntos.ConjuntoLD;
import utils.ConjuntoUtils;
import api.basicos.PilaTDA;
import api.conjuntos.ConjuntoTDA;

public class Ejercicio3 {
	
	/**
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
		
		
		conjuntoB.Agregar(1);
		conjuntoB.Agregar(2);
		conjuntoB.Agregar(3);
		conjuntoB.Agregar(4);
		conjuntoB.Agregar(8);
		
		boolean iguales = sonIguales(conjuntoA, conjuntoB);
		
		System.exit(0);
	}
	
	
	private static boolean sonIguales(ConjuntoTDA conjuntoA, ConjuntoTDA conjuntoB){
		
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
	 * Ejercicio 3a
	 * 
	 * @param conjuntoA
	 * @param conjuntoB
	 * @return
	 */
	private static ConjuntoTDA diferenciaSimetrica(ConjuntoTDA conjuntoA, ConjuntoTDA conjuntoB){
		
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
	 * Ejercicio 1b
	 * 
	 * @param pila
	 * @return
	 */
	private static PilaTDA eliminarRepetidosPila(PilaTDA pila){
				
		PilaTDA pilaAux = new PilaLD();
		PilaTDA pilaResultado = new PilaLD();
		ConjuntoTDA conjuntoAux = new ConjuntoLD();
		
		pilaAux.InicializarPila();
		pilaResultado.InicializarPila();
		conjuntoAux.InicializarConjunto();
		
		//Pasar Pila
		while(!pila.PilaVacia()){
			pilaAux.Apilar(pila.Tope());
			pila.Desapilar();
		}
		
		while(!pilaAux.PilaVacia()){
			
			if(!conjuntoAux.Pertenece(pilaAux.Tope()) ){
				conjuntoAux.Agregar(pilaAux.Tope());
				pilaResultado.Apilar(pilaAux.Tope());				
			}					
			
			pilaAux.Desapilar();
		}
		
		return pilaResultado;
	}

}

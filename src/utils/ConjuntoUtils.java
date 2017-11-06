package utils;

import api.conjuntos.ConjuntoTDA;

public class ConjuntoUtils {
	
	public static void pasarConjunto(ConjuntoTDA origen, ConjuntoTDA destino){
		
		int elemento = 0;
		
		while(!origen.ConjuntoVacio()){
			
			elemento = origen.Elegir();			
			destino.Agregar(elemento);			
			origen.Sacar(elemento);			
		}		

	}
	
	public static void cargarConjuntoRandom(ConjuntoTDA conjunto, int maxElementos){
		
		while(maxElementos > 0){			
			conjunto.Agregar((int) Math.random() * (1 - 100) + 100);						
			maxElementos--;
		}		
	}

}

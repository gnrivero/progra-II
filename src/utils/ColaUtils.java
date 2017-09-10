package utils;

import api.ColaTDA;
import api.PilaTDA;

public class ColaUtils {
		
	/**
	 * Pasar cola a otra
	 * 
	 * @param origen
	 * @param destino
	 */
	public static void pasarCola(ColaTDA origen, ColaTDA destino){		
		while(!origen.ColaVacia()){
			destino.Acolar(origen.Primero());
			origen.Desacolar();
		}
	}
	
	/**
	 * Pasar cola a una pila
	 * 
	 * @param origen
	 * @param destino
	 */
	public static void pasarCola(ColaTDA origen, PilaTDA destino){		
		while(!origen.ColaVacia()){
			destino.Apilar(origen.Primero());
			origen.Desacolar();
		}
	}
}
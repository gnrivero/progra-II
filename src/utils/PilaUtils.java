package utils;

import api.basicos.ColaTDA;
import api.basicos.PilaTDA;

public class PilaUtils {
	
	public static void pasarPila(PilaTDA pilaOriginal, PilaTDA pilaDestino){
		
		while(!pilaOriginal.PilaVacia()){
			pilaDestino.Apilar(pilaOriginal.Tope());			
			pilaOriginal.Desapilar();
		}	
	}
	
	public static void pasarPila(PilaTDA pilaOriginal, ColaTDA colaDestino){		
		while(!pilaOriginal.PilaVacia()){
			colaDestino.Acolar(pilaOriginal.Tope());			
			pilaOriginal.Desapilar();
		}	
	}
}
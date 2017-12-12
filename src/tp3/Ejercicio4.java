package tp3;

import impl.dinamicos.basicos.ColaPrioridadLD;
import impl.dinamicos.diccionarios.DicMultipleL;
import impl.estaticos.basicos.ColaPI;
import api.basicos.ColaConPrioridadTDA;
import api.diccionarios.DiccionarioMultipleTDA;

public class Ejercicio4 {

	/**
	 * a)
	 * 
	 * Cola con prioridad:
	 * 
	 * P	V
	 * -	-
	 * 5	10
	 * 10	10
	 * 14	9
	 * 1	8
	 * 1	5
	 * 
	 * Debería quedar:
	 *  
	 *	clave	Valor
	 *    5 	{10}
	 *    14	{10, 9}
	 *    1		{8, 5}
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		ColaConPrioridadTDA cola = new ColaPrioridadLD();
		cola.InicializarCola();
		
		cola.AcolarPrioridad(10, 5);
		cola.AcolarPrioridad(10, 10);
		cola.AcolarPrioridad(9, 14);
		cola.AcolarPrioridad(6, 1);
		cola.AcolarPrioridad(5, 1);
		
		DiccionarioMultipleTDA diccionario  = pasarColaPaDiccionarioM(cola);
		
		System.exit(0);
	}
	
	public static DiccionarioMultipleTDA pasarColaPaDiccionarioM(ColaConPrioridadTDA colaPrioridad){
		
		
		DiccionarioMultipleTDA diccionario = new DicMultipleL();
		diccionario.InicializarDiccionario();
		
		
		while(!colaPrioridad.ColaVacia()){			
			diccionario.Agregar(colaPrioridad.Prioridad(), colaPrioridad.Primero());
						
			colaPrioridad.Desacolar();
		}
		
		return diccionario;
	}
}

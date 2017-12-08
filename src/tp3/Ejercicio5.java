package tp3;

import impl.dinamicos.diccionarios.DicSimpleL;
import api.diccionarios.DiccionarioSimpleTDA;



public class Ejercicio5 {

	/**
	 * a) Union de claves y valores
	 * b) "		"	" e interseccion de valores
	 * c) Interseccion de claves unión de valores
	 * d) interseccion claves e interseccion valores
	 * 
	 * 			D1					D2
	 * 		{ clave }			{claves{valores}}
	 * 			|->{valores}
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		DiccionarioSimpleTDA diccionario = new DicSimpleL();
		diccionario.InicializarDiccionario();
		
		diccionario.Agregar(1, 3);
		diccionario.Agregar(2, 5);
		diccionario.Agregar(3, 7);
		
		
		System.exit(0);
	}

}

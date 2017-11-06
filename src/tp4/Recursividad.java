package tp4;

import impl.dinamicos.arboles.ABB;
import api.arboles.ABBTDA;

public class Recursividad {
	
	
	/**
	 * Árboles 
	 * 
	 * 			   100
	 * 	       /          \ 
	 * 		  /		       \	
	 * 		50				200
	 * 	  /	   \		  /		\
	 * 30		60		150		300
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		 ABBTDA bb = new ABB();
	
		bb.InicializarArbol();
		bb.AgregarElem(100);
		
	}

}

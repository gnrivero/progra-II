package tp1;

import impl.ColaPrioridadLD;

public class Clase5 {

	public static void main(String[] args) {
				
		ColaPrioridadLD cola = new ColaPrioridadLD();
		cola.InicializarCola();
		
		cola.AcolarPrioridad(43, 3);
		cola.AcolarPrioridad(71, 4);
		cola.AcolarPrioridad(9, 1);
		
		System.exit(0);
	}
}

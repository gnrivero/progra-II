package impl;

import api.ColaTDA;

public class ColaLD implements ColaTDA {
	
	Nodo primero;
	Nodo ultimo;

	@Override
	public void InicializarCola() {
		primero = null;
		ultimo = null;
	}

	@Override
	public void Acolar(int x) {
		
		Nodo aux = new Nodo();
		aux.info = x;
		aux.sig = null;
		
		if (ultimo != null)
			ultimo.sig = aux;
		
		ultimo = aux;
		
		if(primero == null)
			primero = ultimo;
		
	}

	@Override
	public void Desacolar() {
		primero = primero. sig ;
		
		// Si la cola queda vacia
		if ( primero == null )
			ultimo = null ;		
	}

	@Override
	public boolean ColaVacia() {
		return (ultimo == null);
	}

	@Override
	public int Primero() {
		return primero.info;
	} 

}
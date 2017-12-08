package impl.dinamicos.basicos;

import api.basicos.ColaTDA;

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
		
		Nodo nuevo = new Nodo();
		nuevo.info = x;
		nuevo.sig = null;
		
		if (ultimo != null)
			ultimo.sig = nuevo;
		
		ultimo = nuevo;
		
		if(primero == null)
			primero = ultimo;
		
	}

	@Override
	public void Desacolar() {
		primero = primero.sig ;
		
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
package impl;

import api.ConjuntoTDA;

public class ConjuntoLD implements ConjuntoTDA {

	Nodo c;
	
	@Override
	public void InicializarConjunto() {
		c = null;
	}

	@Override
	public boolean ConjuntoVacio() {
		return (c == null);
	}

	@Override
	public void Agregar(int x) {
		if(!this.Pertenece(x)){
			Nodo aux = new Nodo();
			aux.info = x;
			aux.sig = c;
			
			c = aux;
			
		}

	}

	@Override
	public int Elegir() {
		return c.info ;
	}

	@Override
	public void Sacar(int x) {
		// TODO terminar esto

	}

	@Override
	public boolean Pertenece(int x) {
		// TODO terminar esto
		return false;
	}

}

package impl.dinamicos.basicos;

import api.basicos.PilaTDA;

public class PilaLD implements PilaTDA {

	Nodo tope;
	
	@Override
	public void InicializarPila() {
		tope = null;
	}

	@Override
	public void Apilar(int x) {
		Nodo nuevo = new Nodo();
		nuevo.info = x;
		nuevo.sig = tope;
		tope = nuevo;
	}

	@Override
	public void Desapilar() {
		tope = tope.sig;
	}

	@Override
	public boolean PilaVacia() {		
		return (tope == null);
	}

	@Override
	public int Tope() {
		return tope.info;
	}

}
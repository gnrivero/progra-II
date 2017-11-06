package impl.estaticos.basicos;

import api.basicos.ColaTDA;

public class ColaPI implements ColaTDA {

	int []a ;
	int indice;
	
	public void InicializarCola() {
		a = new int [100];
		indice = 0;
	}

	public void Acolar(int x) {
		a[indice] = x;
		indice++;
	}

	public void Desacolar() {
		for( int i = 0; i < indice -1; i ++)
			a[i] = a[i+1];
		
		indice --;
	}

	public boolean ColaVacia() {
		return (indice == 0);
	}

	public int Primero() {
		return a[0];
	}

}

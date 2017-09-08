package api;

public interface ConjuntoTDA {
	
	void InicializarConjunto ();
	// siempre que el conjunto est´e inicializado
	boolean ConjuntoVacio() ;
	// siempre que el conjunto est´e inicializado
	void Agregar( int x);
	// siempre que el conjunto est´e inicializado y no est´e vac´ıo
	int Elegir();
	// siempre que el conjunto est´e inicializado
	void Sacar( int x);
	// siempre que el conjunto est´e inicializado
	boolean Pertenece( int x);

}

package API;

public interface ColaTDA {
	
	void InicializarCola () ;
	// siempre que la cola est´e inicializada
	void Acolar( int x);
	// siempre que la cola est´e inicializada y no est´e vac´ıa	
	void Desacolar() ;
	// siempre que la cola est´e inicializada
	boolean ColaVacia ();
	// siempre que la cola est´e inicializada y no est´e vac´ıa
	int Primero();
	
}
package api.basicos;

public interface ColaConPrioridadTDA {
	void InicializarCola () ;
	// siempre que la cola est´e inicializada
	void AcolarPrioridad ( int x, int prioridad);
	// siempre que la cola est´e inicializada y no est´e vac´ıa
	void Desacolar() ;
	// siempre que la cola est´e inicializada y no est´e vac´ıa
	int Primero();
	// siempre que la cola est´e inicializada
	boolean ColaVacia ();
	// siempre que la cola est´e inicializada y no est´e vac´ıa
	int Prioridad() ;
}

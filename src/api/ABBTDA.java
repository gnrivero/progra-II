package api;

public interface ABBTDA {
	//siemprequeelárbol
	int Raiz() ;
	//siemprequeelárbol
	ABBTDA HijoIzq();
	//siemprequeelárbol
	ABBTDA HijoDer();
	//siemprequeelárbol
	boolean ArbolVacio();
	
	void InicializarArbol();
	//siemprequeelárbolestéinicializado
	void AgregarElem(int x);
	//siemprequeelárbolestéinicializado
	void EliminarElem(int x);
}

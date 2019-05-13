import java.util.LinkedList;


public class Fel {
	private static Fel fel;
	private LinkedList lista;


	private Fel(){

		lista = new LinkedList();
	}
	
	public static Fel getFel(){
		if(fel == null)
			fel = new Fel();
		return(fel);
	}

	public static void resetFel(){
		fel = null;
	}
	
	public void insertarFel(Evento e){

		lista.add(e);
		lista.sort(new OrdenarFEL()); // Probar si ordena bien
	}

	public Evento suprimirFel(){

		return (Evento)lista.removeFirst();
	}
	
	public void mostrarFel(){

		System.out.println(lista);
	}
	
	/**
	 * @return Returns the lista.
	 */
	public LinkedList getLista() {
		return lista;
	}
	
}

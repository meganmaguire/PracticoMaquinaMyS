public class Item {
	private int numero;
	private float tiempoArribo;
	private float tiempoDuracionServicio;

	private static float tiempoEsperaCola=0;
	private static float tiempoTransito=0;
	private static int cantidadItems=0;


	public Item(float tiempoArribo){

		this.numero=cantidadItems;
		cantidadItems++;
		this.tiempoArribo=tiempoArribo;
		this.tiempoDuracionServicio=0;
	}
        
        
	/**
	 * @return Returns the cantidadItems.
	 */
	public static int getCantidadItems() {

		return cantidadItems;
	}
	
        /**
	 * @param cantidadItems The cantidadItems to set.
	 */
	public static void setCantidadItems(int cantidadItems) {

		Item.cantidadItems = cantidadItems;
	}
		
	/**
	 * @return Returns the tiempoEsperaCola.
	 */
	public static float getTiempoEsperaCola() {

		return tiempoEsperaCola;
	}
	
        /**
	 *
	 */
	public static void setTiempoEsperaCola(float tiempoActual, float tiempoDuracionServicio, float tiempoArribo) {

		Item.tiempoEsperaCola = Item.tiempoEsperaCola + (tiempoActual-tiempoArribo-tiempoDuracionServicio);
	}
	
        /**
	 * @return Returns the tiempoTransito.
	 */
	public static float getTiempoTransito() {

		return tiempoTransito;
	}
	
	/**
	 */
	public static void setTiempoTransito(float tiempoActual, float tiempoArribo) {

		Item.tiempoTransito = Item.tiempoTransito + (tiempoActual-tiempoArribo);
	}
	
	/**
	 * @return Returns the numero.
	 */
	public int getNumero() {

		return numero;
	}

	/**
	 * @param numero The numero to set.
	 */
	public void setNumero(int numero) {

		this.numero = numero;
	}

	/**
	 * @return Returns the tiempoArribo.
	 */
	public float getTiempoArribo() {

		return tiempoArribo;
	}

	/**
	 * @param tiempoArribo The tiempoArribo to set.
	 */
	public void setTiempoArribo(float tiempoArribo) {

		this.tiempoArribo = tiempoArribo;
	}

	/**
	 * @return Returns the tiempoDuracionServicio.
	 */
	public float getTiempoDuracionServicio() {

		return tiempoDuracionServicio;
	}

	/**
	 * @param tiempoDuracionServicio The tiempoDuracionServicio to set.
	 */
	public void setTiempoDuracionServicio(float tiempoDuracionServicio) {

		this.tiempoDuracionServicio = tiempoDuracionServicio;
	}

	public String toString(){
		String retorno = "Item: "+this.getNumero()+" | Tiempo de arribo: "+this.getTiempoArribo()+" | Tiempo de servicio: "+this.getTiempoDuracionServicio();
		return retorno;
	}
}

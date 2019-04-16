public class Item {
	private int numero;
	private float tiempoArribo;
	private float tiempoDuracionServicio;
	private int nroServidor;

	private static float tiempoEsperaColaLivianos = 0;
	private static float tiempoEsperaColaMedianos = 0;
	private static float tiempoEsperaColaPesados = 0;
	private static float tiempoTransito=0;
	private static int cantidadItems = 1;
	private static int cantidadLivianos = 0;
	private static int cantidadMedianos = 0;
	private static int cantidadPesados = 0;


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
	 * @return Returns the tiempoEsperaColaLivianos.
	 */
	public static float getTiempoEsperaColaLivianos() {

		return tiempoEsperaColaLivianos;
	}
	
        /**
	 *
	 */
	public static void setTiempoEsperaCola(float tiempoActual, float tiempoDuracionServicio, float tiempoArribo, int i) {
		switch (i){
			case 0:
				Item.tiempoEsperaColaLivianos = Item.tiempoEsperaColaLivianos + (tiempoActual-tiempoArribo-tiempoDuracionServicio); break;
			case 1:
				Item.tiempoEsperaColaMedianos = Item.tiempoEsperaColaMedianos + (tiempoActual-tiempoArribo-tiempoDuracionServicio); break;
			case 2:
				Item.tiempoEsperaColaMedianos = Item.tiempoEsperaColaMedianos + (tiempoActual-tiempoArribo-tiempoDuracionServicio); break;
			case 3:
				Item.tiempoEsperaColaMedianos = Item.tiempoEsperaColaMedianos + (tiempoActual-tiempoArribo-tiempoDuracionServicio); break;
			case 4:
				Item.tiempoEsperaColaPesados = Item.tiempoEsperaColaPesados + (tiempoActual-tiempoArribo-tiempoDuracionServicio);
		}

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

	public static float getTiempoEsperaColaMedianos() {

		return tiempoEsperaColaMedianos;
	}

	public static float getTiempoEsperaColaPesados() {

		return tiempoEsperaColaPesados;
	}

	public static int getCantidadLivianos() {
		return cantidadLivianos;
	}

	public static void setCantidadLivianos(int cantidadLivianos) {
		Item.cantidadLivianos = cantidadLivianos;
	}

	public static int getCantidadMedianos() {
		return cantidadMedianos;
	}

	public static void setCantidadMedianos(int cantidadMedianos) {
		Item.cantidadMedianos = cantidadMedianos;
	}

	public static int getCantidadPesados() {
		return cantidadPesados;
	}

	public static void setCantidadPesados(int cantidadPesados) {
		Item.cantidadPesados = cantidadPesados;
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

	public void setNroServidor(int nroServidor){
		this.nroServidor = nroServidor;
	}

	public int getNroServidor(){
		return nroServidor;
	}

	public String toString(){
		String retorno = "Item: "+this.getNumero()+" | Tiempo de arribo: "+this.getTiempoArribo()+" | Tiempo de servicio: "+this.getTiempoDuracionServicio();
		return retorno;
	}
}

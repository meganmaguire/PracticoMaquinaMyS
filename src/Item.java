public class Item {
	private int numero;
	private float tiempoArribo;
	private float tiempoDuracionServicio;
	private int tipoArribo;  // 0 - Liviano / 1 - Mediano / 2 - Pesado /  -1 - Inválido

	private static float tiempoEsperaColaLivianos = 0;
	private static float tiempoEsperaColaMedianos = 0;
	private static float tiempoEsperaColaPesados = 0;

	private static float tiempoTransitoLivianos = 0;
	private static float tiempoTransitoMedianos = 0;
	private static float tiempoTransitoPesados = 0;

	private static int cantidadLivianos = 0;
	private static int cantidadMedianos = 0;
	private static int cantidadPesados = 0;

	private static int cantidadItems = 0;


	public Item(float tiempoArribo, int tipoArribo){

		cantidadItems++;
		this.numero=cantidadItems;
		this.tiempoArribo=tiempoArribo;
		this.tiempoDuracionServicio=0;
		this.tipoArribo = tipoArribo;

		switch (tipoArribo){
			case 0: cantidadLivianos++; break;
			case 1: cantidadMedianos++; break;
			case 2: cantidadPesados++;
		}
	}

	public static void resetItem(){
		tiempoEsperaColaLivianos = 0;
		tiempoEsperaColaMedianos = 0;
		tiempoEsperaColaPesados = 0;

		tiempoTransitoLivianos = 0;
		tiempoTransitoMedianos = 0;
		tiempoTransitoPesados = 0;

		cantidadLivianos = 0;
		cantidadMedianos = 0;
		cantidadPesados = 0;

		cantidadItems = 0;

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
				Item.tiempoEsperaColaPesados = Item.tiempoEsperaColaPesados + (tiempoActual-tiempoArribo-tiempoDuracionServicio);
		}

	}
	
        /**
	 * @return Returns the tiempoTransito.
	 */

	
	/**
	 */
	public static void setTiempoTransito(float tiempoActual, float tiempoArribo, int tipoArribo) {

		switch (tipoArribo) {
			case 0:
				Item.setTiempoTransitoLivianos(Item.getTiempoTransitoLivianos() + (tiempoActual - tiempoArribo)); break;
			case 1:
				Item.setTiempoTransitoMedianos(Item.getTiempoTransitoMedianos() + (tiempoActual - tiempoArribo)); break;
			case 2:
				Item.setTiempoTransitoPesados(Item.getTiempoTransitoPesados() + (tiempoActual - tiempoArribo));
		}
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

	public static float getTiempoTransitoLivianos() {
		return tiempoTransitoLivianos;
	}

	public static void setTiempoTransitoLivianos(float tiempoTransitoLivianos) {
		Item.tiempoTransitoLivianos = tiempoTransitoLivianos;
	}

	public static float getTiempoTransitoMedianos() {
		return tiempoTransitoMedianos;
	}

	public static void setTiempoTransitoMedianos(float tiempoTransitoMedianos) {
		Item.tiempoTransitoMedianos = tiempoTransitoMedianos;
	}

	public static float getTiempoTransitoPesados() {
		return tiempoTransitoPesados;
	}

	public static void setTiempoTransitoPesados(float tiempoTransitoPesados) {
		Item.tiempoTransitoPesados = tiempoTransitoPesados;
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

	public void setTipoArribo(int tipoArribo){
		this.tipoArribo = tipoArribo;
	}

	public int getTipoArribo(){
		return tipoArribo;
	}

	public String toString(){
		String retorno = "Item: "+this.getNumero()+" | Tipo de Arribo: " +this.getTipoArribo()+" | Tiempo de arribo: "+this.getTiempoArribo()+" | Tiempo de servicio: "+this.getTiempoDuracionServicio();
		return retorno;
	}

	public boolean equals(Item item){

		// Si son iguales en cada campo

		if (this.numero == item.getNumero() &&
			this.tiempoArribo == item.getTiempoArribo() &&
			this.tiempoDuracionServicio == item.getTiempoDuracionServicio() &&
			this.tipoArribo == item.getTipoArribo()){

			return true;
		}
		else
			return false;
	}

	public static String type(int i){
		switch (i){
			case 0 : return "privados";
			case 1 : return "de cabotaje";
			case 2 : return "internacionales";
		}
		return "";
	}
}

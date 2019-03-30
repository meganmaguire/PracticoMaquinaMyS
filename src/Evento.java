public abstract class Evento {
	private int tipo; //0: Arribo - 1:Fin de Servicio - 2: Fin de Simulacion
	private float tiempo; // Tiempo en el que comenzará el Evento, por el cual se ordenan en la FEL
	private Item item;
	
	public Evento(int tipo,float tiempo,Item item){

		this.tipo = tipo;
		this.tiempo = tiempo;
		this.item = item;
	}

	public Item getItem() {

		return item;
	}

	public void setItem(Item item) {

		this.item = item;
	}
	
	public float getTiempo() {

		return tiempo;
	}
	

	public void setTiempo(float tiempo) {

		this.tiempo = tiempo;
	}
	
	public int getTipo() {

		return tipo;
	}
	
	public void setTipo(int tipo) {

		this.tipo = tipo;
	}

	public String toString(){
		String retorno = "Tipo: "+this.getTipo()+" | Tiempo: "+this.getTiempo()+" || "+this.getItem()+"\n";
		return retorno;
	}
	/**
	 *  Implementa la planiificación de eventos.
	 */
	public abstract void planificarEvento(Servidor servidor,Queue queue);
}

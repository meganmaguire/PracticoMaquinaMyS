public class EventoFinSimulacion extends Evento {



	public EventoFinSimulacion(float tiempo,int tipoArribo){
		super(2,tiempo,new Item(tiempo,tipoArribo));
	}
	public void planificarEvento(Servidores servidores){
        // NADA
	}
}

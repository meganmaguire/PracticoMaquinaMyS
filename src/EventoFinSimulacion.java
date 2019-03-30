public class EventoFinSimulacion extends Evento {



	public EventoFinSimulacion(float tiempo){
		super(2,tiempo,new Item(tiempo));
	}
	public void planificarEvento(Servidor servidor,Queue queue){
        // NADA
	}
}

public class EventoArriboPesado extends EventoArribo {


    public EventoArriboPesado(float tiempo){
        super(tiempo);
        this.getItem().setNroServidor(4);
    }
}

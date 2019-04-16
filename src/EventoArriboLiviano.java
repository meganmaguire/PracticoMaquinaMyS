public class EventoArriboLiviano extends EventoArribo {


    public EventoArriboLiviano(float tiempo){

        super(tiempo);
        this.getItem().setNroServidor(0);
        Item.setCantidadLivianos(Item.getCantidadLivianos()+1);
    }



}

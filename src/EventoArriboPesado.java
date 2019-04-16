public class EventoArriboPesado extends EventoArribo {


    public EventoArriboPesado(float tiempo){
        super(tiempo);
        this.getItem().setNroServidor(4);
        Item.setCantidadPesados(Item.getCantidadPesados()+1);
    }
}

public class EventoArriboMediano extends EventoArribo {


    public EventoArriboMediano(float tiempo){

        super(tiempo);
        Item.setCantidadMedianos(Item.getCantidadMedianos()+1);

    }

    public void planificarEvento(Servidor[] servidores, Queue[] queues){

        int i, j, cantMinima;

        // Chequea si alguno disponible, si lo encuentra sale del loop
        for(i=1;i<servidores.length - 1;i++){
            if(!servidores[i].isEstado())
                break;
        }

        // Si i vale 3 significa que nunca salió del loop y todos están ocupados
        if(i == 4){

            // Busca la cola más corta
            cantMinima = queues[1].getCantidadItems();
            j = 1;

            if(queues[2].getCantidadItems()<cantMinima){
                cantMinima = queues[2].getCantidadItems();
                j = 2;
            }

            if(queues[3].getCantidadItems()<cantMinima){
                cantMinima = queues[3].getCantidadItems();
                j = 3;
            }

            // Servidor asociado a esa cola
            i = j;
        }

        this.getItem().setNroServidor(i);
        super.planificarEvento(servidores,queues);


    }
}

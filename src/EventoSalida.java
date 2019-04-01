public class EventoSalida extends Evento {
	
   public EventoSalida(float tiempo,Item item){
	    super(1,tiempo,item);
   }
        
    public void planificarEvento(Servidor servidor,Queue queue) {
	            
        Evento e;
        Item i;
        Fel fel = Fel.getFel();

        // Si hay cola
        if(queue.HayCola()){

            i = queue.suprimirCola();
            Item.setTiempoEsperaCola(this.getTiempo(),i.getTiempoDuracionServicio(),i.getTiempoArribo());
            // Genera el próximo evento de salida con el siguiente item de la cola
            int salida = GeneradorTiempos.getTiempoDuracionServicio();
            i.setTiempoDuracionServicio(salida);
            e = new EventoSalida(this.getTiempo() + salida, i );
            fel.insertarFel(e);
        }
        else{
            // Marca el servidor como desocupado
            servidor.setEstado(false);
            servidor.setTiempoInicioOcio(getTiempo());
        }
        // Agrega al contador el total de arribo del item
        Item.setTiempoTransito(this.getTiempo(),this.getItem().getTiempoArribo());
    }
}

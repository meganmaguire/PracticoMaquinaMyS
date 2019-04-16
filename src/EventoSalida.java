public class EventoSalida extends Evento {
	
   public EventoSalida(float tiempo,Item item){
	    super(1,tiempo,item);
   }
        
    public void planificarEvento(Servidor[] servidor,Queue[] queue) {
	            
        Evento e = null;
        Item item;
        Fel fel = Fel.getFel();
        int i = this.getItem().getNroServidor();

        // Si hay cola
        if(queue[i].HayCola()){

            item = queue[i].suprimirCola();
            Item.setTiempoEsperaCola(this.getTiempo(),item.getTiempoDuracionServicio(),item.getTiempoArribo(),i);
            // Genera el próximo evento de salida con el siguiente item de la cola
            int salida = GeneradorTiempos.getTiempoDuracionServicio((EventoArribo)e);
            item.setTiempoDuracionServicio(salida);
            e = new EventoSalida(this.getTiempo() + salida, item );
            fel.insertarFel(e);
        }
        else{
            // Marca el servidor como desocupado
            servidor[i].setEstado(false);
            servidor[i].setTiempoInicioOcio(getTiempo());
        }
        // Agrega al contador el total de arribo del item
        Item.setTiempoTransito(this.getTiempo(),this.getItem().getTiempoArribo());
    }
}

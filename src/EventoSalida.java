public class EventoSalida extends Evento {
	
   public EventoSalida(float tiempo,Item item){
	    super(1,tiempo,item);
   }
        
    public void planificarEvento(Servidores servidores) {
	            
        Evento e = null;
        Item item;
        Fel fel = Fel.getFel();
        int i = this.getItem().getTipoArribo();

        Servidor servidor = servidores.buscarServidorActual(this.getItem());

        // Si hay cola
        if(servidor.getQueue().HayCola()){

            item = servidor.getQueue().suprimirCola();
            servidor.setItem(item);
            Item.setTiempoEsperaCola(this.getTiempo(),item.getTiempoDuracionServicio(),item.getTiempoArribo(),i);
            // Genera el próximo evento de salida con el siguiente item de la cola
            double salida = GeneradorTiempos.getTiempoDuracionServicio(i);
            item.setTiempoDuracionServicio((float) salida);
            e = new EventoSalida((float) (this.getTiempo() + salida), item );
            fel.insertarFel(e);
        }
        else{
            // Marca el servidor como desocupado
            servidor.setItem(null);
            servidor.setEstado(false);
            servidor.setTiempoInicioOcio(getTiempo());
        }
        // Agrega al contador el total de arribo del item
        Item.setTiempoTransito(this.getTiempo(),this.getItem().getTiempoArribo(), i);
        // Calcula el monto recaudado
        servidor.setDineroRecaudado(servidor.getDineroRecaudado(),i);
    }
}

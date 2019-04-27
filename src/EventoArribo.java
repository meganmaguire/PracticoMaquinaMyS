public class EventoArribo extends Evento {
    
    
    public EventoArribo(float tiempo, int tipoArribo){

		super(0,tiempo,new Item(tiempo,tipoArribo));
    } 
        
    public void planificarEvento(Servidores servidores){

         Evento e = null;
         Fel fel = Fel.getFel();
         Servidor servidor;
         int i = this.getItem().getTipoArribo();

         //Si el servidor no está ocupado
         if(!servidores.servidoresOcupados(this.getItem().getTipoArribo())){
             servidor = servidores.buscarServidor(i);
             servidor.setItem(this.getItem());
             // Genera su propio evento de salida
             double salida = GeneradorTiempos.getTiempoDuracionServicio(i);
             this.getItem().setTiempoDuracionServicio((float) salida);
             e = new EventoSalida((float) (this.getTiempo()+salida),this.getItem());
             fel.insertarFel(e);
             // Le suma el tiempo que estuvo ocioso hasta que llegó el arribo al total de ocio
             servidor = servidores.buscarServidorActual(this.getItem());
             servidor.setTiempoOcioso(servidor.getTiempoOcioso()+(getTiempo()-servidor.getTiempoInicioOcio()));
		     servidor.setEstado(true);
         }
		 else{
		     // Si están ocupados lo inserta en la cola más corta que encuentra
		     servidores.buscarCola(this.getItem().getTipoArribo()).getQueue().insertarCola(this.getItem());
         }

		 // Genera el próximo evento de arribo
        int arribo = GeneradorTiempos.getTiempoEntreArribos(this.getTiempo(),i);
        e = new EventoArribo(this.getTiempo() + arribo,i);
        fel.insertarFel(e);


    }
  
}

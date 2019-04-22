public class EventoArribo extends Evento {
    
    
    public EventoArribo(float tiempo){

		super(0,tiempo,new Item(tiempo));
    } 
        
    public void planificarEvento(Servidor[] servidor,Queue[] queue){

         Evento e = null;
         Fel fel = Fel.getFel();
         int i = this.getItem().getNroServidor();

         //Si el servidor no está ocupado
         if(!servidor[i].isEstado()){
             // Genera su propio evento de salida
             double salida = GeneradorTiempos.getTiempoDuracionServicio(i);
             this.getItem().setTiempoDuracionServicio((float) salida);
             e = new EventoSalida((float) (this.getTiempo()+salida),this.getItem());
             fel.insertarFel(e);
             // Le suma el tiempo que estuvo ocioso hasta que llegó el arribo al total de ocio
             servidor[i].setTiempoOcioso(servidor[i].getTiempoOcioso()+(getTiempo()-servidor[i].getTiempoInicioOcio()));
		     servidor[i].setEstado(true);
		     servidor[i].setDineroRecaudado(servidor[i].getDineroRecaudado(),i);
         }
		 else{
		     queue[i].insertarCola(this.getItem());
         }

		 // Genera el próximo evento de arribo
        int arribo = GeneradorTiempos.getTiempoEntreArribos(this.getTiempo(),i);
        e = FactoryEventoArribo.getEventoArribo(i,this.getTiempo() + arribo);
        fel.insertarFel(e);

    }
  
}

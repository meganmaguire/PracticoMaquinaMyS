public class EventoArribo extends Evento{
    
    
    public EventoArribo(float tiempo){

		super(0,tiempo,new Item(tiempo));
    } 
        
    public void planificarEvento(Servidor servidor,Queue queue){

         Evento e;
         Fel fel = Fel.getFel();

         //Si el servidor no está ocupado
         if(!servidor.isEstado()){
             // Genera su propio evento de salida
             int salida = GeneradorTiempos.getTiempoDuracionServicio();
             this.getItem().setTiempoDuracionServicio(salida);
             e = new EventoSalida(this.getTiempo()+salida,this.getItem());
             fel.insertarFel(e);
             // Le suma el tiempo que estuvo ocioso hasta que llegó el arribo al total de ocio
             servidor.setTiempoOcioso(servidor.getTiempoOcioso()+(getTiempo()-servidor.getTiempoInicioOcio()));
		     servidor.setEstado(true);
         }
		 else{
		     queue.insertarCola(this.getItem());
         }

		 // Genera el próximo evento de arribo
        int arribo = GeneradorTiempos.getTiempoEntreArribos();
        e = new EventoArribo(this.getTiempo() + arribo);
        fel.insertarFel(e);

    }
  
}

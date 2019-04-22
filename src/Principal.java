//import java.util.ListIterator;

public class Principal {
			
	public static void main(String[] args){
		// Variables
		boolean finSimulacion=false;
		Evento actual;
		float tiempoSimulacion = 0;
		float tiempoFinSimulacion = 10080;

		Fel fel = Fel.getFel(); // Creo la lista de eventos futuros

		Queue[] queue = new Queue[5]; // Colas de espera servidores
		Servidor[] servidor = new Servidor[5];  // Servidores

		// Inicializa el arreglo de Servidores y de Queues
		for(int i=0; i<5; i++){
			queue[i] = new Queue();
			servidor[i] = new Servidor();
		}

		// Inserta el evento de Fin de Simulación
		actual = new EventoFinSimulacion(tiempoFinSimulacion);
		fel.insertarFel(actual);
		// Setea en 0 porque el Fin de Simulación contó un item que no existe
        Item.setCantidadItems(1);

		// Inserta el primer arribo Liviano
		actual = new EventoArriboLiviano(tiempoSimulacion);
		fel.insertarFel(actual);

		// Inserta el primer arribo Mediano
		actual = new EventoArriboMediano(tiempoSimulacion);
		fel.insertarFel(actual);

		// Inserta el primer arribo Pesado
		actual = new EventoArriboPesado(tiempoSimulacion);
		fel.insertarFel(actual);


		while (!finSimulacion){

			// Toma el siguiente evento de la FEL
			actual = fel.suprimirFel();
			actual.planificarEvento(servidor,queue);

			// Si llega el Evento de Fin de Simulación termina
			if(actual instanceof EventoFinSimulacion)
				finSimulacion = true;
			else // Para que no guarde el tiempo del Evento de Fin de Simulación
				tiempoSimulacion = actual.getTiempo();
		}

		// Estadísticas de la simulación
		/*
		System.out.println("Tiempo ocioso: "+servidor.getTiempoOcioso()+"" +
						   "\nTiempo en cola: "+ Item.getTiempoEsperaColaLivianos()+"" +
						   "\nTiempo transito: "+Item.getTiempoTransito()+"" +
						   "\nAviones: "+Item.getCantidadItems());

		System.out.println("\n\nTiempo medio de espera: "+Item.getTiempoEsperaColaLivianos()/Item.getCantidadItems()+" min."+
				           "\nPorcentaje de tiempo ocioso de la pista: "+(servidor.getTiempoOcioso()/tiempoSimulacion)*100+"%" +
						   "\nTiempo medio de tránsito: "+Item.getTiempoTransito()/Item.getCantidadItems()+" min.");

		*/

		// Total de tiempo ocioso de las tres pistas de cabotaje y del monto recaudado
		int tiempoMedioOcio = 0;
		float montoRecaudado = 0;
		for(int i = 1; i < servidor.length - 1; i++){
			tiempoMedioOcio += servidor[i].getTiempoOcioso();
			montoRecaudado += servidor[i].getDineroRecaudado();
		}

		System.out.println("\n\nTiempo medio de tránsito de los aviones: " + Item.getTiempoTransito()/Item.getCantidadItems() + "min." +
				           "\n\nTiempo medio de espera en cola de aviones privados: " + Item.getTiempoEsperaColaLivianos()/Item.getCantidadLivianos() + "min." +
					       "\nTiempo medio de espera en cola de aviones de cabotaje: " + Item.getTiempoEsperaColaMedianos()/Item.getCantidadMedianos() + "min." +
						   "\nTiempo medio de espera en cola de aviones internacionales: " + Item.getTiempoEsperaColaPesados()/Item.getCantidadPesados() + "min." +
						   "\n\nTiempo medio de ocio de pista de aviones livianos: " + servidor[0].getTiempoOcioso()/tiempoSimulacion + "min." +
						   "\nTiempo medio de ocio de pistas de aviones medianos: " + tiempoMedioOcio/tiempoSimulacion + "min." +
						   "\nTiempo medio de ocio de pista de aviones pesados: " + servidor[4].getTiempoOcioso()/tiempoSimulacion + "min." +
						   "\n\nTotal recaudado pista de aviones livianos: " + servidor[0].getDineroRecaudado() + " " +
						   "\nTotal recaudado pistas de aviones medianos: " + montoRecaudado + "" +
						   "\nTotal recaudado pistas de aviones pesados: " + servidor[4].getDineroRecaudado());


	}
}

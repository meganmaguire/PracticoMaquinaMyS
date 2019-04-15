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
		// Inicializa el arreglo
		for(Queue q : queue){
			q = new Queue();
		}

		Servidor[] servidor = new Servidor[5];  // Servidores
		// Inicializa el arreglo
		for (Servidor s: servidor) {
			s = new Servidor();
		}

		// Inserta el evento de Fin de Simulación
		actual = new EventoFinSimulacion(tiempoFinSimulacion);
		fel.insertarFel(actual);
		// Setea en 0 porque el Fin de Simulación contó un item que no existe
        Item.setCantidadItems(0);

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
						   "\nTiempo en cola: "+ Item.getTiempoEsperaCola()+"" +
						   "\nTiempo transito: "+Item.getTiempoTransito()+"" +
						   "\nAviones: "+Item.getCantidadItems());

		System.out.println("\n\nTiempo medio de espera: "+Item.getTiempoEsperaCola()/Item.getCantidadItems()+" min."+
				           "\nPorcentaje de tiempo ocioso de la pista: "+(servidor.getTiempoOcioso()/tiempoSimulacion)*100+"%" +
						   "\nTiempo medio de tránsito: "+Item.getTiempoTransito()/Item.getCantidadItems()+" min.");

		*/

	}
}

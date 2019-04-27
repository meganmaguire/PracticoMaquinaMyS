//import java.util.ListIterator;

public class Principal {
			
	public static void main(String[] args){
		// Variables
		boolean finSimulacion=false;
		Evento actual;
		float tiempoSimulacion = 0;
		float tiempoFinSimulacion = 10080;

		Fel fel = Fel.getFel(); // Creo la lista de eventos futuros

		// Inicializa los servidores con la cantidad deseada para cada uno

		Servidores servidores = new Servidores(1,1,2);


		// Inserta el evento de Fin de Simulación
		actual = new EventoFinSimulacion(tiempoFinSimulacion, -1);
		fel.insertarFel(actual);
		// Setea en 0 porque el Fin de Simulación contó un item que no existe
        Item.setCantidadItems(0);

		// Inserta el primer arribo Liviano
		actual = new EventoArribo(tiempoSimulacion,0);
		fel.insertarFel(actual);

		// Inserta el primer arribo Mediano
		actual = new EventoArribo(tiempoSimulacion,1);
		fel.insertarFel(actual);

		// Inserta el primer arribo Pesado
		actual = new EventoArribo(tiempoSimulacion,2);
		fel.insertarFel(actual);


		while (!finSimulacion){

			// Toma el siguiente evento de la FEL
			actual = fel.suprimirFel();
			actual.planificarEvento(servidores);

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



		// Cálculo de tiempo ocioso de las tres pistas de cabotaje y del monto recaudado
		double tiempoOciosoLivianos = Estadisticas.calcularOcioPistas(servidores,0);
		double tiempoOciosoMedianos = Estadisticas.calcularOcioPistas(servidores,1);
		double tiempoOciosoPesados = Estadisticas.calcularOcioPistas(servidores,2);

		int montoRecaudadoLivianos = Estadisticas.calcularMontoRecaudado(servidores,0);
		int montoRecaudadoMedianos = Estadisticas.calcularMontoRecaudado(servidores,1);
		int montoRecaudadoPesados = Estadisticas.calcularMontoRecaudado(servidores,2);


		System.out.println("\n\nTiempo medio de tránsito de los aviones: " + Item.getTiempoTransito()/Item.getCantidadItems() + "min." +
				           "\n\nTiempo medio de espera en cola de aviones privados: " + Item.getTiempoEsperaColaLivianos()/Item.getCantidadLivianos() + "min." +
					       "\nTiempo medio de espera en cola de aviones de cabotaje: " + Item.getTiempoEsperaColaMedianos()/Item.getCantidadMedianos() + "min." +
						   "\nTiempo medio de espera en cola de aviones internacionales: " + Item.getTiempoEsperaColaPesados()/Item.getCantidadPesados() + "min." +
						   "\n\nTiempo medio de ocio de pistas de aviones livianos: " + tiempoOciosoLivianos/tiempoSimulacion + "min." +
						   "\nTiempo medio de ocio de pistas de aviones medianos: " + tiempoOciosoMedianos/tiempoSimulacion + "min." +
						   "\nTiempo medio de ocio de pista de aviones pesados: " + tiempoOciosoPesados/tiempoSimulacion + "min." +
						   "\n\nTotal recaudado pista de aviones livianos: " + montoRecaudadoLivianos + " " +
						   "\nTotal recaudado pistas de aviones medianos: " + montoRecaudadoMedianos + "" +
						   "\nTotal recaudado pistas de aviones pesados: " + montoRecaudadoPesados);


	}
}

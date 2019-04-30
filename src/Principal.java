//import java.util.ListIterator;

public class Principal {
			
	public static void main(String[] args){
		// Variables
		boolean finSimulacion=false;
		Evento actual;
		float tiempoSimulacion = 0;
		float tiempoFinSimulacion = 10080;

		int cantLiviano = 1;
		int cantMediano = 3;
		int cantPesado = 1;

		Fel fel = Fel.getFel(); // Creo la lista de eventos futuros

		// Inicializa los servidores con la cantidad deseada para cada uno

		Servidores servidores = new Servidores(cantLiviano,cantMediano,cantPesado);


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
						   "\n\nPorcentaje de ocio de pistas de aviones livianos: " + tiempoOciosoLivianos/(tiempoSimulacion*cantLiviano) * 100 + " %" +
						   "\nPorcentaje de ocio de pistas de aviones medianos: " + tiempoOciosoMedianos/(tiempoSimulacion*cantMediano) * 100 + " %" +
						   "\nPorcentaje de ocio de pista de aviones pesados: " + tiempoOciosoPesados/(tiempoSimulacion*cantPesado) * 100 + " %" +
						   "\n\nTotal recaudado pista de aviones livianos: " + montoRecaudadoLivianos + " " +
						   "\nTotal recaudado pistas de aviones medianos: " + montoRecaudadoMedianos + "" +
						   "\nTotal recaudado pistas de aviones pesados: " + montoRecaudadoPesados);


	}
}

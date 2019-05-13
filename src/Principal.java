//import java.util.ListIterator;

import java.io.IOException;

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

		int cantCorridas = 50;

		double tiempoMedioOcioLivianos = 0;
		double tiempoMedioOcioMedianos = 0;
		double tiempoMedioOcioPesados = 0;



		Fel fel;

		for(int i = 0; i < cantCorridas; i++) {

			fel = Fel.getFel(); // Creo la lista de eventos futuros

			// Inicializa los servidores con la cantidad deseada para cada uno

			Servidores servidores = new Servidores(cantLiviano, cantMediano, cantPesado);


			// Inserta el evento de Fin de Simulación
			actual = new EventoFinSimulacion(tiempoFinSimulacion, -1);
			fel.insertarFel(actual);
			// Setea en 0 porque el Fin de Simulación contó un item que no existe
			Item.setCantidadItems(0);

			// Inserta el primer arribo Liviano
			actual = new EventoArribo(tiempoSimulacion, 0);
			fel.insertarFel(actual);

			// Inserta el primer arribo Mediano
			actual = new EventoArribo(tiempoSimulacion, 1);
			fel.insertarFel(actual);

			// Inserta el primer arribo Pesado
			actual = new EventoArribo(tiempoSimulacion, 2);
			fel.insertarFel(actual);


			while (!finSimulacion) {

				// Toma el siguiente evento de la FEL
				actual = fel.suprimirFel();
				actual.planificarEvento(servidores);

				// Si llega el Evento de Fin de Simulación termina
				if (actual instanceof EventoFinSimulacion)
					finSimulacion = true;
				else // Para que no guarde el tiempo del Evento de Fin de Simulación
					tiempoSimulacion = actual.getTiempo();
			}

			// Cálculo de tiempo ocioso de las tres pistas de cabotaje
			double tiempoOciosoLivianos = Estadisticas.calcularOcioPistas(servidores, 0);
			double tiempoOciosoMedianos = Estadisticas.calcularOcioPistas(servidores, 1);
			double tiempoOciosoPesados = Estadisticas.calcularOcioPistas(servidores, 2);

			tiempoMedioOcioLivianos = tiempoOciosoLivianos/(tiempoSimulacion*cantLiviano) *100;
			tiempoMedioOcioMedianos = tiempoOciosoMedianos/(tiempoSimulacion*cantMediano) *100;
			tiempoMedioOcioPesados = tiempoOciosoPesados/(tiempoSimulacion*cantPesado) *100;

			// Guarda los datos de las medias de la corrida
			Datos corrida  = new Datos(tiempoMedioOcioLivianos,tiempoMedioOcioMedianos,tiempoMedioOcioPesados);
			Estadisticas.addDatos(corrida);

			// Reseteo de variables
			Fel.resetFel();
			tiempoSimulacion = 0;
			finSimulacion = false;
			Item.resetItem();

		}

		// Escribe los datos de las corridas en csv
		try {
			Estadisticas.exportarDatosCorrida();
			Estadisticas.exportarDatosIntervalos(cantCorridas);
		}catch(IOException e){
			System.out.println("No se pudo exportar los datos");
		}

		Estadisticas.imprimirDatos(cantCorridas);
		/*
		System.out.println("\n\nTiempo medio de tránsito de los aviones privados: " + tiempoMedioTransitoLivianos/cantCorridas + "min." +
						   "\nTiempo medio de tránsito de los aviones de cabotaje: " + tiempoMedioTransitoMedianos/cantCorridas + "min." +
						   "\nTiempo medio de tránsito de los aviones internacionales: " + tiempoMedioTransitoPesados/cantCorridas + "min." +
				           "\n\nTiempo medio de espera en cola de aviones privados: " + tiempoMedioColaLivianos/cantCorridas + "min." +
					       "\nTiempo medio de espera en cola de aviones de cabotaje: " + tiempoMedioColaMedianos/cantCorridas + "min." +
						   "\nTiempo medio de espera en cola de aviones internacionales: " + tiempoMedioColaPesados/cantCorridas + "min." +
						   "\n\nPorcentaje de ocio de pistas de aviones livianos: " + tiempoMedioOcioLivianos/cantCorridas * 100 + " %" +
						   "\nPorcentaje de ocio de pistas de aviones medianos: " + tiempoMedioOcioMedianos/cantCorridas * 100 + " %" +
						   "\nPorcentaje de ocio de pista de aviones pesados: " + tiempoMedioOcioPesados/cantCorridas * 100 + " %");

		*/
	}

}

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.lang.Math;

public class Estadisticas {


	private static List<Datos> listaCorridas = new LinkedList<>();
	
	public static void calcularEstadisticas(double tiempoEsperaCola, double tiempoTransito, double tiempoOcioso,
			                                double tiempoFinSimulacion, int cantidadItems){
		
	}

	public static double calcularOcioPistas(Servidores servidores, int tipoArribo){
		double tiempoOcioso = 0;
		switch (tipoArribo){
			case 0:
				for(Servidor s : servidores.getServidoresLiviano()){
					tiempoOcioso += s.getTiempoOcioso();
				} break;
			case 1:
				for(Servidor s : servidores.getServidoresMediano()){
					tiempoOcioso += s.getTiempoOcioso();
				};break;
			case 2:
				for(Servidor s : servidores.getServidoresPesado()){
					tiempoOcioso += s.getTiempoOcioso();
				}
		}
		return tiempoOcioso;

	}

	public static int calcularMontoRecaudado(Servidores servidores, int tipoArribo){
		int montoRecaudado = 0;
		switch (tipoArribo){
			case 0:
				for(Servidor s : servidores.getServidoresLiviano()){
					montoRecaudado += s.getDineroRecaudado();
				} break;
			case 1:
				for(Servidor s : servidores.getServidoresMediano()){
					montoRecaudado += s.getDineroRecaudado();
				};break;
			case 2:
				for(Servidor s : servidores.getServidoresPesado()){
					montoRecaudado += s.getDineroRecaudado();
				}
		}
		return montoRecaudado;

	}

	public static void addDatos(Datos corrida){
		listaCorridas.add(corrida);
	}

	public static double calcularMediaTransito(int tipo, int cantCorridas){

		float total = 0;

		for(Datos d : listaCorridas){
			total += d.getTiempoMedioTransito()[tipo];
		}

		return total/cantCorridas;
	}

	public static double calcularVarianzaTransito(int tipo, int cantCorridas, double media){

		float total = 0;

		for(Datos d : listaCorridas){
			total += Math.pow(d.getTiempoMedioTransito()[tipo] - media,2) / (cantCorridas-1);
		}

		return total;
	}

	public static double calcularMediaOcio(int tipo, int cantCorridas){

		float total = 0;

		for(Datos d : listaCorridas){
			total += d.getTiempoMedioOcio()[tipo];
		}

		return total/cantCorridas;
	}

	public static double calcularVarianzaOcio(int tipo, int cantCorridas, double media){

		float total = 0;

		for(Datos d : listaCorridas){
			total += Math.pow(d.getTiempoMedioOcio()[tipo] - media,2) / (cantCorridas-1);
		}

		return total;

	}

	public static double calcularMediaCola(int tipo, int cantCorridas){

		float total = 0;

		for(Datos d : listaCorridas){
			total += d.getTiempoMedioCola()[tipo];
		}

		return total/cantCorridas;
	}

	public static double calcularVarianzaCola(int tipo, int cantCorridas, double media){

		float total = 0;

		for(Datos d : listaCorridas){
			total += Math.pow(d.getTiempoMedioCola()[tipo] - media,2) / (cantCorridas-1);
		}

		return total;
	}

	public static void exportarDatosCorrida() throws IOException {

		FileWriter corridasfw = new FileWriter(new File("corridas.csv"));
		BufferedWriter cwriter = new BufferedWriter(corridasfw);
		cwriter.write("");

		for(Datos d : listaCorridas){
			cwriter.write(d.getTiempoMedioTransito()[0]+",");
			cwriter.write(d.getTiempoMedioTransito()[1]+",");
			cwriter.write(d.getTiempoMedioTransito()[2]+",");
			cwriter.write(d.getTiempoMedioCola()[0]+",");
			cwriter.write(d.getTiempoMedioCola()[1]+",");
			cwriter.write(d.getTiempoMedioCola()[2]+",");
			cwriter.write(d.getTiempoMedioOcio()[0]+",");
			cwriter.write(d.getTiempoMedioOcio()[1]+",");
			cwriter.write(d.getTiempoMedioOcio()[2]+"");
			cwriter.newLine();
		}

		cwriter.close();
	}

	public static void exportarDatosIntervalos(int cantCorridas) throws IOException{

		double media;
		double varianza;
		double[] lim;

		FileWriter intervalosfw = new FileWriter(new File("intervalos.csv"));
		BufferedWriter iwriter = new BufferedWriter(intervalosfw);
		iwriter.write("");

		for(int i=0; i<3; i++){

			media = calcularMediaTransito(i,cantCorridas);
			varianza = calcularVarianzaTransito(i,cantCorridas,media);
			lim = calculoIntervalo(media,varianza,cantCorridas);

			iwriter.write(lim[0] + "," + lim[1]);
			iwriter.newLine();
		}

		for(int i=0; i<3; i++){

			media = calcularMediaOcio(i,cantCorridas);
			varianza = calcularVarianzaOcio(i,cantCorridas,media);
			lim = calculoIntervalo(media,varianza,cantCorridas);

			iwriter.write(lim[0] + "," + lim[1]);
			iwriter.newLine();
		}

		for(int i=0; i<3; i++){

			media = calcularMediaCola(i,cantCorridas);
			varianza = calcularVarianzaCola(i,cantCorridas,media);
			lim = calculoIntervalo(media,varianza,cantCorridas);

			iwriter.write(lim[0] + "," + lim[1]);
			iwriter.newLine();
		}

		iwriter.close();
	}

	public static double[] calculoIntervalo(double media, double varianza, int cantCorridas){

		double z = 1.65;
		double[] lim = new double[2];

		lim[0] = media - z * (Math.sqrt(varianza)/Math.sqrt(cantCorridas));
		lim[1] = media + z * (Math.sqrt(varianza)/Math.sqrt(cantCorridas));

		return lim;
	}

	public static void imprimirDatos(int cantCorridas){

		double media;
		double varianza;
		double[] lim = new double[2];

		for(int i=0; i<3; i++) {

			media = calcularMediaTransito(i,cantCorridas);
			varianza = calcularVarianzaTransito(i,cantCorridas,media);
			lim = calculoIntervalo(media,varianza,cantCorridas);

			System.out.println("Intervalo de confianza tiempo medio de tránsito de aviones "+ Item.type(i) +": \n");
			System.out.println("(" + lim[0] + " , " + lim[1] +")\n");
		}


		System.out.println("\n");
		for(int i=0; i<3; i++){

			media = calcularMediaCola(i,cantCorridas);
			varianza = calcularVarianzaCola(i,cantCorridas,media);
			lim = calculoIntervalo(media,varianza,cantCorridas);

			System.out.println("Intervalo de confianza tiempo medio de espera en cola de aviones "+ Item.type(i) +": \n");
			System.out.println("(" + lim[0] + " , " + lim[1] +")\n");
		}

		System.out.println("\n");
		for(int i=0; i<3; i++){

			media = calcularMediaOcio(i,cantCorridas);
			varianza = calcularVarianzaOcio(i,cantCorridas,media);
			lim = calculoIntervalo(media,varianza,cantCorridas);

			System.out.println("Intervalo de confianza porcentaje ocio de pistas de aviones "+ Item.type(i) +": \n");
			System.out.println("(" + lim[0] + "% , " + lim[1] +"%)\n");
		}
	}
}

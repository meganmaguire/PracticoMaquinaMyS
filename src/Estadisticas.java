public class Estadisticas {
	
	public static void calcularEstadisticas(float tiempoEsperaCola, float tiempoTransito, float tiempoOcioso, 
			                                float tiempoFinSimulacion, int cantidadItems){
		
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
}

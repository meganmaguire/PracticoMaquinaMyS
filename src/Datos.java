public class Datos {

    private double[] tiempoMedioTransito;
    private double[] tiempoMedioOcio;
    private double[] tiempoMedioCola;

    public Datos(double tiempoMedioOcioLivianos, double tiempoMedioOcioMedianos, double tiempoMedioOcioPesados){

        this.tiempoMedioTransito = new double[3];
        this.tiempoMedioOcio = new double[3];
        this.tiempoMedioCola = new double[3];

        this.tiempoMedioTransito[0] = Item.getTiempoTransitoLivianos()/Item.getCantidadLivianos();
        this.tiempoMedioTransito[1] = Item.getTiempoTransitoMedianos()/Item.getCantidadMedianos();
        this.tiempoMedioTransito[2] = Item.getTiempoTransitoPesados()/Item.getCantidadPesados();

        this.tiempoMedioCola[0] = Item.getTiempoEsperaColaLivianos()/Item.getCantidadLivianos();
        this.tiempoMedioCola[1] = Item.getTiempoEsperaColaMedianos()/Item.getCantidadMedianos();
        this.tiempoMedioCola[2] = Item.getTiempoEsperaColaPesados()/Item.getCantidadPesados();

        this.tiempoMedioOcio[0] = tiempoMedioOcioLivianos;
        this.tiempoMedioOcio[1] = tiempoMedioOcioMedianos;
        this.tiempoMedioOcio[2] = tiempoMedioOcioPesados;
    }

    /*
    public void setTiemposTransito(float tiempoMedioTransitoLivianos, float tiempoMedioTransitoMedianos,float tiempoMedioTransitoPesados){

        this.tiempoMedioTransito[1] = tiempoMedioTransitoLivianos;
        this.tiempoMedioTransito[2] = tiempoMedioTransitoMedianos;
        this.tiempoMedioTransito[3] = tiempoMedioTransitoPesados;
    }

    public void setTiemposOcio(float tiempoMedioOcioLivianos, float tiempoMedioOcioMedianos,float tiempoMedioOcioPesados){

        this.tiempoMedioOcio[1] = tiempoMedioOcioLivianos;
        this.tiempoMedioOcio[2] = tiempoMedioOcioMedianos;
        this.tiempoMedioOcio[3] = tiempoMedioOcioPesados;
    }

    public void setTiemposCola(float tiempoMedioColaLivianos, float tiempoMedioColaMedianos,float tiempoMedioColaPesados){

        this.tiempoMedioCola[1] = tiempoMedioColaLivianos;
        this.tiempoMedioCola[2] = tiempoMedioColaMedianos;
        this.tiempoMedioCola[3] = tiempoMedioColaPesados;
    }
    */
    public double[] getTiempoMedioTransito() {
        return tiempoMedioTransito;
    }

    public double[] getTiempoMedioOcio() {
        return tiempoMedioOcio;
    }

    public double[] getTiempoMedioCola() {
        return tiempoMedioCola;
    }
}

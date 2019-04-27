import java.awt.*;
import java.util.Random;
import java.lang.Math;


public class GeneradorTiempos {
	
    private static Random random;
        
    static{
        random=new Random(System.currentTimeMillis());
    }
       		
    public static int getTiempoEntreArribos(float tiempoSimulacion, int i){
        double num = random.nextDouble();
        int diaMin = 1440;
        float tiempoActual = tiempoSimulacion % diaMin;

        // Verifica si está en la frecuencia alta del día, de 7 a 9 y de 20 a 22

        if((tiempoActual >= 420 && tiempoActual <= 540) || (tiempoActual >= 1200 && tiempoActual <= 1320)) {

            switch (i) {
                // Avion Liviano
                case 0:
                    if (num <= 0.35)
                        return 40;
                    else
                        return 50;
                // Avion Mediano
                case 1:
                    if (num <= 0.5)
                        return 10;
                    else {
                        if (num <= 0.85)
                            return 20;
                        else
                            return 30;
                    }
                // Avion Pesado
                case 2:
                    if (num <= 0.4)
                        return 60;
                    else
                        return 90;
            }
        }
        else{

            switch (i) {
                // Avion Liviano
                case 0:
                    if (num <= 0.25)
                        return 60;
                    else
                        return 70;
                // Avion Mediano
                case 1:
                    if (num <= 0.3)
                        return 20;
                    else {
                        if (num <= 0.7)
                            return 30;
                        else
                            return 40;
                    }

                // Avion Pesado
                case 2:
                    if (num <= 0.5)
                        return 120;
                    else
                        return 180;
            }
        }
        // Por missing return statement
        return 0;
    }
	
    public static double getTiempoDuracionServicio(int i){
        double num = random.nextDouble();
        double x;
        // exponencial
        double lambda = 1.0 / 30.0;
        // uniforme
        double indSup = 20, indInf = 10;
        // normal
        double z = 0,zp;
        double muY = 120, sigY = 30;

        switch(i) {
            // exponencial
            case 0:
                return ((-1 / lambda) * Math.log((1 - num)));
            // uniforme
            case 1:
                x = indInf + (indSup - indInf) * num;
                return x;
            // normal
            case 2:
                for (int j = 0; j < 12; j++) {
                    z += random.nextDouble();
                }
                zp = (z - 6) / 1;
                x = zp * sigY + muY;
                return x;
        }
        // Por missing return statement
        return 0;
    }
}

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
        if((tiempoActual >= 420 || tiempoActual <= 540) || (tiempoActual >= 1200 || tiempoActual <= 1320)) {
            // Avion Liviano
            if( i == 0) {
                if (num <= 0.35)
                    return 40;
                else
                    return 50;
            }
            else{
                // Avion Mediano
                if(i == 1 || i == 2 || i == 3){
                    if(num <= 0.5)
                        return 10;
                    else{
                        if(num <= 0.85)
                            return 20;
                        else
                            return 30;
                    }
                }
                // Avion Pesado
                else{
                    if(num <= 0.4)
                        return 60;
                    else
                        return 90;
                }
            }
        }
        else{
            // Avion Liviano
            if(i == 0){
                if(num <= 0.25)
                    return 60;
                else
                    return 70;
            }
            else{
                // Avion Mediano
                if(i == 1 || i == 2 || i == 3){
                    if(num <= 0.3)
                        return 20;
                    else{
                        if(num <= 0.7)
                            return 30;
                        else
                            return 40;
                    }
                }
                // Avion Pesado
                else{
                    if(num <= 0.5)
                        return 120;
                    else
                        return 180;
                }
            }
        }
    }
	
    public static double getTiempoDuracionServicio(int i){
        double num = random.nextDouble();
        // exponencial
        double lambda = 1.0 / 30.0;
        // uniforme
        double indSup = 20, indInf = 10;
        // normal
        double z = 0,zp;
        double muY = 30, sigY = 120;

        if(i == 0)
            // exponencial
            return  ((-1/lambda) *Math.log((1-num)));
        else{
            if(i == 1 || i == 2 || i == 3){
                //uniforme
                double x = indInf + (indSup-indInf)*num;
                return x;
            }
            else{
                //normal
                for(int j=0; j<12; j++){
                    z+= random.nextDouble();
                }
                zp = (z - 6)/1;
                double x = zp * sigY + muY;
                return x;
            }

        }
    }
}

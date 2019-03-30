import java.util.Random;


public class GeneradorTiempos {
	
    private static Random random;
        
    static{
        random=new Random(System.currentTimeMillis());
    }
       		
    public static int getTiempoEntreArribos(){
        double num = random.nextDouble();
        if(num <= 0.3)
            return 4;
        else{
            if(num <= 0.6)
                return 5;
            else
                return 6;
        }
    }
	
    public static int getTiempoDuracionServicio(){
        double num = random.nextDouble();
        if(num <= 0.3)
            return 3;
        else{
            if(num <= 0.7)
                return 4;
            else
                return 5;
        }
    }
}

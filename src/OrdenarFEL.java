import java.util.Comparator;

public class OrdenarFEL implements Comparator<Evento> {

    public int compare(Evento e1, Evento e2){

        // Si el tiempo del primero es menor que el del segundo
        if(e1.getTiempo() < e2.getTiempo())
            return -1;
        else{
            // Si el tiempo del primero es mayor que el del segundo
            if(e1.getTiempo() > e2.getTiempo())
                return 1;
            else{
                // Si son iguales los tiempos, si es una Salida
                if(e1.getTipo() == 1)
                    return -1;
                // Si es un Arribo
                else
                    return 1;
            }
        }
    }
}

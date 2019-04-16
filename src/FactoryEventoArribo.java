public class FactoryEventoArribo{

    public static EventoArribo getEventoArribo(int i, float tiempo){
        switch (i){
            case 0: return new EventoArriboLiviano(tiempo);
            case 1: return new EventoArriboMediano(tiempo);
            case 2: return new EventoArriboMediano(tiempo);
            case 3: return new EventoArriboMediano(tiempo);
            case 4: return new EventoArriboPesado(tiempo);
        }
        return null;
    }
}

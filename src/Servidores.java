import java.util.LinkedList;
import java.util.List;

public class Servidores {

    private List<Servidor> servidoresLiviano;
    private List<Servidor> servidoresMediano;
    private List<Servidor> servidoresPesado;

    public Servidores(int cantLiviano, int cantMediano, int cantPesado){

        setServidoresLiviano(new LinkedList<>());
        setServidoresMediano(new LinkedList<>());
        setServidoresPesado(new LinkedList<>());

        for(int i=0;i < cantLiviano; i++){
            getServidoresLiviano().add(new Servidor());
        }

        for(int i=0;i < cantMediano; i++){
            getServidoresMediano().add(new Servidor());
        }

        for(int i=0;i < cantPesado; i++){
            getServidoresPesado().add(new Servidor());
        }

    }

    public boolean servidoresOcupados(int i){

        switch (i) {
            case 0:
                for (Servidor s : servidoresLiviano) {
                    if (!s.isEstado())
                        return false;

                }
            case 1:
                for (Servidor s : servidoresMediano) {
                    if (!s.isEstado())
                        return false;

                }
            case 2:
                for (Servidor s : servidoresPesado) {
                    if (!s.isEstado())
                        return false;

                }

        }
        return true;
    }

    /**
     *
     * Busca la cola más corta de todos los servidores disponibles
     *
    **/

    public Servidor buscarCola(int i){
        Servidor servidor = null;
        int cantidad = 100;

        switch (i) {
            case 0:
                for (Servidor s : servidoresLiviano) {
                    if (s.getQueue().getCantidadItems() < cantidad) {
                        cantidad = s.getQueue().getCantidadItems();
                        servidor = s;
                    }
                }
            case 1:
                for (Servidor s : servidoresMediano) {
                    if (s.getQueue().getCantidadItems() < cantidad) {
                        cantidad = s.getQueue().getCantidadItems();
                        servidor = s;
                    }
                }
            case 2:
                for (Servidor s : servidoresPesado) {
                    if (s.getQueue().getCantidadItems() < cantidad) {
                        cantidad = s.getQueue().getCantidadItems();
                        servidor = s;
                    }
                }
        }
        return servidor;

    }

    public Servidor buscarServidor(int i){

        switch (i) {
            case 0:
                for (Servidor s : servidoresLiviano) {
                    if (!s.isEstado())
                        return s;
                }
            case 1:
                for (Servidor s : servidoresMediano) {
                    if (!s.isEstado())
                        return s;
                }
            case 2:
                for (Servidor s : servidoresPesado) {
                    if (!s.isEstado())
                        return s;
                }
        }
        // Por missing return statement
        return null;

    }


    public Servidor buscarServidorActual(Item item){
        switch (item.getTipoArribo()){
            case 0:
                for(Servidor s : servidoresLiviano){
                    if(s.getItem()!= null && s.getItem().equals(item))
                        return s;
                }
            case 1:
                for(Servidor s : servidoresMediano){
                    if(s.getItem()!= null && s.getItem().equals(item))
                        return s;
                }
            case 2:
                for(Servidor s : servidoresPesado){
                    if(s.getItem()!= null && s.getItem().equals(item))
                        return s;
                }

        }
        // Por missing return statement
        return null;
    }

    public List<Servidor> getServidoresLiviano() {
        return servidoresLiviano;
    }

    public void setServidoresLiviano(List<Servidor> servidoresLiviano) {
        this.servidoresLiviano = servidoresLiviano;
    }

    public List<Servidor> getServidoresMediano() {
        return servidoresMediano;
    }

    public void setServidoresMediano(List<Servidor> servidoresMediano) {
        this.servidoresMediano = servidoresMediano;
    }

    public List<Servidor> getServidoresPesado() {
        return servidoresPesado;
    }

    public void setServidoresPesado(List<Servidor> servidoresPesado) {
        this.servidoresPesado = servidoresPesado;
    }
}

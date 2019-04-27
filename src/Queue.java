import java.util.LinkedList;


public class Queue {
	private int cantidadItems;
	private LinkedList cola;
	
		
	public Queue(){

		cola=new LinkedList();
		cantidadItems=0;
	}
	
	
	public void insertarCola(Item item){

		cola.addLast(item);
		cantidadItems++;
	}
	
	public Item suprimirCola(){

		cantidadItems--;
		return (Item) cola.removeFirst();
	}
	
	public boolean HayCola(){

		if(cantidadItems == 0)
			return false;
		else
			return true;
	}

	public int getCantidadItems() {

		return cantidadItems;
	}

}

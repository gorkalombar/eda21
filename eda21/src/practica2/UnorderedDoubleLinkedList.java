package segundaFase;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) {
	// a�ade un elemento al comienzo
	// coste constante
		Node<T> nuevo= new Node<T>();
		nuevo.setElement=elem;
		if (last==null) {
			last=nuevo;
		}else {
			
		}
	}

	public void addToRear(T elem) {
	// a�ade un elemento al final 
	// constante constante
		Node<T> nuevo= new Node<T>();
		nuevo.setElement=elem;
		if (last==null) {
			last=nuevo;
		}else {
			
		}
	}
	
	public void addAfter(T elem, T target) {
	// A�ade elem detr�s de otro elemento concreto, target,  que ya se encuentra en la lista
	//opcional
	}

}

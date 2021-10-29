package segundaFase;

public class Node<T> {
	public T data; 			// dato del nodo
	public Node<T> prev; 	// puntero al anterior nodo de la lista
	public Node<T> next; 	// puntero al siguiente nodo de la lista
		
	// constructor
	public Node(T pData){
		this.data = pData;
		this.next = null;
		this.prev = null;
	}
		
	public Node<T> getNext() {
		return this.next;
	}
		
	public void setNext(Node<T> node) {
        this.next = node;
    }	
	
	public Node<T> getPrevious() {
        return this.prev;
    }

    public void setPrevious(Node<T> node) {
        this.prev = node;
    }
    
    public T getElement() {
        return data;
    }

    public void setElement(T pData) {
        this.data = pData;
    }
}



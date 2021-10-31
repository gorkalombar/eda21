package segundaFase;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributos
	protected Node<T> last;  // apuntador al último
	protected String descr;  // descripción
	protected int count;

	// Constructor
	public DoubleLinkedList() {
        last = null;
		descr = "";
		count = 0;
	}
	
	public void setDescr(String nom) {
	  this.descr = nom;
	}

	public String getDescr() {
	  return this.descr;
	}

	public T removeFirst() {
	// Elimina el primer elemento de la lista
    // Precondición: hay al menos un elemento en la lista
	//coste constante	
		 T value = last.getNext().getElement();
		 if (count>1) {
			 Node<T> newfirst=last.getNext().getNext();
			 newfirst.setPrevious(last);
			 last.setNext(newfirst);
			 count=count-1;
		 }else {
			last=null;
			count=0;
		 }
		 return value;
	}

	public T removeLast() {
	// Elimina el último elemento de la lista
    // Precondición: hay al menos un elemento en la lista
	//coste constante
		 T value = last.getElement();
		 if (count>1) {
	     	Node<T> newLast = last.getPrevious();
	     	last.getNext().setPrevious(newLast);
	     	newLast.setNext(last.getNext());
	     	last = newLast;
	     	count=count-1;
		 }else {
			last=null;
			count=0;
		 } 
		 return value;
	 }

	public T remove(T elem) {
	//Elimina un elemento concreto de la lista
	//coste lineal
		Node<T> actual=last;
		Iterator<T> it = iterator();
		while (it.hasNext()){
			actual=last.getPrevious();
		}
		if(actual.equals(elem)){
			if(this.count>1) {
				actual.getPrevious().setNext(actual.getNext());
				actual.getNext().setPrevious(actual.getPrevious());
				this.count=this.count-1;
				if(actual==last) {
					last=actual.getPrevious();
				}
			}else {
				last=null;
				count=0;
			}
			return actual.getElement();		
		}
		return null;
	}

	public T first() {
	//Da acceso al primer elemento de la lista
	      if (isEmpty()) {
	    	  return null;
	      }else {
	    	  return last.next.data;
	      }
	}

	public T last() {
	//Da acceso al último elemento de la lista
	      if (isEmpty()) {
	    	  return null;
	      }else {
	    	  return last.data;
	      }
	}

	public boolean contains(T elem) {
	//Determina si la lista contiene un elemento concreto
	//coste	n
		if (isEmpty()) {
			return false;
		}else {
			boolean enc;
			enc=false;
			Node<T> actual=last;
			Iterator<T> it = iterator();
			while (it.hasNext()||enc){
				if(actual.equals(elem)) {
					enc=true;
				}
				actual=last.getPrevious();
			}
			return enc;
		}
	}

	public T find(T elem) {
	//Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no esté
	// coste n
		if (isEmpty()) {
			return null;
		}else {
			Node<T> actual=last;
			int cont;
			cont=this.count;
			
			
			return actual;
			
		}
	}

	public boolean isEmpty() {
	//Determina si la lista está vacía
		return last == null;
	}
	
	public int size() {
	//Determina el número de elementos de la lista
		return this.count;
	}
	
	
	public Iterator<T> iterator() { 
		return new ListIterator(); 
	} 

	private class ListIterator implements Iterator<T> {
	// coste n
		private Node<T> actual;
		
		public ListIterator(Node<T> last) {
			actual=last;
		}
		
		public boolean hasNext() {
			boolean salir;
			salir=false;
			
			return
		
		}
	

		public T next() {
			if (! hasNext()) {
				throw new NoSuchElementException();
			} 	
			T result = actual.getElement();
			actual= actual.getNext();
			return result;
		}
	} 
		
		
    public void visualizarNodos() {
    	System.out.println(this.toString());
	}

	@Override
	public String toString() {
		String result = new String();
		Iterator<T> it = iterator();
		while (it.hasNext()) {
			T elem = it.next();
			result = result + "[" + elem.toString() + "] \n";
		}	
		return "DoubleLinkedList " + result + "]";
	}

}

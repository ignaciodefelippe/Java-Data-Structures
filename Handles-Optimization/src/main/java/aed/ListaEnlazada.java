package aed;

import java.util.NoSuchElementException;

public class ListaEnlazada<T> {


    private Nodo primero;
    private Nodo ultimo;
    private int longitud;


    private class Nodo {
        T valor; 
        Nodo siguiente; 
        Nodo anterior; 
        
        Nodo(T v) { valor = v; }
    }


    public ListaEnlazada() {
        primero = null; 
        ultimo = null; 
        longitud = 0;
    }


    public int longitud() {
        return longitud;
    }


    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem); 
        if (primero == null) { 
            primero = ultimo = nuevo; 
        } else { 
            nuevo.siguiente = primero; 
            primero.anterior = nuevo; 
            primero = nuevo; 
        } 
        longitud += 1;
    }


    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem); 
        if (ultimo == null) { 
            primero = ultimo = nuevo; 
        } else { 
            nuevo.anterior = ultimo; 
            ultimo.siguiente = nuevo; 
            ultimo = nuevo; 
        } 
        longitud += 1;
    }


    public T obtener(int i) {
        Nodo actual = primero;
        for (int j = 0; j < i; j++) {
            actual = actual.siguiente;
        }
        return actual.valor;
    }


    public void eliminar(int i) {
        Nodo actual = primero;
        for (int j = 0; j < i; j++) {
            actual = actual.siguiente;
        }
        if (actual.anterior != null) {
            actual.anterior.siguiente = actual.siguiente;
        } else {
            primero = actual.siguiente;
        }    
        if (actual.siguiente != null) {
            actual.siguiente.anterior = actual.anterior;
        } else {
            ultimo = actual.anterior;
        }
        longitud -= 1;
    }


    public void modificarPosicion(int indice, T elem) {
        Nodo actual = primero;
        for (int j = 0; j < indice; j++) {
            actual = actual.siguiente;
        }
        actual.valor = elem;
    }


    public ListaEnlazada(ListaEnlazada<T> lista) {
        Nodo actual = lista.primero;
        while (actual != null) {
            agregarAtras(actual.valor);
            actual = actual.siguiente;
        }
    }

    
    @Override
    public String toString() {
        String res = "[";
        Nodo actual = primero;
        while (actual != null) {
            res += actual.valor;
            if (actual.siguiente != null) {
                res += ", ";
            }
            actual = actual.siguiente;
        }
        res += "]";
        return res;
    }


    public class ListaIterador {
    	int dedito;
        Nodo actual; 

        ListaIterador() { 
            dedito = 0;
            actual = primero; 
        }

        public boolean haySiguiente() {
	        return dedito < longitud;
        }
        
        public boolean hayAnterior() {
	        return dedito > 0;
        }

        public T siguiente() {
	        T valor = actual.valor; 
            actual = actual.siguiente; 
            dedito += 1;
            return valor;
        }
        

        public T anterior() {
	        if (actual == null) {
                actual = ultimo;
            } else {
                actual = actual.anterior;
            }
            dedito -= 1;
            return actual.valor;
        }
    }

    public ListaIterador iterador() {
	    return new ListaIterador();
    }

}

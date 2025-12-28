package aed;

import java.util.NoSuchElementException;

public class ABB<T extends Comparable<T>> {


    private Nodo _raiz;
    private int _cardinal;


    private class Nodo {
        T valor;
        Nodo izq;
        Nodo der;
        Nodo padre;

        public Nodo(T v) {
            this.valor = v;
            this.izq = null;
            this.der = null;
            this.padre = null;
        }
    }


    public class HandleABB{
        private Nodo nodoApuntado;

        private HandleABB(Nodo n) {
            this.nodoApuntado = n;
        }

        public T valor() {
            return nodoApuntado.valor;
        }

        public void eliminar() {
            ABB.this.eliminar(this.nodoApuntado.valor);
        }

        public String toString() {
            return this.nodoApuntado.valor.toString();
        }
    }


    public ABB() {
        this._raiz = null;
        this._cardinal = 0;
    }


    public int cardinal() {
        return this._cardinal;
    }


    public T minimo(){
        Nodo actual = this._raiz;
        while (actual.izq != null) {
            actual = actual.izq;
        }
        return actual.valor;
    }


    public T maximo(){
        Nodo actual = this._raiz;
        while (actual.der != null) {
            actual = actual.der;
        }
        return actual.valor;
    }


    public HandleABB insertar(T elem) {
        if (this._raiz == null) {
            this._raiz = new Nodo(elem);
            this._cardinal = 1;
            return new HandleABB(this._raiz);
        }

        Nodo actual = this._raiz;
        Nodo padre = null;

        while (actual != null) {
            padre = actual;
            int comp = elem.compareTo(actual.valor);

            if (comp == 0) {
                return new HandleABB(actual);
            } else if (comp < 0) {
                actual = actual.izq;
            } else {
                actual = actual.der;
            }
        }

        Nodo nuevo = new Nodo(elem);
        nuevo.padre = padre;

        if (elem.compareTo(padre.valor) < 0) {
            padre.izq = nuevo;
        } else {
            padre.der = nuevo;
        }

        this._cardinal += 1;
        return new HandleABB(nuevo);
    }


    public boolean pertenece(T elem) {
        Nodo actual = this._raiz;

        while (actual != null) {
            int comp = elem.compareTo(actual.valor);
            if (comp == 0) {
                return true;
            } else if (comp < 0) {
                actual = actual.izq;
            } else {
                actual = actual.der;
            }
        }
        return false;
    }


    public void eliminar(T elem) {
        Nodo n = this._raiz;

        while (n != null) {
            int comp = elem.compareTo(n.valor);
            if (comp == 0) {
                break;
            } else if (comp < 0) {
                n = n.izq;
            } else {
                n = n.der;
            }
        }

        if (n == null) {
            return;
        }
        
        if (n.izq == null) {
            if (n.padre == null) {
                this._raiz = n.der;
            } else if (n == n.padre.izq) {
                n.padre.izq = n.der;
            } else {
                n.padre.der = n.der;
            }
            if (n.der != null) {
                n.der.padre = n.padre;
            }

        } else if (n.der == null) {
            if (n.padre == null) {
                this._raiz = n.izq;
            } else if (n == n.padre.izq) {
                n.padre.izq = n.izq;
            } else {
                n.padre.der = n.izq;
            }
            if (n.izq != null) {
                n.izq.padre = n.padre;
            }

        } else {
            Nodo suc = n.der;
            while (suc.izq != null) {
                suc = suc.izq;
            }
            
            if (suc.padre != n) {
                suc.padre.izq = suc.der;
                if (suc.der != null) {
                    suc.der.padre = suc.padre;
                }
                suc.der = n.der;
                suc.der.padre = suc;
            }

            if (n.padre == null) {
                this._raiz = suc;
            } else if (n == n.padre.izq) {
                n.padre.izq = suc;
            } else {
                n.padre.der = suc;
            }
            suc.padre = n.padre;
            suc.izq = n.izq;
            suc.izq.padre = suc;
        }

        this._cardinal -= 1;
    }


    @Override
    public String toString() {
        String res = "{";
        ABB_Iterador iterador = this.iterador();

        if (iterador.haySiguiente()) {
            res += iterador.siguiente().toString();
        }

        while (iterador.haySiguiente()) {
            res += ", ";
            res += iterador.siguiente().toString();
        }

        res += "}";
        
        return res;
    }


    public class ABB_Iterador {
        private Nodo _actual;


        public ABB_Iterador() {
            if (_raiz == null) {
                this._actual = null;
            } else {
                Nodo n = _raiz;
                while (n.izq != null) {
                    n = n.izq;
                }
                this._actual = n;
            }
        }

        
        public boolean haySiguiente() {            
            return this._actual != null;
        }
    

        public T siguiente() {
            T valor = this._actual.valor;
            Nodo n = this._actual;

            if (n.der != null) {
                Nodo suc = n.der;
                while (suc.izq != null) {
                    suc = suc.izq;
                }
                this._actual = suc;
            
            } else {
                Nodo p = n.padre;
                while (p != null && n == p.der) {
                    n = p;
                    p = p.padre;
                }
                this._actual = p;
            }

            return valor;
        }
    }


    public ABB_Iterador iterador() {
        return new ABB_Iterador();
    }

}

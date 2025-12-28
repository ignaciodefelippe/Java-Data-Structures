package aed;

public class SistemaPedidos {
    private ABB<Pedido> _abb;
    private ListaEnlazada<ABB<Pedido>.HandleABB> _lista;

    public SistemaPedidos(){
        _abb = new ABB<Pedido>();
        _lista = new ListaEnlazada<ABB<Pedido>.HandleABB>();
    }

    public void agregarPedido(Pedido pedido){
        ABB<Pedido>.HandleABB handle = _abb.insertar(pedido);
        
        _lista.agregarAtras(handle);
    }

    public Pedido proximoPedido(){
        ABB<Pedido>.HandleABB handle = _lista.obtener(0);
        
        Pedido pedido = handle.valor();
        
        _lista.eliminar(0);
        
        handle.eliminar();
        
        return pedido;
    }

    public Pedido pedidoMenorId(){
        return _abb.minimo();
    }

    public String obtenerPedidosEnOrdenDeLlegada(){
        return _lista.toString();
    }

    public String obtenerPedidosOrdenadosPorId(){
        return _abb.toString();
    }
}
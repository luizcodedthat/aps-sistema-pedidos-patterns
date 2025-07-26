package repositorio;

import java.util.ArrayList;
import java.util.List;

import modelo.Pedido;

public class PedidoRepositorio implements Repositorio<Pedido> {
	
	static PedidoRepositorio instancia;
    private List<Pedido> pedidos = new ArrayList<>();
	
	private PedidoRepositorio() {}
	
	static public PedidoRepositorio getInstancia() {
		if (instancia != null) {
			return instancia;
		} else {
			instancia = new PedidoRepositorio();
			return instancia;
		}
	}
	
	@Override
	public void salvar (Pedido Pedido) {
		pedidos.add(Pedido);
	}
	
	@Override
	public List<Pedido> buscarTodos() {
		return pedidos;
	}

	@Override
	public boolean estaVazio() {
		return pedidos.isEmpty();
	}

}

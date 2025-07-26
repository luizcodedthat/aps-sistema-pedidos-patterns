package servico;

import java.util.List;

import modelo.Pedido;
import repositorio.ClienteRepositorio;
import repositorio.PedidoRepositorio;
import repositorio.ProdutoRepositorio;

public class PedidoServico {
	
	PedidoRepositorio pedidoRepositorio;
	ClienteRepositorio clienteRepositorio;
	ProdutoRepositorio produtoRepositorio;
	
	public PedidoServico() {
		pedidoRepositorio = PedidoRepositorio.getInstancia();
		clienteRepositorio = ClienteRepositorio.getInstancia();
		produtoRepositorio = ProdutoRepositorio.getInstancia();
	}
	
	public boolean cadastroEstaDisponivel() {
		if (clienteRepositorio.estaVazio() || produtoRepositorio.estaVazio()) {
			return false;
		}
		return true;
	}
	
	public void cadastrar(Pedido pedido) {
		if (!cadastroEstaDisponivel()) {
			return;
		}
		pedidoRepositorio.salvar(pedido);
	}
	
	public List<Pedido> listar() {
		return pedidoRepositorio.buscarTodos();
	}
	
}

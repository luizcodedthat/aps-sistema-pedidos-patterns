package repositorio;

import java.util.ArrayList;
import java.util.List;

import modelo.Produto;

public class ProdutoRepositorio implements Repositorio<Produto> {
	
	static ProdutoRepositorio instancia;
    private List<Produto> produtos = new ArrayList<>();
	
	private ProdutoRepositorio() {}
	
	static public ProdutoRepositorio getInstancia() {
		if (instancia != null) {
			return instancia;
		} else {
			instancia = new ProdutoRepositorio();
			return instancia;
		}
	}
	
	@Override
	public void salvar (Produto produto) {
		produtos.add(produto);
	}
	
	@Override
	public List<Produto> buscarTodos() {
		return produtos;
	}

	@Override
	public boolean estaVazio() {
		return produtos.isEmpty();
	}
	
}

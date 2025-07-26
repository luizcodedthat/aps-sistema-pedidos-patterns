package servico;

import java.util.List;

import modelo.Produto;
import repositorio.ProdutoRepositorio;

public class ProdutoServico {
	
	ProdutoRepositorio repositorio;
	
	public ProdutoServico() {
		repositorio = ProdutoRepositorio.getInstancia();
	}
	
	public void cadastrar(String nome, double preco, double peso) {
		Produto produto = new Produto(nome, preco, peso);
		repositorio.salvar(produto);
	}
	
	public List<Produto> listar() {
		return repositorio.buscarTodos();
	}

}

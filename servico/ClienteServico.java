package servico;

import java.util.List;

import modelo.Cliente;
import repositorio.ClienteRepositorio;

public class ClienteServico {
	
	ClienteRepositorio repositorio;
	
	public ClienteServico() {
		repositorio = ClienteRepositorio.getInstancia();
	}
	
	public void cadastrar(String nome, String cpf, String email, String telefone) {
		Cliente cliente = new Cliente(nome, cpf, email, telefone);
		repositorio.salvar(cliente);
	}
	
	public List<Cliente> listar() {
		return repositorio.buscarTodos();
	}

}

package repositorio;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

public class ClienteRepositorio implements Repositorio<Cliente> {
	
	static ClienteRepositorio instancia;
    private List<Cliente> clientes = new ArrayList<>();
	
	private ClienteRepositorio() {}
	
	public static ClienteRepositorio getInstancia() {
		if (instancia != null) {
			return instancia;
		} else {
			instancia = new ClienteRepositorio();
			return instancia;
		}
	}
	
	@Override
	public void salvar (Cliente Cliente) {
		clientes.add(Cliente);
	}
	
	@Override
	public List<Cliente> buscarTodos() {
		return clientes;
	}

	@Override
	public boolean estaVazio() {
		return clientes.isEmpty();
	}
	
}

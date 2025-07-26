package repositorio;

import java.util.List;

public interface Repositorio<T> {

	public void salvar(T entidade);
	public List<T> buscarTodos();
	public boolean estaVazio();
	
}

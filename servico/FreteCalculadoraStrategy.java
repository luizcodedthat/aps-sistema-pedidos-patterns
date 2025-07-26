package servico;

import modelo.Pedido;

public interface FreteCalculadoraStrategy {
	double calcular(Pedido pedido, Double valor);
}

package servico;

import modelo.Pedido;

public class FreteCalculadoraPeso implements FreteCalculadoraStrategy {
	public double calcular(Pedido p, Double d) {
        return p.getItens().stream()
                  .mapToDouble(i -> i.getProduto().getPeso() * i.getQuantidade())
                  .sum() * 5.0;
    }
}

package servico;

import modelo.Pedido;

public class FreteCalculadoraDistancia implements FreteCalculadoraStrategy {
	public double calcular(Pedido p, Double d) {
        if (d == null) throw new IllegalArgumentException("Distância nula");
        return d * 0.5;
    }
}
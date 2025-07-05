package servico;

import modelo.Pedido;

public class FreteCalculadoraDistancia implements FreteCalculadora {
    public double calcular(double distancia) {
        return distancia * 0.5;
    }
}
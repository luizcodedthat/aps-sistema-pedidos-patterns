package servico;

public class FreteFactory {
    public static FreteCalculadoraStrategy criarCalculadora(String tipo) {
        if (tipo.equalsIgnoreCase("peso")) {
            return new FreteCalculadoraPeso();
        } else if (tipo.equalsIgnoreCase("distancia")) {
        	
            return new FreteCalculadoraDistancia();
        }
        throw new IllegalArgumentException("Tipo de frete inválido: " + tipo);
    }
}
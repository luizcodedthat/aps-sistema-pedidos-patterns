package servico;

import modelo.Cliente;

public class NotificadorSMS implements NotificadorStrategy {
    public void enviar(String mensagem, Cliente cliente) {
        System.out.println("Enviando SMS para " + cliente.getTelefone() + ": " + mensagem);
    }
}

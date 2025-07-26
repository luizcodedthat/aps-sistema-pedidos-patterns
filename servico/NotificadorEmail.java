package servico;

import modelo.Cliente;

public class NotificadorEmail implements NotificadorStrategy {
    public void enviar(String mensagem, Cliente cliente) {
        System.out.println("Enviando e-mail para " + cliente.getEmail() + ": " + mensagem);
    }
}

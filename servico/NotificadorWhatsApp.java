package servico;

import modelo.Cliente;

public class NotificadorWhatsApp implements NotificadorStrategy {
    public void enviar(String mensagem, Cliente cliente) {
        System.out.println("Enviando WhatsApp para " + cliente.getTelefone() + ": " + mensagem);
    }
}
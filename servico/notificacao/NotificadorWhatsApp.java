package servico;

import modelo.Cliente;


public class NotificadorWhatsApp implements Notificador {
    public void enviar(String mensagem, Cliente cliente) {
        System.out.println("Enviando WhatsApp para " + cliente.getWhatsApp() + ": " + mensagem);
    }
}
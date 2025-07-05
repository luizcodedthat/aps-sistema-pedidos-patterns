package servico;

import modelo.Cliente;


public class NotificadorSMS implements Notificador {
    public void enviar(String mensagem, Cliente cliente) {
        System.out.println("Enviando SMS para " + cliente.getSMS() + ": " + mensagem);
    }
}

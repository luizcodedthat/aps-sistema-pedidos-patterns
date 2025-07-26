package servico;

import modelo.Cliente;

public interface NotificadorStrategy {
    void enviar(String mensagem, Cliente cliente);
}

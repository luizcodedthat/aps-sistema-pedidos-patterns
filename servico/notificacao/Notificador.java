package servico.notificacao;

import modelo.Cliente;

public interface Notificador {
    void enviar(String mensagem, Cliente cliente);
}

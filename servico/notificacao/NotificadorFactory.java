package servico.notificacao;

public class NotificadorFactory {
    public static Notificador criarNotificador(String tipo) {
        if (tipo.equalsIgnoreCase("email")) {
            return new NotificadorEmail();
        } else if (tipo.equalsIgnoreCase("sms")) {
            return new NotificadorSMS();
        } else if (tipo.equalsIgnoreCase("whatsapp")) {
            return new NotificadorWhatsApp();
        }
        throw new IllegalArgumentException("Tipo de notificação inválido: " + tipo);
    }
}
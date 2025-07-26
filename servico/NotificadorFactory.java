package servico;

public class NotificadorFactory {
    public static NotificadorStrategy criarNotificador(String tipo) {
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
package relatorio;

import modelo.Pedido;

public abstract class RelatorioBase {
    public final void gerar(Pedido pedido) {
        montarCabecalho(pedido);
        montarCorpo(pedido);
        montarRodape(pedido);
    }

    protected abstract void montarCabecalho(Pedido pedido);
    protected abstract void montarCorpo(Pedido pedido);
    protected abstract void montarRodape(Pedido pedido);
}

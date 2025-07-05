package relatorio;

import modelo.*;


public class RelatorioTexto extends RelatorioBase {

    protected void montarCabecalho(Pedido pedido) {
        System.out.println("Cliente: " + pedido.getCliente().getNome());
    }

    protected void montarCorpo(Pedido pedido) {
        pedido.getItens().forEach(item ->
            System.out.println("- " + item.getProduto().getNome() + " (" + item.getQuantidade() + "x) - R$ " + item.getSubtotal())
        );
    }

    protected void montarRodape(Pedido pedido) {
        System.out.println("Total: R$ " + pedido.getTotal());
        System.out.println("Frete: R$ " + pedido.getFrete());
        System.out.println("Total com frete: R$ " + pedido.getTotalComFrete());
    }
}
package relatorio;

import modelo.Pedido;
import modelo.ItemPedido;

public class RelatorioJSON extends RelatorioBase {

    @Override
    protected void montarCabecalho(Pedido pedido) {
        System.out.println("{");
        System.out.println("  \"cliente\": \"" + pedido.getCliente().getNome() + "\",");
        System.out.println("  \"produtos\": [");
    }

    @Override
    protected void montarCorpo(Pedido pedido) {
        int contador = 0;
        for (ItemPedido item : pedido.getItens()) {
            System.out.println("    {\"nome\": \"" + item.getProduto().getNome() + "\", \"quantidade\": " + item.getQuantidade() + ", \"preco\": " + item.getTotal() + "}"
                    + (contador < pedido.getItens().size() - 1 ? "," : ""));
            contador++;
        }
        System.out.println("  ],");
    }

    @Override
    protected void montarRodape(Pedido pedido) {
        System.out.println("  \"total\": " + pedido.getTotal() + ",");
        System.out.println("  \"frete\": " + pedido.getFrete() + ",");
        System.out.println("  \"total_com_frete\": " + pedido.getTotalComFrete());
        System.out.println("}");
    }
}

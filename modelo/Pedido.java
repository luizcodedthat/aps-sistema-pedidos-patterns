package modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<ItemPedido> itens;
    private double frete;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto, int quantidade) {
        itens.add(new ItemPedido(produto, quantidade));
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public double getTotal() {
        return itens.stream().mapToDouble(ItemPedido::getTotal).sum();
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public double getFrete() {
        return frete;
    }

    public double getTotalComFrete() {
        return getTotal() + frete;
    }

    public double getPesoTotal() {
        return itens.stream().mapToDouble(ItemPedido::getPesoTotal).sum();
    }
}

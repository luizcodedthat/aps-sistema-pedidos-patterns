package modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final Cliente cliente;
    private final List<ItemPedido> itens = new ArrayList<>();
    private double frete;

    private Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public static class Builder {
        private final Pedido pedido;
        public Builder(Cliente cliente) {
            pedido = new Pedido(cliente);
        }
        public Builder comItem(Produto p, int qtd) {
            pedido.itens.add(new ItemPedido(p, qtd));
            return this;
        }
        public Pedido build() {
            if (pedido.itens.isEmpty())
                throw new IllegalStateException("Pedido sem itens");
            return pedido;
        }
    }

    public Cliente getCliente()   {
    	return cliente;
    }
    
    public List<ItemPedido> getItens() {
    	return List.copyOf(itens);
    
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
    
    public double getTotal() {
        return itens.stream().mapToDouble(ItemPedido::getTotal).sum();
    }
    
    public double getPesoTotal() {
        return itens.stream().mapToDouble(ItemPedido::getPesoTotal).sum();
    }
}

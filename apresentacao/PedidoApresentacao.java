package apresentacao;

import java.util.List;
import java.util.Scanner;

import modelo.Cliente;
import modelo.Produto;
import relatorio.RelatorioJSON;
import relatorio.RelatorioTexto;
import modelo.ItemPedido;
import modelo.Pedido;
import servico.PedidoServico;
import servico.ClienteServico;
import servico.ProdutoServico;

import servico.FreteFactory;
import servico.FreteCalculadoraStrategy;

import servico.NotificadorFactory;
import servico.NotificadorStrategy;

public class PedidoApresentacao {
	
	private final ClienteServico clienteServico = new ClienteServico();
	private final ProdutoServico produtoServico = new ProdutoServico();
	private final PedidoServico pedidoServico = new PedidoServico();
	Scanner scanner;
	
	PedidoApresentacao(Scanner scanner) {
		this.scanner = scanner;
	}
	
	void cadastrarPedido() {
		if (!pedidoServico.cadastroEstaDisponivel()) {
            System.out.println("Cadastre ao menos um cliente e um produto antes de criar um pedido.");
            return;
        }

		List<Cliente> clientes = clienteServico.listar();
        System.out.println("Clientes disponíveis:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNome());
        }
        System.out.print("Escolha um cliente: ");
        int clienteIndex = Integer.parseInt(scanner.nextLine()) - 1;
        Cliente cliente = clientes.get(clienteIndex);

        List<Produto> produtos = produtoServico.listar();
        Pedido.Builder pedido = new Pedido.Builder(cliente);

        while (true) {
            System.out.println("\nProdutos disponíveis:");
            for (int i = 0; i < produtos.size(); i++) {
                System.out.println((i + 1) + ". " + produtos.get(i).getNome());
            }
            System.out.print("Escolha um produto (0 para finalizar): ");
            int prodIndex = Integer.parseInt(scanner.nextLine()) - 1;
            if (prodIndex == -1) break;
            Produto prod = produtos.get(prodIndex);

            System.out.print("Quantidade: ");
            int quantidade = Integer.parseInt(scanner.nextLine());
            pedido.comItem(prod, quantidade);
        }

        System.out.println("Escolha o tipo de frete:");
        System.out.println("1. Por peso (R$5/kg)");
        System.out.println("2. Por distância (R$0,50/km)");
        int freteOpcao = Integer.parseInt(scanner.nextLine());
        FreteCalculadoraStrategy freteCalculadora;
        
        Pedido pedidoPronto = pedido.build();
        double valorFrete;

        if (freteOpcao == 1) {
            freteCalculadora = FreteFactory.criarCalculadora("peso") ;
            valorFrete = freteCalculadora.calcular(pedidoPronto, 1.0);
        } else {
            System.out.print("Informe a distância (km): ");
            double km = Double.parseDouble(scanner.nextLine());
            freteCalculadora = FreteFactory.criarCalculadora("distancia"); //.calcular(pedido, km);
            valorFrete = freteCalculadora.calcular(pedidoPronto, km);
        }
        pedidoPronto.setFrete(valorFrete);

        System.out.println("Escolha o tipo de notificação:");
        System.out.println("1. E-mail");
        System.out.println("2. SMS");
        System.out.println("3. WhatsApp");
        int notif = Integer.parseInt(scanner.nextLine());
        
        NotificadorStrategy notificador = null;
        String mensagem = "Seu último pedido foi criado com sucesso!";

        switch (notif) {
            case 1 -> notificador = NotificadorFactory.criarNotificador("email");
            case 2 -> notificador = NotificadorFactory.criarNotificador("sms");
            case 3 -> notificador = NotificadorFactory.criarNotificador("whatsapp");
        }

        notificador.enviar(mensagem, cliente);
        
        pedidoServico.cadastrar(pedidoPronto);
        System.out.println("Pedido criado com sucesso!");

    }
	
	void gerarRelatorio() {
		
		List<Pedido> pedidos = pedidoServico.listar();
		
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido para gerar relatório.");
            return;
        }

        for (int i = 0; i < pedidos.size(); i++) {
            System.out.println((i + 1) + ". Pedido de " + pedidos.get(i).getCliente().getNome());
        }

        System.out.print("Escolha um pedido: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        Pedido pedido = pedidos.get(index);

        System.out.println("Formato do relatório:");
        System.out.println("1. Texto");
        System.out.println("2. JSON");
        int opcao = Integer.parseInt(scanner.nextLine());

        if (opcao == 1) {
            new RelatorioTexto().gerar(pedido);
        } else {
            new RelatorioJSON().gerar(pedido);
        }
    }

}
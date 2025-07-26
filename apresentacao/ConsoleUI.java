package apresentacao;

import java.util.Scanner;

public class ConsoleUI {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ClienteApresentacao clienteApresentacao = new ClienteApresentacao(scanner);
		PedidoApresentacao pedidoApresentacao = new PedidoApresentacao(scanner);
		ProdutoApresentacao produtoApresentacao = new ProdutoApresentacao(scanner);
		
		int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Produto");
            System.out.println("3. Criar Pedido");
            System.out.println("4. Gerar Relatório de Pedido");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> clienteApresentacao.cadastrarCliente();
                case 2 -> produtoApresentacao.cadastrarProduto();
                case 3 -> pedidoApresentacao.cadastrarPedido();
                case 4 -> pedidoApresentacao.gerarRelatorio();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
	}

}

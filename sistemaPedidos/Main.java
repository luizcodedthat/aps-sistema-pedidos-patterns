package sistemaPedidos;

import servico.*;
import relatorio.*;

import java.util.*;

import modelo.*;

public class Main {
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Produto> produtos = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
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
                case 1 -> cadastrarCliente();
                case 2 -> cadastrarProduto();
                case 3 -> criarPedido();
                case 4 -> gerarRelatorio();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        clientes.add(new Cliente(nome, cpf, email, telefone));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void cadastrarProduto() {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = Double.parseDouble(scanner.nextLine());
        System.out.print("Peso (kg): ");
        double peso = Double.parseDouble(scanner.nextLine());

        produtos.add(new Produto(nome, preco, peso));
        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void criarPedido() {
        if (clientes.isEmpty() || produtos.isEmpty()) {
            System.out.println("Cadastre ao menos um cliente e um produto antes de criar um pedido.");
            return;
        }

        System.out.println("Clientes disponíveis:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNome());
        }
        System.out.print("Escolha um cliente: ");
        int clienteIndex = Integer.parseInt(scanner.nextLine()) - 1;
        Cliente cliente = clientes.get(clienteIndex);

        Pedido pedido = new Pedido(cliente);

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
            pedido.adicionarItem(prod, quantidade);
        }

        System.out.println("Escolha o tipo de frete:");
        System.out.println("1. Por peso (R$5/kg)");
        System.out.println("2. Por distância (R$0,50/km)");
        int freteOpcao = Integer.parseInt(scanner.nextLine());
        double frete = 0;

        if (freteOpcao == 1) {
            frete = new FreteCalculadoraPeso().calcular(pedido);
        } else {
            System.out.print("Informe a distância (km): ");
            double km = Double.parseDouble(scanner.nextLine());
            frete = new FreteCalculadoraDistancia().calcular(pedido, km);
        }
        pedido.setFrete(frete);

        System.out.println("Escolha o tipo de notificação:");
        System.out.println("1. E-mail");
        System.out.println("2. SMS");
        System.out.println("3. WhatsApp");
        int notif = Integer.parseInt(scanner.nextLine());

        switch (notif) {
            case 1 -> new NotificadorEmail().enviar(cliente);
            case 2 -> new NotificadorSMS().enviar(cliente);
            case 3 -> new NotificadorWhatsApp().enviar(cliente);
        }

        pedidos.add(pedido);
        System.out.println("Pedido criado com sucesso!");
    }

    private static void gerarRelatorio() {
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

package apresentacao;

import java.util.Scanner;

import modelo.Produto;
import servico.ProdutoServico;

public class ProdutoApresentacao {
	
	private final ProdutoServico produtoServico = new ProdutoServico();
	Scanner scanner;
	
	ProdutoApresentacao(Scanner scanner) {
		this.scanner = scanner;
	}
	
	void cadastrarProduto() {
		System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = Double.parseDouble(scanner.nextLine());
        System.out.print("Peso (kg): ");
        double peso = Double.parseDouble(scanner.nextLine());

        produtoServico.cadastrar(nome, preco, peso);
        System.out.println("Produto cadastrado com sucesso!");

    }

}

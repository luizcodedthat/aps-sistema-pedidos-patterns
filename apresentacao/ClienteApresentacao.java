package apresentacao;

import java.util.Scanner;

import servico.ClienteServico;

public class ClienteApresentacao {
	
	private final ClienteServico clienteServico = new ClienteServico();
	Scanner scanner;
	
	ClienteApresentacao(Scanner scanner) {
		this.scanner = scanner;
	}
	
	void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        
        clienteServico.cadastrar(nome, cpf, email, telefone);
        System.out.println("Cliente cadastrado com sucesso!");
    }

}

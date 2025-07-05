package modelo;

public class Cliente {
	
	private String nome;
	private String CPF;
	private String email;
	private String telefone;

	public Cliente(String nome, String CPF, String email, String telefone) {
		this.nome = nome;
		this.CPF = CPF;
		this.email = email;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public String getCPF() {
		return CPF;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

}

package entities;

public class Client {
	
	private String nome;
	private String email;
	private String cellPhone;
	
	public Client() {
	}

	public Client(String nome, String email, String cellPhone) {
		this.nome = nome;
		this.email = email;
		this.cellPhone = cellPhone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + " - " + "email: " + email + " - " + "cellPhone: " + cellPhone;
	}
	
}

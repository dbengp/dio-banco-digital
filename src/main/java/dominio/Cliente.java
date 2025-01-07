package dominio;

public class Cliente {

	private String nome;
	private int score;

	public Cliente(String nome){
		this.nome = nome;
	}

	public Cliente(String nome, int score){
		this.nome = nome;
		this.score = score;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
package dominio;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private static Banco instancia;
	private String nome;
	private List<Conta> contas;
	private List<ICredito> ativos;

    private Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
		this.ativos = new ArrayList<>();
    }

	public static Banco getInstance(String nome) {
        if (instancia == null) {
            instancia = new Banco(nome);
        }
        return instancia;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public List<ICredito> getAtivos() {
		return ativos;
	}

	public void setAtivos(ICredito contrato) {
		ativos.add(contrato);
	}

}

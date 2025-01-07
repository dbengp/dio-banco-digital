import dominio.*;

import java.util.List;

public class BancoDigital {

	public static void main(String[] args) {

		Banco bancoDoPovo = Banco.getInstance("Banco do Povo");

		Cliente fulano = new Cliente("Fulano Daqui", 903);
		Cliente beltrano = new Cliente("Beltrano de Lá", 800);
		Cliente sicrano = new Cliente("Sicrano de Onde", 807);

		Conta contaCorrenteDofulano = new ContaCorrente(fulano);
		Conta contaPoupancaDofulano = new ContaPoupanca(fulano);

		Conta contaCorrenteDoBeltrano = new ContaCorrente(beltrano);
		Conta contaPoupancaDoBeltrano = new ContaCorrente(beltrano);

		Conta contaCorrenteDoSicrano = new ContaCorrente(sicrano);

		bancoDoPovo.setContas(List.of(contaCorrenteDofulano,
				contaPoupancaDofulano,
				contaCorrenteDoBeltrano,
				contaPoupancaDoBeltrano,
				contaCorrenteDoSicrano
		));

		bancoDoPovo.getContas().forEach(c -> c.depositar(3000));

		bancoDoPovo.getContas().get(2).sacar(100);
		bancoDoPovo.getContas().get(3).transferir(100, bancoDoPovo.getContas().get(1));

		ICredito creditoDoBom = new EmprestimoCDC();
		creditoDoBom.emprestar(
				bancoDoPovo.getContas().get(0).getCliente(),
				2000,
				12);

		EmprestimoCDC creditoNovoHorizonte = new EmprestimoCDC();
		creditoNovoHorizonte.setTaxaAdministrativa(0.039);
		creditoNovoHorizonte.emprestar(
				bancoDoPovo.getContas().get(0).getCliente(),
				3000,
				24
		);

		bancoDoPovo.setAtivos(creditoDoBom);
		bancoDoPovo.setAtivos(creditoNovoHorizonte);

		System.out.println("Fechamento do Dia - Resumo Financeiro: ");
		System.out.println("Ativos de crédito: ");
		for (ICredito credito : bancoDoPovo.getAtivos()) {
			System.out.println(credito.toString());
		}
		System.out.println("Movimentações por extrato: ");
		bancoDoPovo.getContas().forEach(Conta::imprimirExtrato);


    }

}

package dominio;

public class EmprestimoCDC implements ICredito{

    private Cliente cliente;
    private double montante;
    private static final double TAXA_MENSAL = 0.13;
    private double taxaAdministrativa = 0.023;
    private int numeroDeParcelasMensais;

    public EmprestimoCDC(){ }

    public double getTaxaAdministrativa() {
        return taxaAdministrativa;
    }

    public void setTaxaAdministrativa(double taxaAdministrativa) {
        this.taxaAdministrativa = taxaAdministrativa;
    }

    private boolean verificarScore(Cliente cliente){
        return cliente.getScore() >= 900;
    }

    public EmprestimoCDC emprestar(Cliente cliente, double valor, int numeroDeParcelasMensais){
        if(verificarScore(cliente)){
            this.cliente = cliente;
            this.numeroDeParcelasMensais = numeroDeParcelasMensais;
            montante = valor * Math.pow(1 + TAXA_MENSAL + getTaxaAdministrativa(), numeroDeParcelasMensais);
        }
        return this;
    }

    @Override
    public String toString() {
        return "Emprestimo \n{ Efetivado: Sim ," +
                "\n cliente : " + cliente.getNome() + ',' +
                "\n montante devido: " + String.format("%.2f", montante) + ',' +
                "\n numero de parcelas nensais: " + numeroDeParcelasMensais +
                '}';
    }
}
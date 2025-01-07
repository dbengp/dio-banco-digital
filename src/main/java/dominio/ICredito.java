package dominio;

public interface ICredito {

    EmprestimoCDC emprestar(Cliente cliente, double valor, int numeroDeParcelasMensais);
}

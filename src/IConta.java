
public interface IConta {

    void deposito(double quantidade);
    void saque(double quantidade);
    void transferir(double quantidade, Conta contaDestino);
    void imprimirExtrato();
}

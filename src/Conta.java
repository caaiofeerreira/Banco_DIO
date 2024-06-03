import lombok.Getter;
import java.util.ArrayList;
import java.util.Date;

public abstract class Conta implements IConta {

    @Getter protected int agencia;
    @Getter protected int numero;
    @Getter protected double saldo;
    @Getter protected ArrayList<Transacao> transacaoHistorico;
    protected Cliente cliente;
    private static int AGENCIA_PADRAO = 0;
    private static int SEQUENCIAL = 1;
    Banco banco = new Banco();


    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.numero = SEQUENCIAL++;
        this.agencia = AGENCIA_PADRAO;
        transacaoHistorico = new ArrayList<>();
    }

    @Override
    public void deposito(double quantidade) {
        saldo += quantidade;
        Transacao transacao = new Transacao(new Date(), "Depósito", quantidade);
        transacaoHistorico.add(transacao);
    }

    @Override
    public void saque(double quantidade) {
        if (saldo >= quantidade) {
            saldo -= quantidade;
            Transacao transacao = new Transacao(new Date(), "Saque", -quantidade);
            transacaoHistorico.add(transacao);
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    @Override
    public void transferir(double quantidade, Conta contaDestino) {
//        this.saque(quantidade);
//        contaDestino.deposito(quantidade);
        if (saldo >= quantidade) {
            saldo -= quantidade;
            Transacao transacao = new Transacao(new Date(), "Transferencia", -quantidade);
            transacaoHistorico.add(transacao);
            contaDestino.deposito(quantidade);
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    protected void imprimirInfoComuns() {
        System.out.println("\n*****     "+banco.getNome()+"     *****");
        System.out.println("\nTitular: " + cliente.getCliente());
        System.out.println("Agencia: " + agencia);
        System.out.println("Numero: " + numero);
        System.out.println("Saldo: " + saldo);
        System.out.println("\nHistórico de Transaçoes:");
        System.out.println(transacaoHistorico);
    }
}

import java.util.Scanner;

public class Banco_DIO {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Cliente cliente = new Cliente();
        ContaCorrente contaCorrente = new ContaCorrente(cliente);
        ContaPoupanca contaPoupanca = new ContaPoupanca(cliente);

        System.out.println("Nome do Titular:");
        cliente.setCliente(scanner.nextLine());

        contaCorrente.deposito(400);
        contaCorrente.transferir(200, contaPoupanca);

        contaCorrente.imprimirInfoComuns();
        contaPoupanca.imprimirInfoComuns();
    }
}
package programa;

import java.util.ArrayList;
import java.util.Scanner;

public class CaixaEletronico {

    static Scanner scan = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {
        String igual = "-".repeat(56);
        String igual2 = "-".repeat(19);
        System.out.println(igual);
        System.out.println(igual2 + "Bem vindo ao Banco" + igual2);
        System.out.println(igual);
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println(igual);
        System.out.println("|   Opção 1 - Criar conta   |");
        System.out.println("|   Opção 2 - Depositar     |");
        System.out.println("|   Opção 3 - Sacar         |");
        System.out.println("|   Opção 4 - Trasferir     |");
        System.out.println("|   Opção 5 - Listar        |");
        System.out.println("|   Opção 6 - Sair          |");

        int operacao = scan.nextInt();

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                System.out.println("Obrigado por usar nosso caixa");
                System.exit(0);

            default:
                System.out.println("Opção inválida");
                operacoes();
                break;
        }
    }

    public static void criarConta() {

        System.out.println("\nNome: ");
        String nome = scan.next();

        System.out.println("\nCPF: ");
        String cpf = scan.next();

        System.out.println("\nEmail: ");
        String email = scan.next();

        Pessoa pessoa = new Pessoa(nome, cpf, email);

        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);
        System.out.println("Sua conta foi criada com sucesso!");

        operacoes();

    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (!contasBancarias.isEmpty()) {
            for (Conta c : contasBancarias) {
                if (c.getNumeroConta() == numeroConta) {
                    conta = c;
                }
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("Número da conta: ");
        int numeroConta = scan.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual o valor que deseja depositar?");
            double valorDepositado = scan.nextDouble();
            conta.depositar(valorDepositado);
            System.out.println("Valor depositado com sucesso!");
        } else {
            System.out.println("Conta não encontrada! ");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("Número da conta que deseja sacar: ");
        int numeroConta = scan.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual o valor que deseja sacar?");
            double valorSaque = scan.nextDouble();
            conta.sacar(valorSaque);
            conta.contacedula(valorSaque);
            //System.out.println("Valor sacado com sucesso!");
        } else {
            System.out.println("Conta não encontrada");
        }
        operacoes();
    }

    public static void transferir() {
        System.out.println("Número da conta do remetente: ");
        int numeroContaRemetente = scan.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if (contaRemetente != null) {
            System.out.println("Número da conta do destinatário: ");
            int numeroContaDestinatario = scan.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if (contaDestinatario != null) {
                System.out.println("Valor da transferência: ");
                double valor = scan.nextDouble();

                contaRemetente.transferir(contaDestinatario, valor);
            }else{
                System.out.println("A conta para depósito não foi encontrada encontrada");
            }
        }
        operacoes();
    }
    public static void listarContas(){
        if(!contasBancarias.isEmpty()){
            for(Conta conta: contasBancarias){
                System.out.println(conta);
            }
        }else {
            System.out.println("Não há contas cadastradas!");
        }
        operacoes();

    }
}



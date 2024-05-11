package programa;

import Utilitarios.Utils;

public class Conta {

    private static  int contadorDeContas = 1;

    private int numeroConta;
    private Pessoa pessoa;
    private double saldo = 0.0;
    private int contadorSaques;

    public Conta(Pessoa pessoa){
        this.numeroConta = contadorDeContas;
        this.pessoa = pessoa;
        contadorDeContas += 1;
    }

    public int getNumeroConta(){
        return numeroConta;
    }
    public void setNumeroConta(int numeroConta){
        this.numeroConta = numeroConta;
    }
    public Pessoa getPessoa(){
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa){
        this.pessoa = pessoa;
    }
    public double getSaldo(){
        return saldo;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public String toString(){
        return  "\nNumero da conta: " + this.getNumeroConta() +
                "\nNome " + this.pessoa.getNome() +
                "\nCPF: " + this.pessoa.getCpf() +
                "\nEmail: " + this.pessoa.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.saldo) +
                "\n";
    }

    public void depositar(double valor){
        if(valor > 0){
            setSaldo(getSaldo() + valor);
            System.out.println("Seu depósito foi realizado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar o depósito!");
        }
    }

    public void sacar(double valor){
        if (valor > 0 && this.getSaldo() >= valor && contadorSaques < 5){
            setSaldo(getSaldo() - valor);
            contadorSaques++;
            System.out.println("Saque realizado com sucesso!");
        }else {
            System.out.println("Não foi possível realizar o saque!");
        }
    }

    public void transferir(Conta contaParaDeposito, double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo((getSaldo() - valor));

            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Tranferência realizada com sucesso!");
        }else{
            System.out.println("Não foi possível realizar a transferência!");
        }
    }

    public void contacedula(double valor){
        double total = valor;
        int cedula = 50;
        int totced = 0;
        while (true) {
            if (total >= cedula) {
                total -= cedula;
                totced += 1;
            } else {
                if (totced > 0){
                    System.out.println("Total de " + totced + " cedulas de R$ " + cedula);
                }
                if (cedula == 50){
                    cedula = 20;
                    totced = 0;
                }
                else if (cedula == 20){
                    cedula = 10;
                    totced = 0;
                }
                else if (cedula == 10){
                    cedula = 1;
                    totced = 0;
                }
                if ( total == 0){
                    break;
                }
            }
        }
    }

}

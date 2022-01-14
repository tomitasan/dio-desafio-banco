package com.dio;

public class Main {

    public static void main(String[] args) throws TransacaoException {

        Cliente cliente01 = new Cliente("João Carlos");
        Cliente cliente02 = new Cliente("Joana da Silva");

        Conta contaCorrente = new ContaCorrente(cliente01);
        Conta contaPoupanca = new ContaPoupanca(cliente02);

        contaCorrente.depositar(1000.0);
        contaCorrente.transferir(30000.0, contaPoupanca);

        contaCorrente.imprimirExtrato();
        contaPoupanca.imprimirExtrato();
    }
}

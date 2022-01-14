package com.dio;

import java.util.Random;

public abstract class Conta implements IConta{

    private static final String AGENCIA_PADRAO = "0001";
//    private static int SEQUENCIAL = 1;

    protected String agencia;
    protected String numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = gerarNumeroConta();
        this.cliente = cliente;
    }

    @Override
    public void sacar(Double valor){
        saldo -= valor;
    }

    @Override
    public void depositar(Double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(Double valor, Conta contaDestino) throws TransacaoException {
        if (valor > this.saldo) {
            throw new TransacaoException("Valor da transferência maior que o saldo disponível!");

        } else if (valor == 0) {
            throw new TransacaoException("Valor da transferência não pode ser 0!");

        } else if (valor < 0) {
            throw new TransacaoException("Valor da transferência não pode ser negativo!");
        }

        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfos() {
        System.out.println("Titular: " + this.cliente.getNome());
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Numero Conta: " + this.numero);
        System.out.println("Saldo: " + this.saldo);
    }

    protected String gerarNumeroConta() {
        Random gerador = new Random();
        String accountNumber = "";

        for (int i = 1; i < 6; i++) {
            accountNumber += gerador.nextInt(10);
        }

        accountNumber += "-";
        String digit = String.valueOf(Math.round(Math.random() * 9));
        accountNumber += digit;

        return accountNumber;
    }
}

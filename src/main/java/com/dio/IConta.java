package com.dio;

public interface IConta {

    void sacar(Double valor) throws TransacaoException;

    void depositar(Double valor);

    void transferir(Double valor, Conta contaDestino) throws TransacaoException;

    void imprimirExtrato();
}

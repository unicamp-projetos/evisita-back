package br.unicamp.mc851.evisita.config.exception;

public class AcompanhanteNotFoundException extends EVisitaException {
    public AcompanhanteNotFoundException(String cpf) {
        super("Acompanhante nao existe.", cpf, "O acompanhante deve possuir um cpf ja cadastrado no sistema.");
    }
}

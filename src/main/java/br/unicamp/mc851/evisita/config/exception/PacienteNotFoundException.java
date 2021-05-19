package br.unicamp.mc851.evisita.config.exception;

public class PacienteNotFoundException extends EVisitaException {
    public PacienteNotFoundException(String prontuario) {
        super("Paciente nao existe.", prontuario, "O prontuario deve ser valido.");
    }
}

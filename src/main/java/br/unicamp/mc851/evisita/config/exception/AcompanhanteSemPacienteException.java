package br.unicamp.mc851.evisita.config.exception;

public class AcompanhanteSemPacienteException extends EVisitaException {
    public AcompanhanteSemPacienteException(String cpf) {
        super("Acompanhante sem paciente cadastrado.",
                cpf,
                "Acompanhantes devem ser cadastrados com pacientes validos.");
    }
}

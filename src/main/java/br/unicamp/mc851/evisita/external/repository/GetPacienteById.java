package br.unicamp.mc851.evisita.external.repository;

import br.unicamp.mc851.evisita.config.exception.PacienteNotFoundException;
import br.unicamp.mc851.evisita.entity.Paciente;

public interface GetPacienteById {
    Paciente execute(String prontuario) throws PacienteNotFoundException;
}

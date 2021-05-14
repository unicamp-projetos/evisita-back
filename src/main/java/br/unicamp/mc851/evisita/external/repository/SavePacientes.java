package br.unicamp.mc851.evisita.external.repository;

import br.unicamp.mc851.evisita.entity.Paciente;

public interface SavePacientes {

    Paciente execute(Paciente paciente);

}

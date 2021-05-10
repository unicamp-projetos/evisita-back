package br.unicamp.mc851.evisita.external.repository;

import br.unicamp.mc851.evisita.entity.Paciente;

public interface SavePacientes {

    public Paciente execute(final Paciente paciente);

}

package br.unicamp.mc851.evisita.external.repository;

import br.unicamp.mc851.evisita.entity.Paciente;

import java.util.List;

public interface GetPacientes {
    public List<Paciente> execute();
}

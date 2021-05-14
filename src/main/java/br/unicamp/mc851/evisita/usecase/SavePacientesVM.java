package br.unicamp.mc851.evisita.usecase;

import br.unicamp.mc851.evisita.entity.Paciente;

public interface SavePacientesVM {

    Paciente execute(Paciente paciente);

}

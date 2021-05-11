package br.unicamp.mc851.evisita.usecase;

import br.unicamp.mc851.evisita.entity.Paciente;
import br.unicamp.mc851.evisita.viewmodel.PacienteVM;

public interface SavePacientesVM {

    public Paciente execute(Paciente paciente);

}

package br.unicamp.mc851.evisita.usecase;

import br.unicamp.mc851.evisita.viewmodel.PacienteVM;

import java.util.List;

public interface GetPacientesVM {
    List<PacienteVM> execute();
}

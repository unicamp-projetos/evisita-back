package br.unicamp.mc851.evisita.usecase.impl;

import br.unicamp.mc851.evisita.entity.Paciente;
import br.unicamp.mc851.evisita.external.repository.SavePacientes;
import br.unicamp.mc851.evisita.usecase.SavePacientesVM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SavePacientesVMImpl implements SavePacientesVM {

    private final SavePacientes savePacientes;

    public Paciente execute(Paciente paciente) {
        return savePacientes.execute(paciente);
    }
}

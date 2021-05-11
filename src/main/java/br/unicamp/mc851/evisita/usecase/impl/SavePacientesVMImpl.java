package br.unicamp.mc851.evisita.usecase.impl;
import br.unicamp.mc851.evisita.entity.Paciente;
import br.unicamp.mc851.evisita.external.repository.SavePacientes;
import br.unicamp.mc851.evisita.usecase.SavePacientesVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavePacientesVMImpl implements SavePacientesVM {

    @Autowired
    SavePacientes savePacientes;

    public Paciente execute(Paciente paciente) {
        return savePacientes.execute(paciente);
    }
}

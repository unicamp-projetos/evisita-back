package br.unicamp.mc851.evisita.external.repository.impl;

import br.unicamp.mc851.evisita.entity.Paciente;
import br.unicamp.mc851.evisita.external.repository.SavePacientes;
import br.unicamp.mc851.evisita.external.repository.database.PacienteRepository;
import br.unicamp.mc851.evisita.external.repository.entity.PacienteModel;
import br.unicamp.mc851.evisita.external.repository.entity.adapter.PacienteModelAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SavePacientesImpl implements SavePacientes {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente execute(Paciente paciente) {
        PacienteModel model = PacienteModelAdapter.entityToModel(paciente);
        return PacienteModelAdapter.modelToEntity(pacienteRepository.save(model));
    }

}

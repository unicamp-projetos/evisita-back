package br.unicamp.mc851.evisita.external.repository.impl;

import br.unicamp.mc851.evisita.entity.Paciente;
import br.unicamp.mc851.evisita.external.repository.GetPacientes;
import br.unicamp.mc851.evisita.external.repository.database.PacienteRepository;
import br.unicamp.mc851.evisita.external.repository.entity.PacienteModel;
import br.unicamp.mc851.evisita.external.repository.entity.adapter.PacienteModelAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetPacienteImpl implements GetPacientes {

    private PacienteRepository repository;

    @Autowired
    public GetPacienteImpl(PacienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Paciente> execute() {
        List<PacienteModel> pacienteModels = repository.findAll();
        List<Paciente> pacientes = new ArrayList<>();
        pacienteModels.forEach(model ->
                        pacientes.add(PacienteModelAdapter.modelToEntity(model)));
        return pacientes;
    }
}

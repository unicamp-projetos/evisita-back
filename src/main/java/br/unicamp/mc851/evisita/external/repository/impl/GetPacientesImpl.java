package br.unicamp.mc851.evisita.external.repository.impl;

import br.unicamp.mc851.evisita.entity.Paciente;
import br.unicamp.mc851.evisita.external.repository.GetPacientes;
import br.unicamp.mc851.evisita.external.repository.database.PacienteRepository;
import br.unicamp.mc851.evisita.external.repository.entity.adapter.PacienteModelAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// TODO: banco não retorna pacientes

@Service
@RequiredArgsConstructor
public class GetPacientesImpl implements GetPacientes {

    private final PacienteRepository repository;

    @Override
    public List<Paciente> execute() {
        var pacienteModels = repository.findAll();
        System.out.println(pacienteModels); // aqui "testa" se pelo menos o repository conseguiu recuperar os dados
        return pacienteModels.stream()
                .map(PacienteModelAdapter::modelToEntity)
                .collect(Collectors.toList());
    }
}

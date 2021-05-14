package br.unicamp.mc851.evisita.external.repository.entity.adapter;

import br.unicamp.mc851.evisita.entity.Acompanhante;
import br.unicamp.mc851.evisita.entity.Paciente;
import br.unicamp.mc851.evisita.external.repository.entity.AcompanhanteModel;
import br.unicamp.mc851.evisita.external.repository.entity.PacienteModel;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AcompanhanteModelAdapter {

    private AcompanhanteModelAdapter() {}

    public static Acompanhante modelToEntity(@NonNull AcompanhanteModel acompanhanteModel) {
        return Acompanhante.builder()
                .cpf(acompanhanteModel.getCpf())
                .nome(acompanhanteModel.getNome())
                .rg(acompanhanteModel.getRg())
                .pacientes(getPacientesList(acompanhanteModel.getPacientes()))
                .build();
    }

    private static List<Paciente> getPacientesList(@NonNull Set<PacienteModel> pacienteModels) {
        if (pacienteModels.isEmpty()) {
            return new ArrayList<>();
        }
        return pacienteModels.stream()
                .map(PacienteModelAdapter::modelToEntity)
                .collect(Collectors.toList());
    }

    public static AcompanhanteModel entityToModel(@NonNull Acompanhante acompanhante) {
        return AcompanhanteModel.builder()
                .cpf(acompanhante.getCpf())
                .dataAtualizacao(LocalDateTime.now())
                .dataCriacao(LocalDateTime.now())
                .nome(acompanhante.getNome())
                .rg(acompanhante.getRg())
                .pacientes(getPacientesSet(acompanhante.getPacientes()))
                .build();
    }

    private static Set<PacienteModel> getPacientesSet(@NonNull List<Paciente> pacientes) {
        if (pacientes.isEmpty()) {
            return new HashSet<>();
        }
        return pacientes.stream()
                .map(PacienteModelAdapter::entityToModel)
                .collect(Collectors.toSet());

    }

    public static List<Acompanhante> modelListToEntityList(@NonNull List<AcompanhanteModel> acompanhanteModels) {
        if (acompanhanteModels.isEmpty()) {
            return new ArrayList<>();
        }
        return acompanhanteModels.stream()
                .map(AcompanhanteModelAdapter::modelToEntity)
                .collect(Collectors.toList());
    }
}

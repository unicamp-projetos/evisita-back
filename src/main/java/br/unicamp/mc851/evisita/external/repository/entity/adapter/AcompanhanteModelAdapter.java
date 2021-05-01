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

public class AcompanhanteModelAdapter {

    public static Acompanhante modelToEntity(@NonNull AcompanhanteModel acompanhanteModel) {
        return Acompanhante.builder()
                .cpf(acompanhanteModel.getCpf())
                .nome(acompanhanteModel.getNome())
                .rg(acompanhanteModel.getRg())
                .pacientes(getPacientesList(acompanhanteModel.getPacientes()))
                .build();
    }

    private static List<Paciente> getPacientesList(Set<PacienteModel> pacienteModels) {
        List<Paciente> pacientes = new ArrayList<>();
        pacienteModels.stream()
                .forEach(model ->
                        pacientes.add(PacienteModelAdapter.modelToEntity(model)));
        return pacientes;
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

    private static Set<PacienteModel> getPacientesSet(List<Paciente> pacientes) {
        Set<PacienteModel> pacienteModels = new HashSet<>();
        pacientes.stream()
                .forEach(entity ->
                        pacienteModels.add(PacienteModelAdapter.entityToModel(entity)));
        return pacienteModels;
    }
}

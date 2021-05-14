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

public class PacienteModelAdapter {

    private PacienteModelAdapter() {}

    public static Paciente modelToEntity(@NonNull PacienteModel pacienteModel) {
        return Paciente.builder()
                .acompanhantes(getAcompanhantesList(pacienteModel.getAcompanhantes()))
                .cpf(pacienteModel.getCpf())
                .cadastroSus(pacienteModel.getCadastroSus())
                .medico(pacienteModel.getMedico())
                .nome(pacienteModel.getNome())
                .nomeMae(pacienteModel.getNomeMae())
                .prontuario(pacienteModel.getProntuario())
                .rg(pacienteModel.getRg())
                .quarto(pacienteModel.getQuarto())
                .build();
    }

    private static List<Acompanhante> getAcompanhantesList(@NonNull Set<AcompanhanteModel> acompanhanteModels) {
        if (acompanhanteModels.isEmpty()) {
            return new ArrayList<>();
        }
        return acompanhanteModels.stream()
                .map(AcompanhanteModelAdapter::modelToEntity)
                .collect(Collectors.toList());
    }

    public static PacienteModel entityToModel(@NonNull Paciente paciente) {
        return PacienteModel.builder()
                .acompanhantes(getAcompanhantesSet(paciente.getAcompanhantes()))
                .cpf(paciente.getCpf())
                .cadastroSus(paciente.getCadastroSus())
                .dataAtualizacao(LocalDateTime.now())
                .dataCriacao(LocalDateTime.now())
                .nome(paciente.getNome())
                .medico(paciente.getMedico())
                .nomeMae(paciente.getNomeMae())
                .rg(paciente.getRg())
                .prontuario(paciente.getProntuario())
                .quarto(paciente.getQuarto())
                .build();
    }

    private static Set<AcompanhanteModel> getAcompanhantesSet(@NonNull List<Acompanhante> acompanhantes) {
        if (acompanhantes.isEmpty()) {
            return new HashSet<>();
        }
        return acompanhantes.stream()
                .map(AcompanhanteModelAdapter::entityToModel)
                .collect(Collectors.toSet());
    }

    public static List<Paciente> modelListToEntityList(@NonNull List<PacienteModel> pacienteModels) {
        if (pacienteModels.isEmpty()) {
            return new ArrayList<>();
        }
        return pacienteModels.stream()
                .map(PacienteModelAdapter::modelToEntity)
                .collect(Collectors.toList());
    }
}

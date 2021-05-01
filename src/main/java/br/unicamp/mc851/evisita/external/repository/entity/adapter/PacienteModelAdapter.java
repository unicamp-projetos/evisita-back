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

public class PacienteModelAdapter {
    public static Paciente modelToEntity(@NonNull PacienteModel pacienteModel) {
        return Paciente.builder()
                .acompanhantes(getAcompanhantesList(pacienteModel))
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

    private static List<Acompanhante> getAcompanhantesList(@NonNull PacienteModel pacienteModel) {
        List<Acompanhante> acompanhantes = new ArrayList<>();
        pacienteModel.getAcompanhantes()
                .stream()
                .forEach(model ->
                    acompanhantes.add(AcompanhanteModelAdapter.modelToEntity(model)));
        return acompanhantes;
    }

    public static PacienteModel entityToModel(@NonNull Paciente paciente) {
        return PacienteModel.builder()
                .acompanhantes(getAcompanhantesSet(paciente))
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

    private static Set<AcompanhanteModel> getAcompanhantesSet(@NonNull Paciente paciente) {
        Set<AcompanhanteModel> acompanhantes = new HashSet<>();
        paciente.getAcompanhantes()
                .stream()
                .forEach(entity ->
                        acompanhantes.add(AcompanhanteModelAdapter.entityToModel(entity)));
        return acompanhantes;
    }
}

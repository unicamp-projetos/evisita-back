package br.unicamp.mc851.evisita.external.repository.entity.adapter;

import br.unicamp.mc851.evisita.entity.Paciente;
import br.unicamp.mc851.evisita.external.repository.entity.PacienteModel;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class PacienteModelAdapter {

    private PacienteModelAdapter() {}

    public static Paciente modelToEntity(@NonNull PacienteModel pacienteModel) {
        return Paciente.builder()
                .acompanhantes(pacienteModel.getAcompanhantes().stream()
                    .map(AcompanhanteModelAdapter::modelToEntity)
                    .collect(Collectors.toList())
                )
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

    public static PacienteModel entityToModel(@NonNull Paciente paciente) {
        return PacienteModel.builder()
                .acompanhantes(paciente.getAcompanhantes().stream()
                    .map(AcompanhanteModelAdapter::entityToModel)
                    .collect(Collectors.toSet())
                )
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
}

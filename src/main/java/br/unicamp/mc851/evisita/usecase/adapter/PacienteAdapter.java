package br.unicamp.mc851.evisita.usecase.adapter;

import br.unicamp.mc851.evisita.endpoint.dto.PacienteRequest;
import br.unicamp.mc851.evisita.endpoint.dto.PacienteResponse;
import br.unicamp.mc851.evisita.entity.Paciente;

import java.util.stream.Collectors;

public class PacienteAdapter {
    public static Paciente requestToEntity(PacienteRequest pacienteRequest) {
        return Paciente.builder()
                .rg(pacienteRequest.getRg())
                .quarto(pacienteRequest.getQuarto())
                .prontuario(pacienteRequest.getProntuario())
                .nome(pacienteRequest.getNome())
                .nomeMae(pacienteRequest.getNomeMae())
                .cpf(pacienteRequest.getCpf())
                .medico(pacienteRequest.getMedico())
                .cadastroSus(pacienteRequest.getCadastroSus())
                .cpf(pacienteRequest.getCpf())
                .acompanhantes(pacienteRequest.getAcompanhantes().stream()
                    .map(AcompanhanteAdapter::requestToEntity)
                    .collect(Collectors.toList()))
                .build();
    }

    public static PacienteResponse entityToResponse(Paciente paciente) {
        return PacienteResponse.builder()
                .cpf(paciente.getCpf())
                .cadastroSus(paciente.getCadastroSus())
                .medico(paciente.getMedico())
                .nomeMae(paciente.getNomeMae())
                .nome(paciente.getNome())
                .prontuario(paciente.getProntuario())
                .quarto(paciente.getQuarto())
                .rg(paciente.getRg())
                .build();
    }
}

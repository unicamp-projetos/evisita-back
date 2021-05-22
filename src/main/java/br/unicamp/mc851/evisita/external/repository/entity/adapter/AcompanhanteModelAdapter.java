package br.unicamp.mc851.evisita.external.repository.entity.adapter;

import br.unicamp.mc851.evisita.entity.Acompanhante;
import br.unicamp.mc851.evisita.external.repository.entity.AcompanhanteModel;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class AcompanhanteModelAdapter {

    private AcompanhanteModelAdapter() {}

    public static Acompanhante modelToEntity(@NonNull AcompanhanteModel acompanhanteModel) {
        return Acompanhante.builder()
                .cpf(acompanhanteModel.getCpf())
                .nome(acompanhanteModel.getNome())
                .rg(acompanhanteModel.getRg())
                .build();
    }

    public static AcompanhanteModel entityToModel(@NonNull Acompanhante acompanhante) {
        return AcompanhanteModel.builder()
                .cpf(acompanhante.getCpf())
                .dataAtualizacao(LocalDateTime.now())
                .dataCriacao(LocalDateTime.now())
                .nome(acompanhante.getNome())
                .rg(acompanhante.getRg())
                .pacientes(acompanhante.getPacientes().stream()
                    .map(PacienteModelAdapter::entityToModel)
                    .collect(Collectors.toSet())
                )
                .build();
    }
}

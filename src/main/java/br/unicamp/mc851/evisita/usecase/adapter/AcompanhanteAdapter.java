package br.unicamp.mc851.evisita.usecase.adapter;

import br.unicamp.mc851.evisita.endpoint.dto.AcompanhanteRequest;
import br.unicamp.mc851.evisita.endpoint.dto.AcompanhanteResponse;
import br.unicamp.mc851.evisita.entity.Acompanhante;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class AcompanhanteAdapter {
    public static Acompanhante requestToEntity(AcompanhanteRequest request) {
        return Acompanhante.builder()
                .rg(request.getCpf())
                .nome(request.getNome())
                .cpf(request.getCpf())
                .pacientes(new ArrayList<>())
                .build();
    }

    public static AcompanhanteResponse entityToResponse(Acompanhante acompanhante) {
        return AcompanhanteResponse.builder()
                .rg(acompanhante.getRg())
                .cpf(acompanhante.getCpf())
                .nome(acompanhante.getNome())
                .build();
    }
}

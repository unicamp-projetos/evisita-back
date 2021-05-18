package br.unicamp.mc851.evisita.usecase;

import br.unicamp.mc851.evisita.endpoint.dto.AcompanhanteResponse;
import br.unicamp.mc851.evisita.endpoint.dto.CreateAcompanhanteRequest;
import br.unicamp.mc851.evisita.entity.Acompanhante;

public interface SaveAcompanhante {
    AcompanhanteResponse execute(CreateAcompanhanteRequest request);
}

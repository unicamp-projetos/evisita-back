package br.unicamp.mc851.evisita.usecase.impl;

import br.unicamp.mc851.evisita.config.exception.AcompanhanteNotFoundException;
import br.unicamp.mc851.evisita.endpoint.dto.AcompanhanteResponse;
import br.unicamp.mc851.evisita.entity.Acompanhante;
import br.unicamp.mc851.evisita.external.repository.GetAcompanhanteById;
import br.unicamp.mc851.evisita.usecase.GetAcompanhanteByIdResponse;
import br.unicamp.mc851.evisita.usecase.adapter.AcompanhanteAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetAcompanhanteByIdResponseImpl implements GetAcompanhanteByIdResponse {

    private final GetAcompanhanteById getAcompanhanteById;
    @Override
    public AcompanhanteResponse execute(String cpf) throws AcompanhanteNotFoundException {
        var acompanhante = getAcompanhanteById.execute(cpf);
        return AcompanhanteAdapter.entityToResponse(acompanhante);
    }
}

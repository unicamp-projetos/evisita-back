package br.unicamp.mc851.evisita.external.repository.impl;

import br.unicamp.mc851.evisita.config.exception.AcompanhanteNotFoundException;
import br.unicamp.mc851.evisita.entity.Acompanhante;
import br.unicamp.mc851.evisita.external.repository.GetAcompanhanteById;
import br.unicamp.mc851.evisita.external.repository.database.AcompanhanteRepository;
import br.unicamp.mc851.evisita.external.repository.entity.adapter.AcompanhanteModelAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAcompanhanteByIdImpl implements GetAcompanhanteById {

    private final AcompanhanteRepository repository;

    @Override
    public Acompanhante execute(String cpf) throws AcompanhanteNotFoundException {
        var optional = repository.findById(cpf);
        if (optional.isPresent()) {
            return AcompanhanteModelAdapter.modelToEntity(optional.get());
        }
        throw new AcompanhanteNotFoundException(cpf);
    }
}

package br.unicamp.mc851.evisita.external.repository.impl;

import br.unicamp.mc851.evisita.entity.Acompanhante;
import br.unicamp.mc851.evisita.external.repository.SaveAcompanhante;
import br.unicamp.mc851.evisita.external.repository.database.AcompanhanteRepository;
import br.unicamp.mc851.evisita.external.repository.entity.adapter.AcompanhanteModelAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveAcompanhanteImpl implements SaveAcompanhante {

    private final AcompanhanteRepository repository;
    @Override
    public Acompanhante execute(Acompanhante acompanhante) {
        var model = repository.save(AcompanhanteModelAdapter.entityToModel(acompanhante));
        return AcompanhanteModelAdapter.modelToEntity(model);
    }
}

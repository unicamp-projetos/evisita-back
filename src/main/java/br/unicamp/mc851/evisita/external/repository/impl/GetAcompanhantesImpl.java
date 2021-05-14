package br.unicamp.mc851.evisita.external.repository.impl;

import br.unicamp.mc851.evisita.entity.Acompanhante;
import br.unicamp.mc851.evisita.external.repository.GetAcompanhantes;
import br.unicamp.mc851.evisita.external.repository.database.AcompanhanteRepository;
import br.unicamp.mc851.evisita.external.repository.entity.adapter.AcompanhanteModelAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAcompanhantesImpl implements GetAcompanhantes {

    private final AcompanhanteRepository repository;

    @Override
    public List<Acompanhante> execute() {
        return AcompanhanteModelAdapter.modelListToEntityList(repository.findAll());
    }
}

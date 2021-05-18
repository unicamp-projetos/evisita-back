package br.unicamp.mc851.evisita.external.repository.impl;

import br.unicamp.mc851.evisita.entity.Acompanhante;
import br.unicamp.mc851.evisita.external.repository.GetAcompanhantes;
import br.unicamp.mc851.evisita.external.repository.database.AcompanhanteRepository;
import br.unicamp.mc851.evisita.external.repository.entity.adapter.AcompanhanteModelAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAcompanhantesImpl implements GetAcompanhantes {

    private final AcompanhanteRepository repository;

    @Override
    public List<Acompanhante> execute() {
        var acompanhanteModelList = repository.findAll();
        return acompanhanteModelList.stream()
                .map(AcompanhanteModelAdapter::modelToEntity)
                .collect(Collectors.toList());
    }
}

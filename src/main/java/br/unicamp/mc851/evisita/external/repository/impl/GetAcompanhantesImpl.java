package br.unicamp.mc851.evisita.external.repository.impl;

import br.unicamp.mc851.evisita.entity.Acompanhante;
import br.unicamp.mc851.evisita.external.repository.GetAcompanhantes;
import br.unicamp.mc851.evisita.external.repository.database.AcompanhanteRepository;
import br.unicamp.mc851.evisita.external.repository.entity.AcompanhanteModel;
import br.unicamp.mc851.evisita.external.repository.entity.adapter.AcompanhanteModelAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAcompanhantesImpl implements GetAcompanhantes {

    private AcompanhanteRepository repository;

    @Autowired
    public GetAcompanhantesImpl(AcompanhanteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Acompanhante> execute() {
        List<AcompanhanteModel> acompanhanteModels = repository.findAll();
        List<Acompanhante> acompanhantes = new ArrayList<>();
        acompanhanteModels.forEach(model ->
                        acompanhantes.add(AcompanhanteModelAdapter.modelToEntity(model)));
        return acompanhantes;
    }
}

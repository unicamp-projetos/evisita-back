package br.unicamp.mc851.evisita.external.repository;

import br.unicamp.mc851.evisita.entity.Acompanhante;
import br.unicamp.mc851.evisita.external.repository.entity.AcompanhanteModel;

import java.util.List;

public interface GetAcompanhantes {
    public List<Acompanhante> execute();
}

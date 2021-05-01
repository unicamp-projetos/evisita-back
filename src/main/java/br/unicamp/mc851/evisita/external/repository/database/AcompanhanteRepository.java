package br.unicamp.mc851.evisita.external.repository.database;

import br.unicamp.mc851.evisita.external.repository.entity.AcompanhanteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcompanhanteRepository extends JpaRepository<AcompanhanteModel, String> {
}

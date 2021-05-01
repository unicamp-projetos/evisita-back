package br.unicamp.mc851.evisita.external.repository.database;

import br.unicamp.mc851.evisita.external.repository.entity.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteModel, String> {
}

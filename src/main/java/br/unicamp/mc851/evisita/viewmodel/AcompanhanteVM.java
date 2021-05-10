package br.unicamp.mc851.evisita.viewmodel;

import br.unicamp.mc851.evisita.entity.Paciente;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class AcompanhanteVM {
    private String cpf;
    private String rg;
    private String nome;
    List<PacienteVM> pacientes;
}

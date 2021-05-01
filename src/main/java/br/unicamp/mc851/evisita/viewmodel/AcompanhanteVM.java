package br.unicamp.mc851.evisita.viewmodel;

import br.unicamp.mc851.evisita.entity.Paciente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AcompanhanteVM {
    private String cpf;
    private String rg;
    private String nome;
    List<PacienteVM> pacientes;
}

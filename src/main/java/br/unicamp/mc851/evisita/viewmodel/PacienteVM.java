package br.unicamp.mc851.evisita.viewmodel;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PacienteVM {
    private String prontuario;
    private String nome;
    private String rg;
    private String cpf;
    private String nomeMae;
    private String cadastroSus;
    private String medico;
    private String quarto;
    List<AcompanhanteVM> acompanhantes;
}

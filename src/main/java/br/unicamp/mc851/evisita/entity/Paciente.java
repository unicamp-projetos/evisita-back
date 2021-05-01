package br.unicamp.mc851.evisita.entity;

import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = {"prontuario", "cpf"})
@Builder
public class Paciente {
    private String prontuario;
    private String nome;
    private String rg;
    private String cpf;
    private String nomeMae;
    private String cadastroSus;
    private String medico;
    private String quarto;
    List<Acompanhante> acompanhantes;
}

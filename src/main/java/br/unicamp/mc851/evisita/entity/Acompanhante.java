package br.unicamp.mc851.evisita.entity;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"cpf"})
@Builder
public class Acompanhante {

    private String cpf;
    private String rg;
    private String nome;
    List<Paciente> pacientes;
}

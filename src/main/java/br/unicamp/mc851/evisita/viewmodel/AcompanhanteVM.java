package br.unicamp.mc851.evisita.viewmodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcompanhanteVM {
    private String cpf;
    private String rg;
    private String nome;
}

package br.unicamp.mc851.evisita.endpoint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AcompanhanteRequest {
    private String cpf;
    private String rg;
    private String nome;
}

package br.unicamp.mc851.evisita.endpoint.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AcompanhanteRequest {
    @NonNull
    private String cpf;
    private String rg;
    private String nome;
}

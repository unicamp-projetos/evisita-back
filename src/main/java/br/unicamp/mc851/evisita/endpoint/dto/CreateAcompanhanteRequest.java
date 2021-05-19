package br.unicamp.mc851.evisita.endpoint.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.NonNull;

import java.util.List;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAcompanhanteRequest extends AcompanhanteRequest {
    @NonNull
    private List<String> prontuarios;
}

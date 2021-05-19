package br.unicamp.mc851.evisita.endpoint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PacienteRequest {
    @NonNull
    private String prontuario;
    private String nome;
    private String rg;
    private String cpf;
    private String nomeMae;
    private String cadastroSus;
    private String medico;
    private String quarto;
    private List<AcompanhanteRequest> acompanhantes;
}

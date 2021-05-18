package br.unicamp.mc851.evisita.builder;

import br.unicamp.mc851.evisita.endpoint.dto.PacienteRequest;

import java.util.Arrays;
import java.util.List;

public class PacienteRequestBuilder {

    private static PacienteRequest buildPacienteVMMock() {
        return PacienteRequest.builder()
                .cpf("12345678910")
                .cadastroSus("123456789")
                .nome("Nome")
                .medico("Dr Medico")
                .nomeMae("Nome mae")
                .prontuario("123456789")
                .quarto("123456789")
                .rg("123456789")
                .build();
    }

    public static List<PacienteRequest> buildPacientesVMMock() {
        return Arrays.asList(buildPacienteVMMock());
    }
}

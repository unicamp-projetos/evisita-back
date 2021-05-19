package br.unicamp.mc851.evisita.endpoint;

import br.unicamp.mc851.evisita.builder.PacienteRequestBuilder;
import br.unicamp.mc851.evisita.endpoint.dto.PacienteRequest;
import br.unicamp.mc851.evisita.endpoint.dto.PacienteResponse;
import br.unicamp.mc851.evisita.usecase.GetPacienteByIdResponse;
import br.unicamp.mc851.evisita.usecase.GetPacientesResponse;
import br.unicamp.mc851.evisita.usecase.SavePacientesRequest;
import br.unicamp.mc851.evisita.usecase.adapter.PacienteAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PacientesControllerTest {

    private GetPacientesResponse getPacientesResponse;
    private SavePacientesRequest savePacientesRequest;
    private GetPacienteByIdResponse getPacienteByIdResponse;
    private PacientesController controller;

    @BeforeEach
    public void setUp() {
        getPacientesResponse = mock(GetPacientesResponse.class);
        savePacientesRequest = mock(SavePacientesRequest.class);
        getPacienteByIdResponse = mock(GetPacienteByIdResponse.class);
        controller = new PacientesController(savePacientesRequest,
                getPacientesResponse, getPacienteByIdResponse);
    }

    @Test
    void shouldReturnPacientesVMSWithOkStatusWhenCalledWithAtLeastOnePacienteInDatabase() {
        var pacienteRequests = PacienteRequestBuilder.buildPacientesVMMock();
        var pacienteResponseList = pacienteRequests.stream()
                .map(PacienteAdapter::requestToEntity)
                .collect(Collectors.toList())
                .stream()
                .map(PacienteAdapter::entityToResponse)
                .collect(Collectors.toList());
        when(getPacientesResponse.execute()).thenReturn(pacienteResponseList);
        var responseEntity = controller.getPacientes();

        verify(getPacientesResponse, times(1)).execute();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        var body = (List<PacienteRequest>) responseEntity.getBody();
        assertEquals(1, body.size());
        assertEquals(pacienteRequests, body);

    }

    @Test
    void shouldReturNoContentHttpStatusWhenCalledWithoutAnyPacientesInDatabase() {
        when(getPacientesResponse.execute()).thenReturn(new ArrayList<PacienteResponse>());
        var responseEntity = controller.getPacientes();

        verify(getPacientesResponse, times(1)).execute();
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }
}

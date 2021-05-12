package br.unicamp.mc851.evisita.endpoint;

import br.unicamp.mc851.evisita.builder.PacienteVMBuilder;
import br.unicamp.mc851.evisita.usecase.GetPacientesVM;
import br.unicamp.mc851.evisita.usecase.SavePacientesVM;
import br.unicamp.mc851.evisita.viewmodel.PacienteVM;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PacientesControllerTest {

    private GetPacientesVM getPacientesVM;
    private SavePacientesVM savePacientesVM;
    private PacientesController controller;

    @BeforeEach
    public void setUp() {
        getPacientesVM = mock(GetPacientesVM.class);
        savePacientesVM = mock(SavePacientesVM.class);
        controller = new PacientesController(savePacientesVM, getPacientesVM);
    }

    @Test
    public void shouldReturnPacientesVMSWithOkStatusWhenCalledWithAtLeastOnePacienteInDatabase() {
        var pacienteVMS = PacienteVMBuilder.buildPacientesVMMock();
        when(getPacientesVM.execute()).thenReturn(pacienteVMS);
        var responseEntity = controller.getPacientes();

        verify(getPacientesVM, times(1)).execute();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        var body = (List<PacienteVM>) responseEntity.getBody();
        assertEquals(1, body.size());
        assertEquals(pacienteVMS, body);

    }

    @Test
    public void shouldReturNoContentHttpStatusWhenCalledWithoutAnyPacientesInDatabase() {
        when(getPacientesVM.execute()).thenReturn(new ArrayList<PacienteVM>());
        var responseEntity = controller.getPacientes();

        verify(getPacientesVM, times(1)).execute();
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());

    }
}

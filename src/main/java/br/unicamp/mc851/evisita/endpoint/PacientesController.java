package br.unicamp.mc851.evisita.endpoint;

import br.unicamp.mc851.evisita.config.exception.EVisitaException;
import br.unicamp.mc851.evisita.endpoint.dto.PacienteRequest;
import br.unicamp.mc851.evisita.endpoint.dto.PacienteResponse;
import br.unicamp.mc851.evisita.usecase.GetPacienteByIdResponse;
import br.unicamp.mc851.evisita.usecase.GetPacientesResponse;
import br.unicamp.mc851.evisita.usecase.SavePacientesRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "pacientes/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PacientesController {

    private final SavePacientesRequest savePacientesRequest;
    private final GetPacientesResponse getPacientesResponse;
    private final GetPacienteByIdResponse getPacienteByIdResponse;

    @GetMapping("/pacientes")
    public ResponseEntity<Object> getPacientes() {
        List<PacienteResponse> pacienteVMS = getPacientesResponse.execute();
        if (pacienteVMS.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(pacienteVMS);
        }
    }

    @PostMapping(value = "/paciente",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createPaciente(
            @RequestBody @Validated PacienteRequest pacienteRequest) {

        var pacienteResponse = savePacientesRequest.execute(pacienteRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteResponse);
    }

    @GetMapping("/paciente/{prontuario}")
    public ResponseEntity<Object> getPacienteById(@PathVariable String prontuario)
        throws EVisitaException {
        return ResponseEntity.ok(getPacienteByIdResponse.execute(prontuario));
    }

}


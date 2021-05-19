package br.unicamp.mc851.evisita.endpoint;

import br.unicamp.mc851.evisita.config.exception.AcompanhanteNotFoundException;
import br.unicamp.mc851.evisita.config.exception.AcompanhanteSemPacienteException;
import br.unicamp.mc851.evisita.config.exception.EVisitaException;
import br.unicamp.mc851.evisita.config.exception.PacienteNotFoundException;
import br.unicamp.mc851.evisita.endpoint.dto.CreateAcompanhanteRequest;
import br.unicamp.mc851.evisita.usecase.GetAcompanhanteByIdResponse;
import br.unicamp.mc851.evisita.usecase.SaveAcompanhanteRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "acompanhantes/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AcompanhanteController {

    private final SaveAcompanhanteRequest saveAcompanhanteRequest;
    private final GetAcompanhanteByIdResponse getAcompanhanteByIdResponse;

    @PostMapping(value = "/acompanhante", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createAcompanhante(@RequestBody @Validated CreateAcompanhanteRequest request)
        throws EVisitaException{
        return ResponseEntity.status(HttpStatus.CREATED).body(saveAcompanhanteRequest.execute(request));
    }

    @GetMapping(value = "/acompanhante/{cpf}")
    public ResponseEntity<Object> getAcompanhanteById(@PathVariable String cpf)
        throws EVisitaException {
        return ResponseEntity.ok(getAcompanhanteByIdResponse.execute(cpf));
    }
}

package br.unicamp.mc851.evisita.endpoint;

import br.unicamp.mc851.evisita.endpoint.dto.CreateAcompanhanteRequest;
import br.unicamp.mc851.evisita.usecase.SaveAcompanhante;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "acompanhantes", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AcompanhanteController {

    private final SaveAcompanhante saveAcompanhante;

    @PostMapping(value = "/acompanhante", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createAcompanhante(@RequestBody CreateAcompanhanteRequest request) {
        return ResponseEntity.ok(saveAcompanhante.execute(request));
    }
}

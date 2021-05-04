package br.unicamp.mc851.evisita.endpoint;

import br.unicamp.mc851.evisita.usecase.GetPacientesVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {

    @Autowired
    GetPacientesVM pacientesVM;

    @GetMapping
    public ResponseEntity<Object> getPacientes() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

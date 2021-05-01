package br.unicamp.mc851.evisita.endpoint;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PacientesController {
    @GetMapping("/pacientes")
    public ResponseEntity<Object> getPacientes() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

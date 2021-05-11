package br.unicamp.mc851.evisita.endpoint;

import br.unicamp.mc851.evisita.usecase.GetPacientesVM;
import br.unicamp.mc851.evisita.usecase.SavePacientesVM;
import br.unicamp.mc851.evisita.viewmodel.PacienteVM;
import br.unicamp.mc851.evisita.viewmodel.adapter.PacienteVMAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pacientes",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class PacientesController {

    private SavePacientesVM savePacientesVM;
    private GetPacientesVM getPacientesVM;

    @Autowired
    public PacientesController(
            SavePacientesVM savePacientesVM,
            GetPacientesVM getPacientesVM
    ) {
        this.getPacientesVM = getPacientesVM;
        this.savePacientesVM = savePacientesVM;
    }

    @GetMapping
    public ResponseEntity<Object> getPacientes() {
        List<PacienteVM> pacienteVMS = getPacientesVM.execute();
        if (pacienteVMS.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(pacienteVMS);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PacienteVM> createPaciente(
            @RequestBody final PacienteVM pacienteVM) {

        var paciente = savePacientesVM.execute(PacienteVMAdapter.viewModelToEntity(pacienteVM));
        var result = PacienteVMAdapter.entityToViewModel(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}


package br.unicamp.mc851.evisita.endpoint;

import br.unicamp.mc851.evisita.entity.Paciente;
import br.unicamp.mc851.evisita.usecase.GetPacientesVM;
import br.unicamp.mc851.evisita.usecase.SavePacientesVM;
import br.unicamp.mc851.evisita.usecase.impl.SavePacientesVMImpl;
import br.unicamp.mc851.evisita.viewmodel.PacienteVM;
import br.unicamp.mc851.evisita.viewmodel.adapter.PacienteVMAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {

    @Autowired
    GetPacientesVM pacientesVM;


    @Autowired
    SavePacientesVMImpl savePacientesVMImpl;

    @GetMapping
    public ResponseEntity<Object> getPacientes() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PacienteVM> createPaciente(
            @RequestBody  final PacienteVM pacienteVM) {

        final Paciente paciente = savePacientesVMImpl.execute(PacienteVMAdapter.viewModelToEntity(pacienteVM));
        final PacienteVM result = PacienteVMAdapter.entityToViewModel(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }

}


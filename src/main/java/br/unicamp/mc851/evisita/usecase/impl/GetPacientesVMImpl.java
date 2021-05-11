package br.unicamp.mc851.evisita.usecase.impl;

import br.unicamp.mc851.evisita.entity.Paciente;
import br.unicamp.mc851.evisita.external.repository.GetPacientes;
import br.unicamp.mc851.evisita.usecase.GetPacientesVM;
import br.unicamp.mc851.evisita.viewmodel.PacienteVM;
import br.unicamp.mc851.evisita.viewmodel.adapter.PacienteVMAdapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetPacientesVMImpl implements GetPacientesVM {

    private GetPacientes getPacientes;

    @Override
    public List<PacienteVM> execute() {
        List<Paciente> pacientes = getPacientes.execute();
        return pacientesVMList(pacientes);
    }

    private List<PacienteVM> pacientesVMList(List<Paciente> pacientes) {
        List<PacienteVM> pacienteVMS = new ArrayList<>();
        pacientes.forEach(entity ->
                pacienteVMS.add(PacienteVMAdapter.entityToViewModel(entity)));
        return pacienteVMS;
    }
}

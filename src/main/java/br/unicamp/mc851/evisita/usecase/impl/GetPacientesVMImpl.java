package br.unicamp.mc851.evisita.usecase.impl;

import br.unicamp.mc851.evisita.external.repository.GetPacientes;
import br.unicamp.mc851.evisita.usecase.GetPacientesVM;
import br.unicamp.mc851.evisita.viewmodel.PacienteVM;
import br.unicamp.mc851.evisita.viewmodel.adapter.PacienteVMAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetPacientesVMImpl implements GetPacientesVM {

    private final GetPacientes getPacientes;

    @Override
    public List<PacienteVM> execute() {
        return PacienteVMAdapter.entityListToViewModelList(getPacientes.execute());
    }
}

package br.unicamp.mc851.evisita.viewmodel.adapter;
import br.unicamp.mc851.evisita.entity.Acompanhante;
import br.unicamp.mc851.evisita.entity.Paciente;
import br.unicamp.mc851.evisita.viewmodel.AcompanhanteVM;
import br.unicamp.mc851.evisita.viewmodel.PacienteVM;
import java.util.ArrayList;
import java.util.List;

public class AcompanhanteVMAdapter {

    public static AcompanhanteVM entityToViewModel(Acompanhante entity) {
        List<PacienteVM> pacientes = new ArrayList<>();
        if(entity.getPacientes()!=null)
            entity.getPacientes()
                    .stream()
                    .forEach(model ->
                            pacientes.add(PacienteVMAdapter.entityToViewModel(model)));

        return AcompanhanteVM.builder()
                .cpf(entity.getCpf())
                .rg(entity.getRg())
                .nome(entity.getNome())
                .pacientes(pacientes)
                .build();
    }

    public static Acompanhante viewModelToEntity(AcompanhanteVM viewModel) {
        List<Paciente> pacientes = new ArrayList<>();
        if(viewModel.getPacientes()!=null)
            viewModel.getPacientes()
                    .stream()
                    .forEach(model ->
                            pacientes.add(PacienteVMAdapter.viewModelToEntity(model)));

        return Acompanhante.builder()
                .cpf(viewModel.getCpf())
                .rg(viewModel.getRg())
                .nome(viewModel.getNome())
                .pacientes(pacientes)
                .build();
    }
}

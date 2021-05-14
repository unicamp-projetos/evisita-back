package br.unicamp.mc851.evisita.viewmodel.adapter;

import br.unicamp.mc851.evisita.entity.Paciente;
import br.unicamp.mc851.evisita.viewmodel.PacienteVM;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;

public class PacienteVMAdapter {

    private PacienteVMAdapter() {}

    public static PacienteVM entityToViewModel(@NonNull Paciente entity) {
        return  PacienteVM.builder()
                .prontuario(entity.getProntuario())
                .nome(entity.getNome())
                .rg(entity.getRg())
                .cpf(entity.getCpf())
                .nomeMae(entity.getNomeMae())
                .cadastroSus(entity.getCadastroSus())
                .medico(entity.getMedico())
                .quarto(entity.getQuarto())
                .build();
    }

    public static Paciente viewModelToEntity(@NonNull PacienteVM viewModel) {
        return Paciente.builder()
                .prontuario(viewModel.getProntuario())
                .nome(viewModel.getNome())
                .rg(viewModel.getRg())
                .cpf(viewModel.getCpf())
                .nomeMae(viewModel.getNomeMae())
                .cadastroSus(viewModel.getCadastroSus())
                .medico(viewModel.getMedico())
                .quarto(viewModel.getQuarto())
                .build();
    }

    public static List<PacienteVM> entityListToViewModelList(@NonNull List<Paciente> pacientes) {
        return pacientes.stream()
                .map(PacienteVMAdapter::entityToViewModel)
                .collect(Collectors.toList());
    }

}

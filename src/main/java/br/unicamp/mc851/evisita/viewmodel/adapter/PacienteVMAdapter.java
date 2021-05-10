package br.unicamp.mc851.evisita.viewmodel.adapter;

import br.unicamp.mc851.evisita.entity.Acompanhante;
import br.unicamp.mc851.evisita.entity.Paciente;
import br.unicamp.mc851.evisita.viewmodel.AcompanhanteVM;
import br.unicamp.mc851.evisita.viewmodel.PacienteVM;

import java.util.ArrayList;
import java.util.List;

public class PacienteVMAdapter {

    public static PacienteVM entityToViewModel(final Paciente entity) {
        List<AcompanhanteVM> acompanhantes = new ArrayList<>();
        if(entity.getAcompanhantes()!=null)
            entity.getAcompanhantes()
                    .stream()
                    .forEach(model ->
                            acompanhantes.add(AcompanhanteVMAdapter.entityToViewModel(model)));

        return  PacienteVM.builder()
                .prontuario(entity.getProntuario())
                .nome(entity.getNome())
                .rg(entity.getRg())
                .cpf(entity.getCpf())
                .nomeMae(entity.getNomeMae())
                .cadastroSus(entity.getCadastroSus())
                .medico(entity.getMedico())
                .quarto(entity.getQuarto())
                .acompanhantes(acompanhantes)
                .build();
    }

    public static Paciente viewModelToEntity(final PacienteVM viewModel) {
        List<Acompanhante> acompanhantes = new ArrayList<>();
        if(viewModel.getAcompanhantes()!=null)
            viewModel.getAcompanhantes()
                    .stream()
                    .forEach(model ->
                            acompanhantes.add(AcompanhanteVMAdapter.viewModelToEntity(model)));


        return Paciente.builder()
                .prontuario(viewModel.getProntuario())
                .nome(viewModel.getNome())
                .rg(viewModel.getRg())
                .cpf(viewModel.getCpf())
                .nomeMae(viewModel.getNomeMae())
                .cadastroSus(viewModel.getCadastroSus())
                .medico(viewModel.getMedico())
                .quarto(viewModel.getQuarto())
                .acompanhantes(acompanhantes)
                .build();
    }




}

package br.unicamp.mc851.evisita.viewmodel.adapter;

import br.unicamp.mc851.evisita.entity.Acompanhante;
import br.unicamp.mc851.evisita.viewmodel.AcompanhanteVM;
import lombok.NonNull;

public class AcompanhanteVMAdapter {

    private AcompanhanteVMAdapter() {}

    public static AcompanhanteVM entityToViewModel(@NonNull Acompanhante entity) {
        return AcompanhanteVM.builder()
                .cpf(entity.getCpf())
                .rg(entity.getRg())
                .nome(entity.getNome())
                .build();
    }

    public static Acompanhante viewModelToEntity(@NonNull AcompanhanteVM viewModel) {
        return Acompanhante.builder()
                .cpf(viewModel.getCpf())
                .rg(viewModel.getRg())
                .nome(viewModel.getNome())
                .build();
    }
}

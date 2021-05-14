package br.unicamp.mc851.evisita.external.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "paciente")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PacienteModel {
    @Id
    @Column(name = "paciente_prontuario_pk")
    private String prontuario;
    private String nome;
    private String rg;
    private String cpf;
    private String nomeMae;
    private String cadastroSus;
    private String medico;
    private String quarto;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "paciente_acompanhante",
            joinColumns = @JoinColumn(name = "paciente_prontuario_pk"),
            inverseJoinColumns = @JoinColumn(name = "acompanhante_cpf_pk"))
    Set<AcompanhanteModel> acompanhantes;

}

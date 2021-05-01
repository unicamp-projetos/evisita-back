package br.unicamp.mc851.evisita.external.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "acompanhante")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class AcompanhanteModel {
    @Id
    @Column(name = "acompanhante_cpf_pk")
    private String cpf;
    private String rg;
    private String nome;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    @ManyToMany(mappedBy = "acompanhantes")
    Set<PacienteModel> pacientes;
}

package br.com.cotiinformatica.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false)
    private UUID id;

    @NotNull
    @Size(min = 8, max = 255, message = "Logradouro deve ter entre 8 e 255 caracteres.")
    private String logradouro;

    private String complemento;

    @NotNull
    @Size(min = 1, max = 10, message = "O Número deve ter entre 1 e 10 caracteres.")
    private String numero;

    @NotNull
    private String bairro;

    @NotNull
    private String cidade;

    @NotNull
    private String uf;

    @NotNull
    private String cep;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

}






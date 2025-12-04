package br.com.cotiinformatica.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.regex.*;

@Entity
@Setter
@Getter
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
	@JoinColumn(name="cliente_id", nullable = false)
	private Cliente cliente;

}






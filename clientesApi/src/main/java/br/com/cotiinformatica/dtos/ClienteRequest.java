package br.com.cotiinformatica.dtos;

import java.sql.Date;
import java.util.Set;

import br.com.cotiinformatica.entities.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.Email;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {

	@NotBlank(message = "Por favor, informe o Nome do Clinte: ")
	@Size(min = 8, max = 100, message = "Por favor, informe de 8 a 100 caracteres.")
    @Schema( example = "João da Silva")
	private String  nome; 

	@NotBlank(message = "Por favor, informe o E-mail do Clinte: ")
	@Email(message = "Informe um e-mail válido.")
	@Schema(example="Joao.Silva@gmail.com")
    private String email;

	@NotBlank(message = "Por favor, informe o CPF do Clinte: ")
	@Pattern(
	        regexp = "\\d{11}",
	        message = "Por favor, informe 11 digitos numericos"
	        )
	@Schema(example="12345678901")
	private String cpf;

	@NotBlank(message = "Por favor, informe a Data de Nascimento: ")
	@Size(min = 10, max = 10, message = "Por favor, informe no formato DD/MM/AAAA .")
	@Schema(example="1990-05-15")
	private Date dataNascimento;

	//private Set<Endereco> enderecos;
	
}

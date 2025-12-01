package br.com.cotiinformatica.dtos;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import jakarta.validation.constraints.Email;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
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
	
	
	@NotNull(message = "Por favor, informe o  Endereco do Cliente:")
	@NotNull(message = "Logradouro:")
	@Size(min = 8, max = 100, message = "Por favor, informe de 8 a 100 caracteres.")
	private String     logradouro;
		

	@NotNull(message = "Complemento:")
	@Size(min = 0, max = 100, message = "Por favor, informe de até 100 caracteres.")
	private String complemento;
	
	@NotNull(message = "Número:")
	@Size(min = 1, max = 100, message = "Por favor, informe de 1 a 5 caracteres.")
	private String numero;
	
	@NotNull(message = "Bairro:")
	@Size(min = 1, max = 100, message = "Por favor, informe de 1 a 100 caracteres.")
	private String bairro;
	
	@NotNull(message = "Cidade:")
	@Size(min = 1, max = 100, message = "Por favor, informe de 1 a 100 caracteres.")
	private String cidade;
	
	@NotNull(message = "UF:")
	@Size(min = 2, max = 2, message = "Por favor, informe pelo menos 2 caracteres.")
	private String uf;
	
	@NotNull(message = "Cep:")
	@Size(min = 8, max = 100, message = "Por favor, informe de 8 a 100 caracteres.")
	private String cep;
	
	
	
}

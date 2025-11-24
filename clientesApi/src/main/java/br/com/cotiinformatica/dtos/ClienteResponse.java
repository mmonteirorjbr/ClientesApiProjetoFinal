package br.com.cotiinformatica.dtos;


import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class ClienteResponse {
		private UUID id;
		private String nome;
		private String email;
		private String cpf;
		private Date dataNascimento;
		
		private String logradouro;
		private String complemento;
		private String numero;
		private String bairro;
        private String cidde;
        private String uf;
        private String cep;

	}

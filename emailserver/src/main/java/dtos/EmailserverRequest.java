package dtos;

import java.util.UUID;
import lombok.Data;

public class EmailserverRequest {
	//Essa classe vai receber os dados do cliente para poder montar o email
	
	private UUID id;
	private String email;
	private String nome;
	
}

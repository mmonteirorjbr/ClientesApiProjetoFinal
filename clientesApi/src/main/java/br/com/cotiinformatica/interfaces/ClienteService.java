package br.com.cotiinformatica.interfaces;


import org.springframework.stereotype.Service;

	
	import java.util.UUID;

	import org.springframework.data.domain.Page;

	import br.com.cotiinformatica.dtos.ClienteRequest;
	import br.com.cotiinformatica.dtos.ClienteResponse;

	public interface ClienteService {

		ClienteResponse criar(ClienteRequest request);
		
		ClienteResponse alterar(UUID id, ClienteRequest request);
		
		ClienteResponse excluir(UUID id);
		
		Page<ClienteResponse> consultar(int page, int size, String sortBy, String direction);
		
		ClienteResponse obterPorId(UUID id);
	}




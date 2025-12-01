package br.com.cotiinformatica.services;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.components.RabbitMQProducer;
import br.com.cotiinformatica.dtos.ClienteRequest;
import br.com.cotiinformatica.dtos.ClienteResponse;
import br.com.cotiinformatica.entities.Cliente;
import br.com.cotiinformatica.events.ClienteCadastrado;
import br.com.cotiinformatica.interfaces.ClienteService;
import br.com.cotiinformatica.repositories.ClienteRepository;

//
@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired ClienteRepository ClienteRepository;
	@Autowired RabbitMQProducer rabbitMQProducer;
	
	@Override
	public ClienteResponse criar(ClienteRequest request) {
		
		var mapper = new ModelMapper();
		var Cliente = mapper.map(request, Cliente.class);
		
		
		ClienteRepository.save(Cliente);
		
		var ClienteCadastrado = mapper.map(Cliente, ClienteCadastrado.class);
		
		rabbitMQProducer.send(ClienteCadastrado);
		
		return mapper.map(Cliente, ClienteResponse.class);
	}

	@Override
	public ClienteResponse alterar(UUID id, ClienteRequest request) {

		var Cliente = ClienteRepository.findById(id)
						.orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado para edição."));
		
		var mapper = new ModelMapper();
		mapper.map(request, Cliente);
		
		ClienteRepository.save(Cliente);
		
		return mapper.map(Cliente, ClienteResponse.class);
	}

	@Override
	public ClienteResponse excluir(UUID id) {

		var Cliente = ClienteRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado para exclusão."));
		
		ClienteRepository.delete(Cliente);
		
		var mapper = new ModelMapper();
		return mapper.map(Cliente, ClienteResponse.class);
	}

	@Override
	public Page<ClienteResponse> consultar(int page, int size, String sortBy, String direction) {

		if(size > 25)
			throw new IllegalArgumentException("A quantidade máxima de registros permitido é de 25 Clientes.");
		
		var sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		var pageable = PageRequest.of(page, size, sort);
		var Clientes = ClienteRepository.findAll(pageable);
				
		var mapper = new ModelMapper();
		return Clientes.map(p -> mapper.map(p, ClienteResponse.class));
	}

	@Override
	public ClienteResponse obterPorId(UUID id) {
		
		var Cliente = ClienteRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));
		
		var mapper = new ModelMapper();
		return mapper.map(Cliente, ClienteResponse.class);
	}
}

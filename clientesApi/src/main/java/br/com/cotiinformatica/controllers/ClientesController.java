package br.com.cotiinformatica.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.ClienteRequest;
import br.com.cotiinformatica.dtos.ClienteResponse;
import br.com.cotiinformatica.interfaces.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/clientes")
@Tag(name = "Clientes", description = "Endpoints para gerenciamento de Clientes.")
public class ClientesController {

	@Autowired ClienteService clienteService;
	
	@PostMapping
	@Operation(summary = "Inserir um Cliente", description = "Endpoint para inserir um novo Cliente.")
	public ResponseEntity<ClienteResponse> post(
			@RequestBody @Valid ClienteRequest request
			) {
		return ResponseEntity.ok(clienteService.criar(request));
	}

	@PutMapping("{id}")
	@Operation(summary = "Atualizar um cliente", description = "Endpoint para atualizar um cliente existente.")
	public ResponseEntity<ClienteResponse> put(
			@PathVariable UUID id,
			@RequestBody @Valid ClienteRequest request
			) {
		return ResponseEntity.ok(clienteService.alterar(id, request));
	}

	@DeleteMapping("{id}")
	@Operation(summary = "Excluir um cliente", description = "Endpoint para excluir um cliente existente.")
	public ResponseEntity<ClienteResponse> delete(
			@PathVariable UUID id
			) {
		return ResponseEntity.ok(clienteService.excluir(id));
	}

	@GetMapping
	@Operation(summary = "Obter uma lista de clientes", description = "Endpoint para obter uma lista de clientes existentes.")
	public ResponseEntity<Page<ClienteResponse>> get(
			@RequestParam(defaultValue = "0") int pagina,
			@RequestParam(defaultValue = "25") int qtdRegistros,
			@RequestParam(defaultValue = "nomeCliente") String campoOrdenacao,
			@RequestParam(defaultValue = "asc") String tipoOrdenacao
			) {
		return ResponseEntity.ok(clienteService.consultar(pagina, qtdRegistros, campoOrdenacao, tipoOrdenacao));
	}
	
	@GetMapping("{id}")
	@Operation(summary = "Obter um cliente", description = "Endpoint para obter um cliente existente.")
	public ResponseEntity<ClienteResponse> getById(
			@PathVariable UUID id
			) {
		return ResponseEntity.ok(clienteService.obterPorId(id));
	}
}




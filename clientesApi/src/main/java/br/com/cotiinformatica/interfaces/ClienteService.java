package br.com.cotiinformatica.interfaces;


import br.com.cotiinformatica.dtos.ClienteRequest;
import br.com.cotiinformatica.dtos.ClienteResponse;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface ClienteService {

    ClienteResponse criar(ClienteRequest request);

    ClienteResponse alterar(UUID id, ClienteRequest request);

    ClienteResponse excluir(UUID id);

    Page<ClienteResponse> consultar(int page, int size, String sortBy, String direction);

    ClienteResponse obterPorId(UUID id);
}




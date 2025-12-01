package br.com.cotiinformatica.repositories;



import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

	import br.com.cotiinformatica.entities.Cliente;

	@Repository
	public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

	}



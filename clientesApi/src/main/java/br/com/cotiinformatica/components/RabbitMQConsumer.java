package br.com.cotiinformatica.components;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cotiinformatica.events.ClienteCadastrado;

/*@Component
public class RabbitMQConsumer {
	
	@Autowired ObjectMapper objectMapper;

	*//*
	 * Método para ler a fila constantemente
	 *//*
	@RabbitListener(queues = "clientes")
	public void receive(@Payload String payload) {
		
		try {
			
			//deserializar os dados lidos da API (json)
			var clienteCadastrado = objectMapper.readValue(payload, ClienteCadastrado.class);
			
			//enviando para a API de faturamento
			var restTemplate = new RestTemplate();			

			var url = "http://localhost:8082/api/v1/clientes";			
			var response = restTemplate.postForObject(url, clienteCadastrado, String.class);
			
			System.out.println(response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}*/






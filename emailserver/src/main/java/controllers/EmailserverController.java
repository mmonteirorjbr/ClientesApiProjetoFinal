package controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/emailserver")
public class EmailserverController {
	@PostMapping
	public ResponseEntity<String> post() {
		return ResponseEntity.ok
("Email capturado com sucesso.");
	}
}

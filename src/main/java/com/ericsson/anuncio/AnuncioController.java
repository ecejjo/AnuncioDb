package com.ericsson.anuncio;

import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnuncioController {

	@Autowired
	private AnunciosRepository repository;

	@PostConstruct
	public void init() {
		repository.save(new Anuncio("Nombre1", "Asunto1", "Comentarios1"));
		repository.save(new Anuncio("Nombre2", "Asunto2", "Comentarios2"));
	}

	@GetMapping("/")	
	public String mostrarListaAnuncios(Model model) {	
		model.addAttribute("anuncios", repository.findAll());
		return "TablonAnuncios_template";
	}


	@GetMapping("/Nuevo")
	public String NuevoAnuncio(Model model, 
		@RequestParam String nombre,
		@RequestParam String asunto,
		@RequestParam String comentarios) {
	
		repository.save(new Anuncio(nombre, asunto, comentarios));
		
		model.addAttribute("nombre", nombre);
		model.addAttribute("asunto", asunto);
		model.addAttribute("comentarios", comentarios);

		return "NuevoAnuncio_template";
	}
	
	@GetMapping("/anuncio/{num}")
	public String verAnuncio(Model model, @PathVariable long id) {
		Optional<Anuncio> anuncio = repository.findById(id);
		model.addAttribute("anuncio", anuncio);
		return "VerAnuncio_template";
	}
}

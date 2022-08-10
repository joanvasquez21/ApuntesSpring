package com.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.web.app.model.Usuario;

//Marca o configura esta clase como un componente de Spring pero de tipo controlador

@Controller
@RequestMapping("/app")
public class IndexController {
	// Un controlador va a tener metodos, se encargara de manejar las peticiones del usuario
	// RequestMapping para mapear

	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	@GetMapping({"/index", "/", "/home"})
	public String index(Model modelo) {
		modelo.addAttribute("titulo" , textoIndex);
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario(); 
		usuario.setNombre("Joan");
		usuario.setApellido("Vasquez");
		usuario.setEmail("joan@correo.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo" , textoPerfil.concat(usuario.getNombre()));
		return "perfil";
	}
	
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		

		model.addAttribute("titulo", textoPerfil);
	
		
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		
		List<Usuario> usuarios  = Arrays.asList(new Usuario("Joan", "Vasquez" , "jvasquez@gmail.com"),
				new Usuario("Joe", "Vasquez" , "jvasquez@gmail.com"),
				new Usuario("Joel", "Vasquez" , "jvasquez@gmail.com"),
				new Usuario("Joel", "Vasquez" , "jvasquez@gmail.com")
				);
		return usuarios;
	}
}

package controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import services.UsuarioService;
import entities.Usuario;


@Controller
public class LoginConttroler {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String form(ModelMap map){
		map.addAttribute("usuario", new Usuario());
		return "login/login";
	}
	
	@RequestMapping(value="logar", method=RequestMethod.POST)
	public String logar(@ModelAttribute("usuario") Usuario usuario, HttpSession sessao, ModelMap map){
		if(usuario.getLogin() == null || usuario.getSenha() == null ){
			map.addAttribute("usuario", usuario);
			return  "login/login";
		}
		Usuario usuarioBD = usuarioService.logar(usuario.getLogin(), usuario.getSenha()); 
		if(usuarioBD == null){
			usuario.setSenha("");
			map.addAttribute("usuario", usuario);
			return  "login/login";
		}
		sessao.setAttribute("usuario", usuario);
		return "redirect:/categoria/listar";
	}
	
	
}

package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import entities.Categoria;
import services.CategoriaService;

@RequestMapping(value = "categoria")
@Controller
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public String list(ModelMap map) {
		List<Categoria> categorias = categoriaService.listar();
		map.addAttribute("categorias", categorias);
		return "categoria/listar";
	}

	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String createForm(ModelMap map) {
		map.addAttribute("categoria", new Categoria());
		return "categoria/form";
	}

	@RequestMapping(value = "{id}/form", method = RequestMethod.GET)
	public String updateForm(@PathVariable Long id, ModelMap map) {
		Categoria categoria = categoriaService.buscarPorId(id);
		map.addAttribute("categoria", categoria);
		return "categoria/formUpdate";
	}

	@RequestMapping(method = RequestMethod.POST, value = "save")
	public String save(@ModelAttribute("categoria") Categoria categoria) {
		categoriaService.inserir(categoria);
		return "redirect:/categoria/listar";
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}/remove")
	public String remove(@PathVariable Long id) {
		categoriaService.remover(new Categoria(id));
		return "redirect:/categoria/listar";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute Categoria categoria, ModelMap map) {
		categoriaService.atualizar(categoria);
		return "redirect:/categoria/listar";
	}
//	@RequestMapping(value="filtrar", method=RequestMethod.GET)
//	public String filtrar(@ModelAttribute("filtro") Categoria filtro, ModelMap map){
//		
//		List<Categoria> categorias = categoriaService.buscar(filtro);
//		map.addAttribute("categorias", categorias);
//		map.addAttribute("filtro", filtro);
//		return "categoria/listar";
//	}
}

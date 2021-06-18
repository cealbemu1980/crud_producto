package com.crudProducto.controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crudProducto.model.Producto;
import com.crudProducto.repository.ProductoRepository;

@Controller
@RequestMapping("/producto") //http:localhost:8080/producto
public class ProductoControler {
	
	@Autowired
	private ProductoRepository prodReps;
	
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("productos", prodReps.findAll());
		return "home";
	}
	@GetMapping("/create") //http:localhost:8080/producto/create
	public String create() {
		return "create";
	}
	@PostMapping("/save")
	public String save(Producto producto) {
		System.out.print("Mostrar elementos de productos" + producto);
		prodReps.save(producto);
		return "redirect:/producto";
	}
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Integer id, Model model) {
		Producto p = prodReps.getOne(id);
		System.out.print("Producto actualizado"+p);
		model.addAttribute("producto", p);
		return "editar";
	}
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Integer id) {
		Producto p = prodReps.getOne(id);
		System.out.print("Producto eliminado"+p);
		prodReps.delete(p);
		return "redirect:/producto";
	}

}

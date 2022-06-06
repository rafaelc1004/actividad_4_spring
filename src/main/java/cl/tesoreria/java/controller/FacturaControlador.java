package cl.tesoreria.java.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.tesoreria.java.interfaceRepository.FacturaRepository;
import cl.tesoreria.java.interfaceRepository.ProveedorRepository;
import cl.tesoreria.java.modelo.Factura;
import cl.tesoreria.java.modelo.Proveedor;

@Controller
@RequestMapping("/factura")
public class FacturaControlador {
	
	
	@Autowired
	private FacturaRepository facturaRepository; 
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@GetMapping("/nuevo")
	public String nuevo(Factura factura, Model modelo) {
		List<Proveedor> lista = proveedorRepository.findAll();
		modelo.addAttribute("proveedores", lista);
		return"factura/form";
		
	}
	
	@GetMapping("editar/{id}")
	public String editar(@PathVariable(name="id") Factura factura, Model model) {
		List<Proveedor> listaProveedor = proveedorRepository.findAll();
		model.addAttribute("proveedores", listaProveedor);
		model.addAttribute("factura", factura);
		return "factura/form";
	}

	@PostMapping("/procesar")
	public String procesar(@Valid Factura factura, BindingResult informeValidar) {
		if(informeValidar.hasErrors()) {
			return "factura/form";
		}
		facturaRepository.saveAndFlush(factura);
		return "redirect:/factura/listado";	
		
	}
	
	@GetMapping("/listado")
	public String listar(Model modelo) {
		List<Factura> listaFactura = facturaRepository.findAll();
		modelo.addAttribute("facturas", listaFactura);
		return "factura/listado";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id) {
		facturaRepository.deleteById(id);
		return "redirect:/factura/listado";
	}
	

}

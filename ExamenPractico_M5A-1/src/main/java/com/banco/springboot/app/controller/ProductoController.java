package com.banco.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.banco.springboot.app.entity.Producto;
import com.banco.springboot.app.service.ProductoServicio;


@RestController
@RequestMapping("/api")
public class ProductoController {
	
	@Autowired
	public ProductoServicio productoservicio;
	
	// LISTAR
		@GetMapping("/Producto")
		public List<Producto> index() {
			return productoservicio.findAll();
		}

		// BUSCAR POR ID
		@GetMapping("/Producto/{id}")
		public Producto show(@PathVariable Long id) {
			return productoservicio.findById(id);
		}

		// GUARDAR
		@PostMapping("/Producto")
		@ResponseStatus(HttpStatus.CREATED)
		public Producto create(@RequestBody Producto producto) {

			return productoservicio.save(producto);
		}

		// EDITAR
		@PutMapping("/Producto/{id}")
		@ResponseStatus(HttpStatus.CREATED)
		public Producto update(@RequestBody Producto producto, @PathVariable Long id) {

			Producto proActual = productoservicio.findById(id);
			proActual.setDescripcion(producto.getDescripcion());
			proActual.setCantidad(producto.getCantidad());
			proActual.setPrecio(producto.getPrecio());

			return productoservicio.save(proActual);
		}

		// ELIMINAR
		@DeleteMapping("/Producto/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void delete(@PathVariable Long id) {
			productoservicio.delete(id);
		}
	

}

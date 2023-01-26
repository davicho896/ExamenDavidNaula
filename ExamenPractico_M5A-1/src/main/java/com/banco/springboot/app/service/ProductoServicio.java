package com.banco.springboot.app.service;

import java.util.List;

import com.banco.springboot.app.entity.Producto;



public interface ProductoServicio {
	
	public List<Producto> findAll();

	public Producto save(Producto producto);

	public Producto findById(Long id);

	public void delete(Long id);

}

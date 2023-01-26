package com.banco.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


import com.banco.springboot.app.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}

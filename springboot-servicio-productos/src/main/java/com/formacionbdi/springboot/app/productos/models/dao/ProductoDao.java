package com.formacionbdi.springboot.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.uy.curso.commons.model.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long>{

}

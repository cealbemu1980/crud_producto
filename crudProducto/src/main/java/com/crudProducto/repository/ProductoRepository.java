package com.crudProducto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.crudProducto.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> { 

}

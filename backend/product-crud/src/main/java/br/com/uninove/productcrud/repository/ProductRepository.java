package br.com.uninove.productcrud.repository;

import br.com.uninove.productcrud.core.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}

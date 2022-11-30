package br.com.uninove.productcrud.core.service;

import br.com.uninove.productcrud.core.domain.dto.ProductDto;
import br.com.uninove.productcrud.core.domain.model.Product;
import br.com.uninove.productcrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public ProductDto create(ProductDto product) {
        Product productToSave = Product.builder()
                .price(product.getPrice())
                .name(product.getName())
                .description(product.getDescription())
                .createdAt(LocalDateTime.now())
                .build();

        repository.save(productToSave);

        return productToSave.toDto(productToSave);
    }

    public List<ProductDto> findAll() {
        List<Product> productsFound = repository.findAll();

        List<ProductDto> products = new ArrayList<>();

        productsFound.stream().forEach(product -> {
            products.add(product.toDto(product));
        });

        return products;
    }

    public ProductDto detail(Integer id) {
        Optional<Product> found = repository.findById(id);

        if (found.isEmpty()) {
            return null;
        }

        ProductDto product = found.get().toDto(found.get());

        return product;
    }

    public boolean delete(Integer id) {
        Optional<Product> found = repository.findById(id);

        if (found.isEmpty()) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }

    public ProductDto update(Integer id, ProductDto product) {
        Optional<Product> found = repository.findById(id);

        if (found.isEmpty()) {
            return null;
        }

        product.setId(found.get().getId());

        Product productToSave = Product.builder()
                .id(product.getId())
                .price(product.getPrice())
                .name(product.getName())
                .description(product.getDescription())
                .createdAt(LocalDateTime.now())
                .build();

        repository.save(productToSave);

        return productToSave.toDto(productToSave);
    }
}

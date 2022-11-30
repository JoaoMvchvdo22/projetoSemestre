package br.com.uninove.productcrud.controller;

import br.com.uninove.productcrud.core.domain.dto.ProductDto;
import br.com.uninove.productcrud.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @CrossOrigin
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto product, UriComponentsBuilder uriBuilder) {
        ProductDto savedMail = service.create(product);
        URI uri = uriBuilder.path("/product/{id}").buildAndExpand(savedMail.getId()).toUri();
        return ResponseEntity.created(uri).body(savedMail);
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<?> findAll() {
        List<ProductDto> response = service.findAll();
        if (response.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(response);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<?> detail(@PathVariable(required = true, value = "id") Integer id) {
        ProductDto response = service.detail(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }
}


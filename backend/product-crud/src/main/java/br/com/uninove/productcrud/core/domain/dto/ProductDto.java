package br.com.uninove.productcrud.core.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ProductDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;

    private String name;

    private String description;

    private Long price;

    private LocalDateTime createdAt;
}

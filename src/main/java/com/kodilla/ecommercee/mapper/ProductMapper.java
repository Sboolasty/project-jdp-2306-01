package com.kodilla.ecommercee.mapper;


import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductMapper {

    public Product mapToProduct(final ProductDto productDto) {
        return new Product();
    }

    public ProductDto mapToProductDto(final Optional<Product> product) {
        return new ProductDto(
                product.get().getProductId(),
                product.get().getProductName()
        );
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(
                product.getProductId(),
                product.getProductName()
        );
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        if (productList.isEmpty())
            return new ArrayList<>();
        else {
            return productList.stream()
                    .map(this::mapToProductDto)
                    .collect(Collectors.toList());
        }
    }

    public List<Product> mapToProductList(final List<ProductDto> productList) {
        if (productList.isEmpty())
            return new ArrayList<>();
        else {
            return productList.stream()
                    .map(this::mapToProduct)
                    .collect(Collectors.toList());
        }
    }
}
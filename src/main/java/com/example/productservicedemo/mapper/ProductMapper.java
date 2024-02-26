package com.example.productservicedemo.mapper;

import com.example.productservicedemo.entity.Product;
import lombok.RequiredArgsConstructor;
import org.mapstruct.*;
import org.springframework.stereotype.Component;
import org.example.rest.model.ProductDto;


@Mapper
public interface ProductMapper {

    @Mapping(target = "status", source = "quantity", qualifiedByName = "parseStatus")
    ProductDto toDto(Product product);

    Product toProduct(ProductDto productDto);

    void updateProduct(@MappingTarget Product target, ProductDto source);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void patchProduct(@MappingTarget Product target, ProductDto source);

    @Named("parseStatus")
    default ProductDto.StatusEnum parseStatus(Integer quantity){
        if (quantity == 0){
            return ProductDto.StatusEnum.OUT_OF_STOCK;
        }else {
            return ProductDto.StatusEnum.IN_STOCK;
        }
    }

}

package com.lite.thinking.store.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lite.thinking.store.dto.ProductDto;
import com.lite.thinking.store.model.Product;


@Component
public class ProductMapper {
	
	@Autowired
    private ModelMapper modelMapper;
	
	public ProductDto convertToDto(final Product product) {
		final ProductDto productDto = modelMapper.map(product, ProductDto.class);
	    return productDto;
	}
	
	public Product convertToEntity(final ProductDto productDto) {
	    final Product product = modelMapper.map(productDto, Product.class);
	    return product;
	}
	
}

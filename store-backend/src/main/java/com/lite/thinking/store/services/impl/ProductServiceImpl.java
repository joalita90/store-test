package com.lite.thinking.store.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lite.thinking.store.dto.ProductDto;
import com.lite.thinking.store.mapper.ProductMapper;
import com.lite.thinking.store.model.Product;
import com.lite.thinking.store.repository.ProductRepository;
import com.lite.thinking.store.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;
	private final ProductMapper productMapper;
	
    public ProductServiceImpl(final ProductRepository productRepository, final ProductMapper productMapper)
    {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDto> getAllProducts() {     
    	final List<Product> products = productRepository.findAll();    	
    	return products.stream().map(productMapper::convertToDto).collect(Collectors.toList());    	
    }

    public ProductDto save(final ProductDto productDto) {
    	 Product product = productRepository.save(productMapper.convertToEntity(productDto));         
         return productMapper.convertToDto(product);
    }

    public ProductDto getById(final int id) {

        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Product not found");
        }
        return productMapper.convertToDto(productOptional.get());
    }

    public ProductDto update(final int id, final ProductDto productDto) {
    	if(!Objects.equals(id, productDto.getId())){
    		throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "IDs don't match");
        }
    	
    	Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Product not found");
        }
        
        Product existingData = productOptional.get();
        existingData.setName(productDto.getName());
        
        Product product = productRepository.save(productMapper.convertToEntity(productDto));
        
        return productMapper.convertToDto(product);
    }

    public void delete(final int id) {
        productRepository.deleteById(id);
    }

	@Override
	public List<ProductDto> getProductsById(int id) {
		List<Product> products = productRepository.findAllByCompany_Id(id);		
		return products.stream().map(productMapper::convertToDto).collect(Collectors.toList());    	
	}

}

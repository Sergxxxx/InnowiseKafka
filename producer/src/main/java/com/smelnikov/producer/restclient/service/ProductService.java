package com.smelnikov.producer.restclient.service;

import com.smelnikov.libs.dto.Product;
import com.smelnikov.libs.dto.ProductData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class ProductService {

    private RestTemplate restTemplate;
    private String productUrl;

    public ProductService(RestTemplate restTemplate, @Value("${product_url}")String productUrl) {
        this.restTemplate = restTemplate;
        this.productUrl = productUrl;
    }

    public List<Product> getProduct(Integer limit){
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(productUrl)
                .queryParam("limit", limit);

        ProductData productData = restTemplate.getForObject(builder.toUriString(), ProductData.class);
        return productData.getData();
    }
}

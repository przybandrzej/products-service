package tech.przybysz.pms.productsservice.service;

import tech.przybysz.pms.productsservice.service.dto.ProductShopLinkDTO;

import java.util.Optional;

public interface ProductShopLinkService {

  ProductShopLinkDTO save(ProductShopLinkDTO productShopLinkDTO);

  Optional<ProductShopLinkDTO> findOne(Long id);

  void delete(Long id);
}

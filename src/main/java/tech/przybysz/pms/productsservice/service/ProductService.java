package tech.przybysz.pms.productsservice.service;

import org.springframework.lang.Nullable;
import tech.przybysz.pms.productsservice.service.dto.ProductDTO;
import tech.przybysz.pms.productsservice.service.dto.fulldata.ProductFDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {

  ProductDTO save(ProductDTO productDTO);

  List<ProductDTO> find(@Nullable String searchTerm, int size, int page);

  Optional<ProductDTO> findOne(Long id);

  void delete(Long id);

  Optional<ProductFDTO> findOneWithFullInfo(Long id);
}

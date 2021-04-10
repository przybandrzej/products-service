package tech.przybysz.pms.productsservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.przybysz.pms.productsservice.domain.AttributeEntry;
import tech.przybysz.pms.productsservice.domain.Category;
import tech.przybysz.pms.productsservice.domain.Product;
import tech.przybysz.pms.productsservice.domain.Shop;
import tech.przybysz.pms.productsservice.repository.*;
import tech.przybysz.pms.productsservice.service.ProductService;
import tech.przybysz.pms.productsservice.service.dto.ProductDTO;
import tech.przybysz.pms.productsservice.service.mapper.ProductMapper;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Product}.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

  private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

  private final ProductRepository productRepository;
  private final ProductMapper productMapper;
  private final BrandRepository brandRepository;
  private final ImageUrlRepository imageUrlRepository;
  private final CurrencyRepository currencyRepository;
  private final ShopRepository shopRepository;
  private final CategoryRepository categoryRepository;
  private final AttributeEntryRepository attributeEntryRepository;

  public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper,
                            BrandRepository brandRepository, ImageUrlRepository imageUrlRepository,
                            CurrencyRepository currencyRepository, ShopRepository shopRepository,
                            CategoryRepository categoryRepository, AttributeEntryRepository attributeEntryRepository) {
    this.productRepository = productRepository;
    this.productMapper = productMapper;
    this.brandRepository = brandRepository;
    this.imageUrlRepository = imageUrlRepository;
    this.currencyRepository = currencyRepository;
    this.shopRepository = shopRepository;
    this.categoryRepository = categoryRepository;
    this.attributeEntryRepository = attributeEntryRepository;
  }

  @Override
  public ProductDTO save(ProductDTO productDTO) {
    log.debug("Request to save Product : {}", productDTO);
    Product product = productMapper.toEntity(productDTO);
    product = productRepository.save(product);
    product.setBrand(brandRepository.findById(product.getBrand().getId()).get());
    product.setCurrency(currencyRepository.findById(product.getCurrency().getId()).get());
    product.setPreviewImage(imageUrlRepository.findById(product.getPreviewImage().getId()).get());
    product.setCategories(new HashSet<>(categoryRepository.findAllById(
        product.getCategories().stream().map(Category::getId).collect(Collectors.toList()))));
    product.setShops(new HashSet<>(shopRepository.findAllById(
        product.getShops().stream().map(Shop::getId).collect(Collectors.toList()))));
    product.setAttributeEntries(new HashSet<>(attributeEntryRepository.findAllById(
        product.getAttributeEntries().stream().map(AttributeEntry::getId).collect(Collectors.toList()))));
    return productMapper.toDto(product);
  }

  @Override
  @Transactional(readOnly = true)
  public List<ProductDTO> findAll() {
    log.debug("Request to get all Products");
    return productRepository.findAllWithEagerRelationships().stream()
        .map(productMapper::toDto)
        .collect(Collectors.toCollection(LinkedList::new));
  }


  public Page<ProductDTO> findAllWithEagerRelationships(Pageable pageable) {
    return productRepository.findAllWithEagerRelationships(pageable).map(productMapper::toDto);
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<ProductDTO> findOne(Long id) {
    log.debug("Request to get Product : {}", id);
    return productRepository.findOneWithEagerRelationships(id)
        .map(productMapper::toDto);
  }

  @Override
  public void delete(Long id) {
    log.debug("Request to delete Product : {}", id);
    productRepository.deleteById(id);
  }
}

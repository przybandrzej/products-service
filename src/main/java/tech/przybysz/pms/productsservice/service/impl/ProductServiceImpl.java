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
import tech.przybysz.pms.productsservice.service.dto.fulldata.ProductFDTO;
import tech.przybysz.pms.productsservice.service.exception.EntityNotFoundException;
import tech.przybysz.pms.productsservice.service.mapper.ProductMapper;

import java.util.*;
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

  @SuppressWarnings({"java:S3655"})
  @Override
  public ProductDTO save(ProductDTO productDTO) {
    log.debug("Request to save Product : {}", productDTO);
    Product product = productMapper.toEntity(productDTO);
    product = productRepository.save(product);
    if(product.getBrand() != null) {
      product.setBrand(brandRepository.findById(product.getBrand().getId()).get());
    }
//    if(product.getCurrency() != null) {
//      product.setCurrency(currencyRepository.findById(product.getCurrency().getId()).get());
//    }
    if(product.getPreviewImage() != null) {
      product.setPreviewImage(imageUrlRepository.findById(product.getPreviewImage().getId()).get());
    }
    if(product.getCategory() != null) {
      product.setCategory(categoryRepository.findById(product.getCategory().getId()).get());
    }
//    product = productRepository.findOneWithEagerRelationships(product.getId()).orElseThrow(() -> new EntityNotFoundException("product"));
    return productMapper.toDto(product);
  }

  @Override
  @Transactional(readOnly = true)
  public List<ProductDTO> findAll() {
    log.debug("Request to get all Products");
//    return productRepository.findAllWithEagerRelationships().stream()
//        .map(productMapper::toDto)
//        .collect(Collectors.toCollection(LinkedList::new));
    return new ArrayList<>();
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<ProductDTO> findOne(Long id) {
    log.debug("Request to get Product : {}", id);
//    return productRepository.findOneWithEagerRelationships(id)
//        .map(productMapper::toDto);
    return Optional.empty();
  }

  @Override
  public void delete(Long id) {
    log.debug("Request to delete Product : {}", id);
    productRepository.deleteById(id);
  }

  @Override
  public Optional<ProductFDTO> findOneWithFullInfo(Long id) {
    log.debug("Request to find Product : {} with full info", id);
//    return productRepository.findOneWithEagerRelationships(id).map(productMapper::toFDto);
    return Optional.empty();
  }

  @Override
  public void addShops(Long productId, List<Long> shopIds) {
    log.debug("Request to add Shops : {} to Product : {}", shopIds, productId);
    List<Shop> allById = shopRepository.findAllById(shopIds);
    Product product = productRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException("product"));
//    allById.forEach(product::addShop);
    productRepository.save(product);
  }
}

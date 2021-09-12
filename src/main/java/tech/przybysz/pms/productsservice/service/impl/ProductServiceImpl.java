package tech.przybysz.pms.productsservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.przybysz.pms.productsservice.domain.AttributeEntry;
import tech.przybysz.pms.productsservice.domain.Product;
import tech.przybysz.pms.productsservice.domain.ProductShopLink;
import tech.przybysz.pms.productsservice.repository.*;
import tech.przybysz.pms.productsservice.service.ProductService;
import tech.przybysz.pms.productsservice.service.dto.ProductDTO;
import tech.przybysz.pms.productsservice.service.dto.fulldata.ProductFDTO;
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
  private final CategoryRepository categoryRepository;
  private final AttributeEntryRepository attributeEntryRepository;
  private final ProductShopLinkRepository productShopLinkRepository;

  public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper,
                            BrandRepository brandRepository, ImageUrlRepository imageUrlRepository,
                            CategoryRepository categoryRepository, AttributeEntryRepository attributeEntryRepository,
                            ProductShopLinkRepository productShopLinkRepository) {
    this.productRepository = productRepository;
    this.productMapper = productMapper;
    this.brandRepository = brandRepository;
    this.imageUrlRepository = imageUrlRepository;
    this.productShopLinkRepository = productShopLinkRepository;
    this.categoryRepository = categoryRepository;
    this.attributeEntryRepository = attributeEntryRepository;
  }

  @SuppressWarnings({"java:S3655"})
  @Override
  public ProductDTO save(ProductDTO productDTO) {
    log.debug("Request to save Product : {}", productDTO);
    Product product = productMapper.toEntity(productDTO);
    product = productRepository.save(product);
//    if(product.getBrand() != null) {
//      product.setBrand(brandRepository.findById(product.getBrand().getId()).get());
//    }
//    if(product.getPreviewImage() != null) {
//      product.setPreviewImage(imageUrlRepository.findById(product.getPreviewImage().getId()).get());
//    }
//    if(product.getCategory() != null) {
//      product.setCategory(categoryRepository.findById(product.getCategory().getId()).get());
//    }
    return productMapper.toDto(product);
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<ProductDTO> findOne(Long id) {
    log.debug("Request to get Product : {}", id);
    return productRepository.findById(id)
        .map(productMapper::toDto);
  }

  @Override
  public void delete(Long id) {
    log.debug("Request to delete Product : {}", id);
    productRepository.deleteById(id);
  }

  @Override
  public Optional<ProductFDTO> findOneWithFullInfo(Long id) {
    log.debug("Request to find Product : {} with full info", id);
    Optional<Product> prod = productRepository.findById(id);
    Collection<AttributeEntry> attributes = attributeEntryRepository.findAllByProductId(id);
    Collection<ProductShopLink> shopLinks = productShopLinkRepository.findAllByProductId(id);
    return prod.map(it -> {
      it.setAttributeEntries(new HashSet<>(attributes));
      return it;
    })
    .map(it -> productMapper.toFDto(it, new ArrayList<>(shopLinks)));
  }

  @Override
  public List<ProductDTO> find(@Nullable String searchTerm, int size, int page) {
    var pageReq = PageRequest.of(page, size);
    if(searchTerm == null) {
      return productRepository.findAll(pageReq).stream().map(productMapper::toDto).collect(Collectors.toList());
    }
    String q = searchTerm.toLowerCase();
    Collection<Product> searchResult = productRepository.findAllByNameContainingIgnoreCaseOrSubtitleContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrBrandNameContainingIgnoreCaseOrCategoryNameContainingIgnoreCase(q, q, q, q, q, pageReq);
    return searchResult.stream().map(productMapper::toDto).collect(Collectors.toList());
  }
}

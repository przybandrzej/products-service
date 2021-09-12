package tech.przybysz.pms.productsservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.przybysz.pms.productsservice.domain.ProductShopLink;
import tech.przybysz.pms.productsservice.repository.ProductShopLinkRepository;
import tech.przybysz.pms.productsservice.service.ProductShopLinkService;
import tech.przybysz.pms.productsservice.service.dto.ProductShopLinkDTO;
import tech.przybysz.pms.productsservice.service.mapper.ProductShopLinkMapper;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ProductShopLink}.
 */
@Service
@Transactional
public class ProductShopLinkServiceImpl implements ProductShopLinkService {

  private final Logger log = LoggerFactory.getLogger(ProductShopLinkServiceImpl.class);

  private final ProductShopLinkRepository productShopLinkRepository;

  private final ProductShopLinkMapper productShopLinkMapper;

  public ProductShopLinkServiceImpl(ProductShopLinkRepository productShopLinkRepository, ProductShopLinkMapper productShopLinkMapper) {
    this.productShopLinkRepository = productShopLinkRepository;
    this.productShopLinkMapper = productShopLinkMapper;
  }

  @Override
  public ProductShopLinkDTO save(ProductShopLinkDTO productShopLinkDTO) {
    log.debug("Request to save ProductShopLink : {}", productShopLinkDTO);
    ProductShopLink productShopLink = productShopLinkMapper.toEntity(productShopLinkDTO);
    productShopLink = productShopLinkRepository.save(productShopLink);
    return productShopLinkMapper.toDto(productShopLink);
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<ProductShopLinkDTO> findOne(Long id) {
    log.debug("Request to get ProductShopLink : {}", id);
    return productShopLinkRepository.findById(id)
        .map(productShopLinkMapper::toDto);
  }

  @Override
  public void delete(Long id) {
    log.debug("Request to delete ProductShopLink : {}", id);
    productShopLinkRepository.deleteById(id);
  }
}

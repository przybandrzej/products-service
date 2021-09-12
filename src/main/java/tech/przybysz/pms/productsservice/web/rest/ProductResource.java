package tech.przybysz.pms.productsservice.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.przybysz.pms.productsservice.service.ImageUrlService;
import tech.przybysz.pms.productsservice.service.ProductService;
import tech.przybysz.pms.productsservice.service.dto.ImageUrlDTO;
import tech.przybysz.pms.productsservice.service.dto.ProductDTO;
import tech.przybysz.pms.productsservice.service.dto.fulldata.ProductFDTO;
import tech.przybysz.pms.productsservice.web.rest.util.HeaderUtil;
import tech.przybysz.pms.productsservice.web.rest.util.ResponseUtil;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link tech.przybysz.pms.productsservice.domain.Product}.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductResource {

  private final Logger log = LoggerFactory.getLogger(ProductResource.class);

  private static final String ENTITY_NAME = "product";

  @Value("${spring.application.name}")
  private String applicationName;

  private final ProductService productService;
  private final ImageUrlService imageUrlService;

  public ProductResource(ProductService productService, ImageUrlService imageUrlService) {
    this.productService = productService;
    this.imageUrlService = imageUrlService;
  }

  @PostMapping("/products")
  public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) throws URISyntaxException {
    log.debug("REST request to save Product : {}", productDTO);
    ProductDTO result = productService.save(productDTO);
    return ResponseEntity.created(new URI("/api/products/" + result.getId()))
        .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
        .body(result);
  }

  @PutMapping("/products")
  public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO) {
    log.debug("REST request to update Product : {}", productDTO);
    ProductDTO result = productService.save(productDTO);
    return ResponseEntity.ok()
        .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, productDTO.getId().toString()))
        .body(result);
  }

  @GetMapping("/products")
  public List<ProductDTO> searchProducts(@RequestParam(required = false) String q,
                                         @RequestParam(required = false, defaultValue = "10") int size,
                                         @RequestParam(required = false, defaultValue = "0") int page) {
    log.debug("REST request to search Products : {} [{}]", q, size);
    return productService.find(q, size, page);
  }

  @GetMapping("/products/{id}")
  public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {
    log.debug("REST request to get Product : {}", id);
    Optional<ProductDTO> productDTO = productService.findOne(id);
    return ResponseUtil.wrapOrNotFound(productDTO);
  }

  @DeleteMapping("/products/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
    log.debug("REST request to delete Product : {}", id);
    productService.delete(id);
    return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
  }

  @GetMapping("/products/{id}/images")
  public List<ImageUrlDTO> getProductImages(@PathVariable Long id) {
    log.debug("REST request to get images of Product : {}", id);
    return imageUrlService.findAllOfProduct(id);
  }

  @GetMapping("/products/{id}/full-info")
  public ResponseEntity<ProductFDTO> getProductFullInfo(@PathVariable Long id) {
    log.debug("REST request to get Product : {}", id);
    Optional<ProductFDTO> productDTO = productService.findOneWithFullInfo(id);
    return ResponseUtil.wrapOrNotFound(productDTO);
  }
}

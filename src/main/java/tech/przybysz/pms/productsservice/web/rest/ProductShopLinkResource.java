package tech.przybysz.pms.productsservice.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.przybysz.pms.productsservice.service.ProductShopLinkService;
import tech.przybysz.pms.productsservice.service.dto.ProductShopLinkDTO;
import tech.przybysz.pms.productsservice.web.rest.util.HeaderUtil;
import tech.przybysz.pms.productsservice.web.rest.util.ResponseUtil;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link tech.przybysz.pms.productsservice.domain.ProductShopLink}.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductShopLinkResource {

    private final Logger log = LoggerFactory.getLogger(ProductShopLinkResource.class);

    private static final String ENTITY_NAME = "productShopLink";

    @Value("${spring.application.name}")
    private String applicationName;

    private final ProductShopLinkService productShopLinkService;

    public ProductShopLinkResource(ProductShopLinkService productShopLinkService) {
        this.productShopLinkService = productShopLinkService;
    }

    @PostMapping("/productShopLinks")
    public ResponseEntity<ProductShopLinkDTO> createProductShopLink(@RequestBody ProductShopLinkDTO productShopLinkDTO) throws URISyntaxException {
        log.debug("REST request to save ProductShopLink : {}", productShopLinkDTO);
        ProductShopLinkDTO result = productShopLinkService.save(productShopLinkDTO);
        return ResponseEntity.created(new URI("/api/productShopLinks/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    @PutMapping("/productShopLinks")
    public ResponseEntity<ProductShopLinkDTO> updateProductShopLink(@RequestBody ProductShopLinkDTO productShopLinkDTO) {
        log.debug("REST request to update ProductShopLink : {}", productShopLinkDTO);
        ProductShopLinkDTO result = productShopLinkService.save(productShopLinkDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, productShopLinkDTO.getId().toString()))
            .body(result);
    }

    @GetMapping("/productShopLinks/{id}")
    public ResponseEntity<ProductShopLinkDTO> getProductShopLink(@PathVariable Long id) {
        log.debug("REST request to get ProductShopLink : {}", id);
        Optional<ProductShopLinkDTO> productShopLinkDTO = productShopLinkService.findOne(id);
        return ResponseUtil.wrapOrNotFound(productShopLinkDTO);
    }

    @DeleteMapping("/productShopLinks/{id}")
    public ResponseEntity<Void> deleteProductShopLink(@PathVariable Long id) {
        log.debug("REST request to delete ProductShopLink : {}", id);
        productShopLinkService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}

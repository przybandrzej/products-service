package tech.przybysz.pms.productsservice.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.przybysz.pms.productsservice.service.ShopService;
import tech.przybysz.pms.productsservice.service.dto.ShopDTO;
import tech.przybysz.pms.productsservice.web.rest.util.HeaderUtil;
import tech.przybysz.pms.productsservice.web.rest.util.ResponseUtil;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link tech.przybysz.pms.productsservice.domain.Shop}.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ShopResource {

    private final Logger log = LoggerFactory.getLogger(ShopResource.class);

    private static final String ENTITY_NAME = "shop";

    @Value("${spring.application.name}")
    private String applicationName;

    private final ShopService shopService;

    public ShopResource(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/shops")
    public ResponseEntity<ShopDTO> createShop(@RequestBody ShopDTO shopDTO) throws URISyntaxException {
        log.debug("REST request to save Shop : {}", shopDTO);
        ShopDTO result = shopService.save(shopDTO);
        return ResponseEntity.created(new URI("/api/shops/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    @PutMapping("/shops")
    public ResponseEntity<ShopDTO> updateShop(@RequestBody ShopDTO shopDTO) {
        log.debug("REST request to update Shop : {}", shopDTO);
        ShopDTO result = shopService.save(shopDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, shopDTO.getId().toString()))
            .body(result);
    }

    @GetMapping("/shops")
    public List<ShopDTO> searchShops(@RequestParam(required = false) String q,
                                     @RequestParam(required = false, defaultValue = "10") int size,
                                     @RequestParam(required = false, defaultValue = "0") int page) {
        log.debug("REST request to get all Shops");
        return shopService.search(q, size, page);
    }

    @GetMapping("/shops/{id}")
    public ResponseEntity<ShopDTO> getShop(@PathVariable Long id) {
        log.debug("REST request to get Shop : {}", id);
        Optional<ShopDTO> shopDTO = shopService.findOne(id);
        return ResponseUtil.wrapOrNotFound(shopDTO);
    }

    @DeleteMapping("/shops/{id}")
    public ResponseEntity<Void> deleteShop(@PathVariable Long id) {
        log.debug("REST request to delete Shop : {}", id);
        shopService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}

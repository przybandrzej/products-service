package tech.przybysz.pms.productsservice.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.przybysz.pms.productsservice.service.CurrencyService;
import tech.przybysz.pms.productsservice.service.dto.CurrencyDTO;
import tech.przybysz.pms.productsservice.web.rest.util.HeaderUtil;
import tech.przybysz.pms.productsservice.web.rest.util.ResponseUtil;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link tech.przybysz.pms.productsservice.domain.Currency}.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class CurrencyResource {

  private final Logger log = LoggerFactory.getLogger(CurrencyResource.class);

  private static final String ENTITY_NAME = "currency";

  @Value("${spring.application.name}")
  private String applicationName;

  private final CurrencyService currencyService;

  public CurrencyResource(CurrencyService currencyService) {
    this.currencyService = currencyService;
  }

  /**
   * {@code POST  /currencys} : Create a new currency.
   *
   * @param currencyDTO the currencyDTO to create.
   * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new currencyDTO, or with status {@code 400 (Bad Request)} if the currency has already an ID.
   * @throws URISyntaxException if the Location URI syntax is incorrect.
   */
  @PostMapping("/currencies")
  public ResponseEntity<CurrencyDTO> createCurrency(@RequestBody CurrencyDTO currencyDTO) throws URISyntaxException {
    log.debug("REST request to save Currency : {}", currencyDTO);
    CurrencyDTO result = currencyService.save(currencyDTO);
    return ResponseEntity.created(new URI("/api/currencies/" + result.getId()))
        .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
        .body(result);
  }

  /**
   * {@code PUT  /currencies} : Updates an existing currency.
   *
   * @param currencyDTO the currencyDTO to update.
   * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated currencyDTO,
   * or with status {@code 400 (Bad Request)} if the currencyDTO is not valid,
   * or with status {@code 500 (Internal Server Error)} if the currencyDTO couldn't be updated.
   * @throws URISyntaxException if the Location URI syntax is incorrect.
   */
  @PutMapping("/currencies")
  public ResponseEntity<CurrencyDTO> updateCurrency(@RequestBody CurrencyDTO currencyDTO) throws URISyntaxException {
    log.debug("REST request to update Currency : {}", currencyDTO);
    CurrencyDTO result = currencyService.save(currencyDTO);
    return ResponseEntity.ok()
        .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, currencyDTO.getId().toString()))
        .body(result);
  }

  /**
   * {@code GET  /currencys} : get all the currencys.
   *
   * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of currencys in body.
   */
  @GetMapping("/currencies")
  public List<CurrencyDTO> getAllCurrencies() {
    log.debug("REST request to get all Currencies");
    return currencyService.findAll();
  }

  /**
   * {@code GET  /currencys/:id} : get the "id" currency.
   *
   * @param id the id of the currencyDTO to retrieve.
   * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the currencyDTO, or with status {@code 404 (Not Found)}.
   */
  @GetMapping("/currencies/{id}")
  public ResponseEntity<CurrencyDTO> getCurrency(@PathVariable Long id) {
    log.debug("REST request to get Currency : {}", id);
    Optional<CurrencyDTO> currencyDTO = currencyService.findOne(id);
    return ResponseUtil.wrapOrNotFound(currencyDTO);
  }

  /**
   * {@code DELETE  /currencys/:id} : delete the "id" currency.
   *
   * @param id the id of the currencyDTO to delete.
   * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
   */
  @DeleteMapping("/currencies/{id}")
  public ResponseEntity<Void> deleteCurrency(@PathVariable Long id) {
    log.debug("REST request to delete Currency : {}", id);
    currencyService.delete(id);
    return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
  }
}

package tech.przybysz.pms.productsservice.service;

import tech.przybysz.pms.productsservice.service.dto.CurrencyDTO;

import java.util.List;
import java.util.Optional;

public interface CurrencyService {

  /**
   * Save a shop.
   *
   * @param currencyDTO the entity to save.
   * @return the persisted entity.
   */
  CurrencyDTO save(CurrencyDTO currencyDTO);

  /**
   * Get all the shops.
   *
   * @return the list of entities.
   */
  List<CurrencyDTO> findAll();


  /**
   * Get the "id" shop.
   *
   * @param id the id of the entity.
   * @return the entity.
   */
  Optional<CurrencyDTO> findOne(Long id);

  /**
   * Delete the "id" shop.
   *
   * @param id the id of the entity.
   */
  void delete(Long id);
}

package tech.przybysz.pms.productsservice.service;

import tech.przybysz.pms.productsservice.service.dto.BrandDTO;

import java.util.List;
import java.util.Optional;

public interface BrandService {

  /**
   * Save a brand.
   *
   * @param brandDTO the entity to save.
   * @return the persisted entity.
   */
  BrandDTO save(BrandDTO brandDTO);

  /**
   * Get all the brands.
   *
   * @return the list of entities.
   */
  List<BrandDTO> findAll();


  /**
   * Get the "id" brand.
   *
   * @param id the id of the entity.
   * @return the entity.
   */
  Optional<BrandDTO> findOne(Long id);

  /**
   * Delete the "id" brand.
   *
   * @param id the id of the entity.
   */
  void delete(Long id);
}

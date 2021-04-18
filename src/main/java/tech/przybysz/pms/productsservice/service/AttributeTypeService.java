package tech.przybysz.pms.productsservice.service;

import tech.przybysz.pms.productsservice.service.dto.AttributeTypeDTO;

import java.util.List;
import java.util.Optional;

public interface AttributeTypeService {

  /**
   * Save a attributeType.
   *
   * @param attributeTypeDTO the entity to save.
   * @return the persisted entity.
   */
  AttributeTypeDTO save(AttributeTypeDTO attributeTypeDTO);

  /**
   * Get all the attributeTypes.
   *
   * @return the list of entities.
   */
  List<AttributeTypeDTO> findAll();


  /**
   * Get the "id" attributeType.
   *
   * @param id the id of the entity.
   * @return the entity.
   */
  Optional<AttributeTypeDTO> findOne(Long id);

  /**
   * Delete the "id" attributeType.
   *
   * @param id the id of the entity.
   */
  void delete(Long id);
}

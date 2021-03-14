package tech.przybysz.pms.service;

import tech.przybysz.pms.service.dto.AttributeDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link tech.przybysz.pms.domain.Attribute}.
 */
public interface AttributeService {

    /**
     * Save a attribute.
     *
     * @param attributeDTO the entity to save.
     * @return the persisted entity.
     */
    AttributeDTO save(AttributeDTO attributeDTO);

    /**
     * Get all the attributes.
     *
     * @return the list of entities.
     */
    List<AttributeDTO> findAll();


    /**
     * Get the "id" attribute.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<AttributeDTO> findOne(Long id);

    /**
     * Delete the "id" attribute.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}

package tech.przybysz.pms.service;

import tech.przybysz.pms.service.dto.AttributeEntryDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link tech.przybysz.pms.domain.AttributeEntry}.
 */
public interface AttributeEntryService {

    /**
     * Save a attributeEntry.
     *
     * @param attributeEntryDTO the entity to save.
     * @return the persisted entity.
     */
    AttributeEntryDTO save(AttributeEntryDTO attributeEntryDTO);

    /**
     * Get all the attributeEntries.
     *
     * @return the list of entities.
     */
    List<AttributeEntryDTO> findAll();


    /**
     * Get the "id" attributeEntry.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<AttributeEntryDTO> findOne(Long id);

    /**
     * Delete the "id" attributeEntry.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}

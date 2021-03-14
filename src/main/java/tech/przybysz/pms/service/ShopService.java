package tech.przybysz.pms.service;

import tech.przybysz.pms.service.dto.ShopDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link tech.przybysz.pms.domain.Shop}.
 */
public interface ShopService {

    /**
     * Save a shop.
     *
     * @param shopDTO the entity to save.
     * @return the persisted entity.
     */
    ShopDTO save(ShopDTO shopDTO);

    /**
     * Get all the shops.
     *
     * @return the list of entities.
     */
    List<ShopDTO> findAll();


    /**
     * Get the "id" shop.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ShopDTO> findOne(Long id);

    /**
     * Delete the "id" shop.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}

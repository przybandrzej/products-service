package tech.przybysz.pms.productsservice.service;

import tech.przybysz.pms.productsservice.service.dto.ShopDTO;

import java.util.List;
import java.util.Optional;

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

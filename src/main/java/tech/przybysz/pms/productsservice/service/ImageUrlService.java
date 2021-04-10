package tech.przybysz.pms.productsservice.service;

import tech.przybysz.pms.productsservice.service.dto.ImageUrlDTO;

import java.util.List;
import java.util.Optional;

public interface ImageUrlService {

    /**
     * Save a imageUrl.
     *
     * @param imageUrlDTO the entity to save.
     * @return the persisted entity.
     */
    ImageUrlDTO save(ImageUrlDTO imageUrlDTO);

    /**
     * Get all the imageUrls.
     *
     * @return the list of entities.
     */
    List<ImageUrlDTO> findAll();


    /**
     * Get the "id" imageUrl.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ImageUrlDTO> findOne(Long id);

    /**
     * Delete the "id" imageUrl.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    List<ImageUrlDTO> findAllOfProduct(Long productId);
}

package tech.przybysz.pms.productsservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tech.przybysz.pms.productsservice.service.dto.ProductDTO;
import tech.przybysz.pms.productsservice.service.dto.fulldata.ProductFDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    /**
     * Save a product.
     *
     * @param productDTO the entity to save.
     * @return the persisted entity.
     */
    ProductDTO save(ProductDTO productDTO);

    /**
     * Get all the products.
     *
     * @return the list of entities.
     */
    List<ProductDTO> findAll();

    /**
     * Get all the products with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    Page<ProductDTO> findAllWithEagerRelationships(Pageable pageable);


    /**
     * Get the "id" product.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ProductDTO> findOne(Long id);

    /**
     * Delete the "id" product.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    Optional<ProductFDTO> findOneWithFullInfo(Long id);
}

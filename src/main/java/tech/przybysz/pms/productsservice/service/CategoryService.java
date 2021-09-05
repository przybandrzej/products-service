package tech.przybysz.pms.productsservice.service;

import tech.przybysz.pms.productsservice.service.dto.CategoryDTO;
import tech.przybysz.pms.productsservice.service.dto.fulldata.CategoryFDTO;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    /**
     * Save a category.
     *
     * @param categoryDTO the entity to save.
     * @return the persisted entity.
     */
    CategoryDTO save(CategoryDTO categoryDTO);

    /**
     * Get all the categories.
     *
     * @return the list of entities.
     */
    List<CategoryDTO> findAll();


    /**
     * Get the "id" category.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CategoryDTO> findOne(Long id);

    /**
     * Delete the "id" category.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);


    Optional<CategoryFDTO> findOneWithFullInfo(Long id);
}

package tech.przybysz.pms.productsservice.web.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.przybysz.pms.productsservice.service.CategoryService;
import tech.przybysz.pms.productsservice.service.dto.CategoryDTO;
import tech.przybysz.pms.productsservice.service.dto.fulldata.CategoryFDTO;
import tech.przybysz.pms.productsservice.web.rest.util.HeaderUtil;
import tech.przybysz.pms.productsservice.web.rest.util.ResponseUtil;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link tech.przybysz.pms.productsservice.domain.Category}.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class CategoryResource {

  private final Logger log = LoggerFactory.getLogger(CategoryResource.class);

  private static final String ENTITY_NAME = "category";

  @Value("${spring.application.name}")
  private String applicationName;

  private final CategoryService categoryService;

  public CategoryResource(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  /**
   * {@code POST  /categories} : Create a new category.
   *
   * @param categoryDTO the categoryDTO to create.
   * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new categoryDTO, or with status {@code 400 (Bad Request)} if the category has already an ID.
   * @throws URISyntaxException if the Location URI syntax is incorrect.
   */
  @PostMapping("/categories")
  public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) throws URISyntaxException {
    log.debug("REST request to save Category : {}", categoryDTO);
    CategoryDTO result = categoryService.save(categoryDTO);
    return ResponseEntity.created(new URI("/api/categories/" + result.getId()))
        .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
        .body(result);
  }

  /**
   * {@code PUT  /categories} : Updates an existing category.
   *
   * @param categoryDTO the categoryDTO to update.
   * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated categoryDTO,
   * or with status {@code 400 (Bad Request)} if the categoryDTO is not valid,
   * or with status {@code 500 (Internal Server Error)} if the categoryDTO couldn't be updated.
   * @throws URISyntaxException if the Location URI syntax is incorrect.
   */
  @PutMapping("/categories")
  public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO) throws URISyntaxException {
    log.debug("REST request to update Category : {}", categoryDTO);
    CategoryDTO result = categoryService.save(categoryDTO);
    return ResponseEntity.ok()
        .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, categoryDTO.getId().toString()))
        .body(result);
  }

  /**
   * {@code GET  /categories} : get all the categories.
   *
   * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of categories in body.
   */
  @GetMapping("/categories")
  public List<CategoryDTO> getAllCategories() {
    log.debug("REST request to get all Categories");
    return categoryService.findAll();
  }

  /**
   * {@code GET  /categories/:id} : get the "id" category.
   *
   * @param id the id of the categoryDTO to retrieve.
   * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the categoryDTO, or with status {@code 404 (Not Found)}.
   */
  @GetMapping("/categories/{id}")
  public ResponseEntity<CategoryDTO> getCategory(@PathVariable Long id) {
    log.debug("REST request to get Category : {}", id);
    Optional<CategoryDTO> categoryDTO = categoryService.findOne(id);
    return ResponseUtil.wrapOrNotFound(categoryDTO);
  }

  /**
   * {@code DELETE  /categories/:id} : delete the "id" category.
   *
   * @param id the id of the categoryDTO to delete.
   * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
   */
  @DeleteMapping("/categories/{id}")
  public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
    log.debug("REST request to delete Category : {}", id);
    categoryService.delete(id);
    return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
  }

  @GetMapping("/categories/{id}/full-info")
  public ResponseEntity<CategoryFDTO> getCategoryFullInfo(@PathVariable Long id) {
    log.debug("REST request to get Category : {}", id);
    Optional<CategoryFDTO> categoryFDTO = categoryService.findOneWithFullInfo(id);
    return ResponseUtil.wrapOrNotFound(categoryFDTO);
  }
}

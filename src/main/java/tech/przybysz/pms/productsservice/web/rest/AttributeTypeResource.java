package tech.przybysz.pms.productsservice.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.przybysz.pms.productsservice.service.AttributeTypeService;
import tech.przybysz.pms.productsservice.service.dto.AttributeTypeDTO;
import tech.przybysz.pms.productsservice.web.rest.util.HeaderUtil;
import tech.przybysz.pms.productsservice.web.rest.util.ResponseUtil;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AttributeTypeResource {

  private final Logger log = LoggerFactory.getLogger(AttributeTypeResource.class);

  private static final String ENTITY_NAME = "attributeType";

  @Value("${spring.application.name}")
  private String applicationName;

  private final AttributeTypeService attributeTypeService;

  public AttributeTypeResource(AttributeTypeService attributeTypeService) {
    this.attributeTypeService = attributeTypeService;
  }

  /**
   * {@code POST  /attribute-types} : Create a new attributeType.
   *
   * @param attributeTypeDTO the attributeTypeDTO to create.
   * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new attributeTypeDTO, or with status {@code 400 (Bad Request)} if the attributeType has already an ID.
   * @throws URISyntaxException if the Location URI syntax is incorrect.
   */
  @PostMapping("/attribute-types")
  public ResponseEntity<AttributeTypeDTO> createAttributeType(@RequestBody AttributeTypeDTO attributeTypeDTO) throws URISyntaxException {
    log.debug("REST request to save AttributeType : {}", attributeTypeDTO);
    AttributeTypeDTO result = attributeTypeService.save(attributeTypeDTO);
    return ResponseEntity.created(new URI("/api/attribute-types/" + result.getId()))
        .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
        .body(result);
  }

  /**
   * {@code PUT  /attribute-types} : Updates an existing attributeType.
   *
   * @param attributeTypeDTO the attributeTypeDTO to update.
   * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated attributeTypeDTO,
   * or with status {@code 400 (Bad Request)} if the attributeTypeDTO is not valid,
   * or with status {@code 500 (Internal Server Error)} if the attributeTypeDTO couldn't be updated.
   * @throws URISyntaxException if the Location URI syntax is incorrect.
   */
  @PutMapping("/attribute-types")
  public ResponseEntity<AttributeTypeDTO> updateAttributeType(@RequestBody AttributeTypeDTO attributeTypeDTO) {
    log.debug("REST request to update AttributeType : {}", attributeTypeDTO);
    AttributeTypeDTO result = attributeTypeService.save(attributeTypeDTO);
    return ResponseEntity.ok()
        .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, attributeTypeDTO.getId().toString()))
        .body(result);
  }

  /**
   * {@code GET  /attribute-types} : get all the attributeTypes.
   *
   * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of attributeTypes in body.
   */
  @GetMapping("/attribute-types")
  public List<AttributeTypeDTO> getAllAttributeTypes() {
    log.debug("REST request to get all AttributeTypes");
    return attributeTypeService.findAll();
  }

  /**
   * {@code GET  /attribute-types/:id} : get the "id" attributeType.
   *
   * @param id the id of the attributeTypeDTO to retrieve.
   * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the attributeTypeDTO, or with status {@code 404 (Not Found)}.
   */
  @GetMapping("/attribute-types/{id}")
  public ResponseEntity<AttributeTypeDTO> getAttributeType(@PathVariable Long id) {
    log.debug("REST request to get AttributeType : {}", id);
    Optional<AttributeTypeDTO> attributeTypeDTO = attributeTypeService.findOne(id);
    return ResponseUtil.wrapOrNotFound(attributeTypeDTO);
  }

  /**
   * {@code DELETE  /attribute-types/:id} : delete the "id" attributeType.
   *
   * @param id the id of the attributeTypeDTO to delete.
   * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
   */
  @DeleteMapping("/attribute-types/{id}")
  public ResponseEntity<Void> deleteAttributeType(@PathVariable Long id) {
    log.debug("REST request to delete AttributeType : {}", id);
    attributeTypeService.delete(id);
    return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
  }
}

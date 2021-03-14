package tech.przybysz.pms.productsservice.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.przybysz.pms.productsservice.service.AttributeEntryService;
import tech.przybysz.pms.productsservice.service.dto.AttributeEntryDTO;
import tech.przybysz.pms.productsservice.web.rest.util.HeaderUtil;
import tech.przybysz.pms.productsservice.web.rest.util.ResponseUtil;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AttributeEntryResource {

    private final Logger log = LoggerFactory.getLogger(AttributeEntryResource.class);

    private static final String ENTITY_NAME = "attributeEntry";

    @Value("${spring.application.name}")
    private String applicationName;

    private final AttributeEntryService attributeEntryService;

    public AttributeEntryResource(AttributeEntryService attributeEntryService) {
        this.attributeEntryService = attributeEntryService;
    }

    /**
     * {@code POST  /attribute-entries} : Create a new attributeEntry.
     *
     * @param attributeEntryDTO the attributeEntryDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new attributeEntryDTO, or with status {@code 400 (Bad Request)} if the attributeEntry has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/attribute-entries")
    public ResponseEntity<AttributeEntryDTO> createAttributeEntry(@RequestBody AttributeEntryDTO attributeEntryDTO) throws URISyntaxException {
        log.debug("REST request to save AttributeEntry : {}", attributeEntryDTO);
        AttributeEntryDTO result = attributeEntryService.save(attributeEntryDTO);
        return ResponseEntity.created(new URI("/api/attribute-entries/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /attribute-entries} : Updates an existing attributeEntry.
     *
     * @param attributeEntryDTO the attributeEntryDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated attributeEntryDTO,
     * or with status {@code 400 (Bad Request)} if the attributeEntryDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the attributeEntryDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/attribute-entries")
    public ResponseEntity<AttributeEntryDTO> updateAttributeEntry(@RequestBody AttributeEntryDTO attributeEntryDTO) {
        log.debug("REST request to update AttributeEntry : {}", attributeEntryDTO);
        AttributeEntryDTO result = attributeEntryService.save(attributeEntryDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, attributeEntryDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /attribute-entries} : get all the attributeEntries.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of attributeEntries in body.
     */
    @GetMapping("/attribute-entries")
    public List<AttributeEntryDTO> getAllAttributeEntries() {
        log.debug("REST request to get all AttributeEntries");
        return attributeEntryService.findAll();
    }

    /**
     * {@code GET  /attribute-entries/:id} : get the "id" attributeEntry.
     *
     * @param id the id of the attributeEntryDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the attributeEntryDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/attribute-entries/{id}")
    public ResponseEntity<AttributeEntryDTO> getAttributeEntry(@PathVariable Long id) {
        log.debug("REST request to get AttributeEntry : {}", id);
        Optional<AttributeEntryDTO> attributeEntryDTO = attributeEntryService.findOne(id);
        return ResponseUtil.wrapOrNotFound(attributeEntryDTO);
    }

    /**
     * {@code DELETE  /attribute-entries/:id} : delete the "id" attributeEntry.
     *
     * @param id the id of the attributeEntryDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/attribute-entries/{id}")
    public ResponseEntity<Void> deleteAttributeEntry(@PathVariable Long id) {
        log.debug("REST request to delete AttributeEntry : {}", id);
        attributeEntryService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}

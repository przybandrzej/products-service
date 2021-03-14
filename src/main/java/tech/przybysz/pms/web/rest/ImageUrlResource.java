package tech.przybysz.pms.web.rest;

import tech.przybysz.pms.service.ImageUrlService;
import tech.przybysz.pms.web.rest.errors.BadRequestAlertException;
import tech.przybysz.pms.service.dto.ImageUrlDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link tech.przybysz.pms.domain.ImageUrl}.
 */
@RestController
@RequestMapping("/api")
public class ImageUrlResource {

    private final Logger log = LoggerFactory.getLogger(ImageUrlResource.class);

    private static final String ENTITY_NAME = "imageUrl";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ImageUrlService imageUrlService;

    public ImageUrlResource(ImageUrlService imageUrlService) {
        this.imageUrlService = imageUrlService;
    }

    /**
     * {@code POST  /image-urls} : Create a new imageUrl.
     *
     * @param imageUrlDTO the imageUrlDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new imageUrlDTO, or with status {@code 400 (Bad Request)} if the imageUrl has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/image-urls")
    public ResponseEntity<ImageUrlDTO> createImageUrl(@RequestBody ImageUrlDTO imageUrlDTO) throws URISyntaxException {
        log.debug("REST request to save ImageUrl : {}", imageUrlDTO);
        if (imageUrlDTO.getId() != null) {
            throw new BadRequestAlertException("A new imageUrl cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ImageUrlDTO result = imageUrlService.save(imageUrlDTO);
        return ResponseEntity.created(new URI("/api/image-urls/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /image-urls} : Updates an existing imageUrl.
     *
     * @param imageUrlDTO the imageUrlDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated imageUrlDTO,
     * or with status {@code 400 (Bad Request)} if the imageUrlDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the imageUrlDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/image-urls")
    public ResponseEntity<ImageUrlDTO> updateImageUrl(@RequestBody ImageUrlDTO imageUrlDTO) throws URISyntaxException {
        log.debug("REST request to update ImageUrl : {}", imageUrlDTO);
        if (imageUrlDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ImageUrlDTO result = imageUrlService.save(imageUrlDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, imageUrlDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /image-urls} : get all the imageUrls.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of imageUrls in body.
     */
    @GetMapping("/image-urls")
    public List<ImageUrlDTO> getAllImageUrls() {
        log.debug("REST request to get all ImageUrls");
        return imageUrlService.findAll();
    }

    /**
     * {@code GET  /image-urls/:id} : get the "id" imageUrl.
     *
     * @param id the id of the imageUrlDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the imageUrlDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/image-urls/{id}")
    public ResponseEntity<ImageUrlDTO> getImageUrl(@PathVariable Long id) {
        log.debug("REST request to get ImageUrl : {}", id);
        Optional<ImageUrlDTO> imageUrlDTO = imageUrlService.findOne(id);
        return ResponseUtil.wrapOrNotFound(imageUrlDTO);
    }

    /**
     * {@code DELETE  /image-urls/:id} : delete the "id" imageUrl.
     *
     * @param id the id of the imageUrlDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/image-urls/{id}")
    public ResponseEntity<Void> deleteImageUrl(@PathVariable Long id) {
        log.debug("REST request to delete ImageUrl : {}", id);
        imageUrlService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}

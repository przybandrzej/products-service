package tech.przybysz.pms.web.rest;

import tech.przybysz.pms.ProductsServiceApp;
import tech.przybysz.pms.config.TestSecurityConfiguration;
import tech.przybysz.pms.domain.ImageUrl;
import tech.przybysz.pms.repository.ImageUrlRepository;
import tech.przybysz.pms.service.ImageUrlService;
import tech.przybysz.pms.service.dto.ImageUrlDTO;
import tech.przybysz.pms.service.mapper.ImageUrlMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link ImageUrlResource} REST controller.
 */
@SpringBootTest(classes = { ProductsServiceApp.class, TestSecurityConfiguration.class })
@AutoConfigureMockMvc
@WithMockUser
public class ImageUrlResourceIT {

    private static final String DEFAULT_URL = "AAAAAAAAAA";
    private static final String UPDATED_URL = "BBBBBBBBBB";

    private static final Float DEFAULT_APPLYING_ORDER = 1F;
    private static final Float UPDATED_APPLYING_ORDER = 2F;

    @Autowired
    private ImageUrlRepository imageUrlRepository;

    @Autowired
    private ImageUrlMapper imageUrlMapper;

    @Autowired
    private ImageUrlService imageUrlService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restImageUrlMockMvc;

    private ImageUrl imageUrl;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ImageUrl createEntity(EntityManager em) {
        ImageUrl imageUrl = new ImageUrl()
            .url(DEFAULT_URL)
            .applyingOrder(DEFAULT_APPLYING_ORDER);
        return imageUrl;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ImageUrl createUpdatedEntity(EntityManager em) {
        ImageUrl imageUrl = new ImageUrl()
            .url(UPDATED_URL)
            .applyingOrder(UPDATED_APPLYING_ORDER);
        return imageUrl;
    }

    @BeforeEach
    public void initTest() {
        imageUrl = createEntity(em);
    }

    @Test
    @Transactional
    public void createImageUrl() throws Exception {
        int databaseSizeBeforeCreate = imageUrlRepository.findAll().size();
        // Create the ImageUrl
        ImageUrlDTO imageUrlDTO = imageUrlMapper.toDto(imageUrl);
        restImageUrlMockMvc.perform(post("/api/image-urls").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(imageUrlDTO)))
            .andExpect(status().isCreated());

        // Validate the ImageUrl in the database
        List<ImageUrl> imageUrlList = imageUrlRepository.findAll();
        assertThat(imageUrlList).hasSize(databaseSizeBeforeCreate + 1);
        ImageUrl testImageUrl = imageUrlList.get(imageUrlList.size() - 1);
        assertThat(testImageUrl.getUrl()).isEqualTo(DEFAULT_URL);
        assertThat(testImageUrl.getApplyingOrder()).isEqualTo(DEFAULT_APPLYING_ORDER);
    }

    @Test
    @Transactional
    public void createImageUrlWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = imageUrlRepository.findAll().size();

        // Create the ImageUrl with an existing ID
        imageUrl.setId(1L);
        ImageUrlDTO imageUrlDTO = imageUrlMapper.toDto(imageUrl);

        // An entity with an existing ID cannot be created, so this API call must fail
        restImageUrlMockMvc.perform(post("/api/image-urls").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(imageUrlDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ImageUrl in the database
        List<ImageUrl> imageUrlList = imageUrlRepository.findAll();
        assertThat(imageUrlList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllImageUrls() throws Exception {
        // Initialize the database
        imageUrlRepository.saveAndFlush(imageUrl);

        // Get all the imageUrlList
        restImageUrlMockMvc.perform(get("/api/image-urls?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(imageUrl.getId().intValue())))
            .andExpect(jsonPath("$.[*].url").value(hasItem(DEFAULT_URL)))
            .andExpect(jsonPath("$.[*].applyingOrder").value(hasItem(DEFAULT_APPLYING_ORDER.doubleValue())));
    }
    
    @Test
    @Transactional
    public void getImageUrl() throws Exception {
        // Initialize the database
        imageUrlRepository.saveAndFlush(imageUrl);

        // Get the imageUrl
        restImageUrlMockMvc.perform(get("/api/image-urls/{id}", imageUrl.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(imageUrl.getId().intValue()))
            .andExpect(jsonPath("$.url").value(DEFAULT_URL))
            .andExpect(jsonPath("$.applyingOrder").value(DEFAULT_APPLYING_ORDER.doubleValue()));
    }
    @Test
    @Transactional
    public void getNonExistingImageUrl() throws Exception {
        // Get the imageUrl
        restImageUrlMockMvc.perform(get("/api/image-urls/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateImageUrl() throws Exception {
        // Initialize the database
        imageUrlRepository.saveAndFlush(imageUrl);

        int databaseSizeBeforeUpdate = imageUrlRepository.findAll().size();

        // Update the imageUrl
        ImageUrl updatedImageUrl = imageUrlRepository.findById(imageUrl.getId()).get();
        // Disconnect from session so that the updates on updatedImageUrl are not directly saved in db
        em.detach(updatedImageUrl);
        updatedImageUrl
            .url(UPDATED_URL)
            .applyingOrder(UPDATED_APPLYING_ORDER);
        ImageUrlDTO imageUrlDTO = imageUrlMapper.toDto(updatedImageUrl);

        restImageUrlMockMvc.perform(put("/api/image-urls").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(imageUrlDTO)))
            .andExpect(status().isOk());

        // Validate the ImageUrl in the database
        List<ImageUrl> imageUrlList = imageUrlRepository.findAll();
        assertThat(imageUrlList).hasSize(databaseSizeBeforeUpdate);
        ImageUrl testImageUrl = imageUrlList.get(imageUrlList.size() - 1);
        assertThat(testImageUrl.getUrl()).isEqualTo(UPDATED_URL);
        assertThat(testImageUrl.getApplyingOrder()).isEqualTo(UPDATED_APPLYING_ORDER);
    }

    @Test
    @Transactional
    public void updateNonExistingImageUrl() throws Exception {
        int databaseSizeBeforeUpdate = imageUrlRepository.findAll().size();

        // Create the ImageUrl
        ImageUrlDTO imageUrlDTO = imageUrlMapper.toDto(imageUrl);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restImageUrlMockMvc.perform(put("/api/image-urls").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(imageUrlDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ImageUrl in the database
        List<ImageUrl> imageUrlList = imageUrlRepository.findAll();
        assertThat(imageUrlList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteImageUrl() throws Exception {
        // Initialize the database
        imageUrlRepository.saveAndFlush(imageUrl);

        int databaseSizeBeforeDelete = imageUrlRepository.findAll().size();

        // Delete the imageUrl
        restImageUrlMockMvc.perform(delete("/api/image-urls/{id}", imageUrl.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<ImageUrl> imageUrlList = imageUrlRepository.findAll();
        assertThat(imageUrlList).hasSize(databaseSizeBeforeDelete - 1);
    }
}

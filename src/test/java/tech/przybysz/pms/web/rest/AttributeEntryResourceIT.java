package tech.przybysz.pms.web.rest;

import tech.przybysz.pms.ProductsServiceApp;
import tech.przybysz.pms.domain.AttributeEntry;
import tech.przybysz.pms.repository.AttributeEntryRepository;
import tech.przybysz.pms.service.AttributeEntryService;
import tech.przybysz.pms.service.dto.AttributeEntryDTO;
import tech.przybysz.pms.service.mapper.AttributeEntryMapper;

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
 * Integration tests for the {@link AttributeEntryResource} REST controller.
 */
@SpringBootTest(classes = { ProductsServiceApp.class, TestSecurityConfiguration.class })
@AutoConfigureMockMvc
@WithMockUser
public class AttributeEntryResourceIT {

    private static final String DEFAULT_VALUE = "AAAAAAAAAA";
    private static final String UPDATED_VALUE = "BBBBBBBBBB";

    @Autowired
    private AttributeEntryRepository attributeEntryRepository;

    @Autowired
    private AttributeEntryMapper attributeEntryMapper;

    @Autowired
    private AttributeEntryService attributeEntryService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restAttributeEntryMockMvc;

    private AttributeEntry attributeEntry;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AttributeEntry createEntity(EntityManager em) {
        AttributeEntry attributeEntry = new AttributeEntry()
            .value(DEFAULT_VALUE);
        return attributeEntry;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AttributeEntry createUpdatedEntity(EntityManager em) {
        AttributeEntry attributeEntry = new AttributeEntry()
            .value(UPDATED_VALUE);
        return attributeEntry;
    }

    @BeforeEach
    public void initTest() {
        attributeEntry = createEntity(em);
    }

    @Test
    @Transactional
    public void createAttributeEntry() throws Exception {
        int databaseSizeBeforeCreate = attributeEntryRepository.findAll().size();
        // Create the AttributeEntry
        AttributeEntryDTO attributeEntryDTO = attributeEntryMapper.toDto(attributeEntry);
        restAttributeEntryMockMvc.perform(post("/api/attribute-entries").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(attributeEntryDTO)))
            .andExpect(status().isCreated());

        // Validate the AttributeEntry in the database
        List<AttributeEntry> attributeEntryList = attributeEntryRepository.findAll();
        assertThat(attributeEntryList).hasSize(databaseSizeBeforeCreate + 1);
        AttributeEntry testAttributeEntry = attributeEntryList.get(attributeEntryList.size() - 1);
        assertThat(testAttributeEntry.getValue()).isEqualTo(DEFAULT_VALUE);
    }

    @Test
    @Transactional
    public void createAttributeEntryWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = attributeEntryRepository.findAll().size();

        // Create the AttributeEntry with an existing ID
        attributeEntry.setId(1L);
        AttributeEntryDTO attributeEntryDTO = attributeEntryMapper.toDto(attributeEntry);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAttributeEntryMockMvc.perform(post("/api/attribute-entries").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(attributeEntryDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AttributeEntry in the database
        List<AttributeEntry> attributeEntryList = attributeEntryRepository.findAll();
        assertThat(attributeEntryList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllAttributeEntries() throws Exception {
        // Initialize the database
        attributeEntryRepository.saveAndFlush(attributeEntry);

        // Get all the attributeEntryList
        restAttributeEntryMockMvc.perform(get("/api/attribute-entries?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(attributeEntry.getId().intValue())))
            .andExpect(jsonPath("$.[*].value").value(hasItem(DEFAULT_VALUE)));
    }

    @Test
    @Transactional
    public void getAttributeEntry() throws Exception {
        // Initialize the database
        attributeEntryRepository.saveAndFlush(attributeEntry);

        // Get the attributeEntry
        restAttributeEntryMockMvc.perform(get("/api/attribute-entries/{id}", attributeEntry.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(attributeEntry.getId().intValue()))
            .andExpect(jsonPath("$.value").value(DEFAULT_VALUE));
    }
    @Test
    @Transactional
    public void getNonExistingAttributeEntry() throws Exception {
        // Get the attributeEntry
        restAttributeEntryMockMvc.perform(get("/api/attribute-entries/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAttributeEntry() throws Exception {
        // Initialize the database
        attributeEntryRepository.saveAndFlush(attributeEntry);

        int databaseSizeBeforeUpdate = attributeEntryRepository.findAll().size();

        // Update the attributeEntry
        AttributeEntry updatedAttributeEntry = attributeEntryRepository.findById(attributeEntry.getId()).get();
        // Disconnect from session so that the updates on updatedAttributeEntry are not directly saved in db
        em.detach(updatedAttributeEntry);
        updatedAttributeEntry
            .value(UPDATED_VALUE);
        AttributeEntryDTO attributeEntryDTO = attributeEntryMapper.toDto(updatedAttributeEntry);

        restAttributeEntryMockMvc.perform(put("/api/attribute-entries").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(attributeEntryDTO)))
            .andExpect(status().isOk());

        // Validate the AttributeEntry in the database
        List<AttributeEntry> attributeEntryList = attributeEntryRepository.findAll();
        assertThat(attributeEntryList).hasSize(databaseSizeBeforeUpdate);
        AttributeEntry testAttributeEntry = attributeEntryList.get(attributeEntryList.size() - 1);
        assertThat(testAttributeEntry.getValue()).isEqualTo(UPDATED_VALUE);
    }

    @Test
    @Transactional
    public void updateNonExistingAttributeEntry() throws Exception {
        int databaseSizeBeforeUpdate = attributeEntryRepository.findAll().size();

        // Create the AttributeEntry
        AttributeEntryDTO attributeEntryDTO = attributeEntryMapper.toDto(attributeEntry);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAttributeEntryMockMvc.perform(put("/api/attribute-entries").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(attributeEntryDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AttributeEntry in the database
        List<AttributeEntry> attributeEntryList = attributeEntryRepository.findAll();
        assertThat(attributeEntryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAttributeEntry() throws Exception {
        // Initialize the database
        attributeEntryRepository.saveAndFlush(attributeEntry);

        int databaseSizeBeforeDelete = attributeEntryRepository.findAll().size();

        // Delete the attributeEntry
        restAttributeEntryMockMvc.perform(delete("/api/attribute-entries/{id}", attributeEntry.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<AttributeEntry> attributeEntryList = attributeEntryRepository.findAll();
        assertThat(attributeEntryList).hasSize(databaseSizeBeforeDelete - 1);
    }
}

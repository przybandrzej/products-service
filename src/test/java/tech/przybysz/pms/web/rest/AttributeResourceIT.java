package tech.przybysz.pms.web.rest;

import tech.przybysz.pms.ProductsServiceApp;
import tech.przybysz.pms.config.TestSecurityConfiguration;
import tech.przybysz.pms.domain.Attribute;
import tech.przybysz.pms.repository.AttributeRepository;
import tech.przybysz.pms.service.AttributeService;
import tech.przybysz.pms.service.dto.AttributeDTO;
import tech.przybysz.pms.service.mapper.AttributeMapper;

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
 * Integration tests for the {@link AttributeResource} REST controller.
 */
@SpringBootTest(classes = { ProductsServiceApp.class, TestSecurityConfiguration.class })
@AutoConfigureMockMvc
@WithMockUser
public class AttributeResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final Boolean DEFAULT_IS_STRING = false;
    private static final Boolean UPDATED_IS_STRING = true;

    private static final Boolean DEFAULT_IS_LONG = false;
    private static final Boolean UPDATED_IS_LONG = true;

    private static final Boolean DEFAULT_IS_DOUBLE = false;
    private static final Boolean UPDATED_IS_DOUBLE = true;

    private static final Boolean DEFAULT_IS_DATE = false;
    private static final Boolean UPDATED_IS_DATE = true;

    private static final Boolean DEFAULT_IS_BOOLEAN = false;
    private static final Boolean UPDATED_IS_BOOLEAN = true;

    @Autowired
    private AttributeRepository attributeRepository;

    @Autowired
    private AttributeMapper attributeMapper;

    @Autowired
    private AttributeService attributeService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restAttributeMockMvc;

    private Attribute attribute;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Attribute createEntity(EntityManager em) {
        Attribute attribute = new Attribute()
            .name(DEFAULT_NAME)
            .isString(DEFAULT_IS_STRING)
            .isLong(DEFAULT_IS_LONG)
            .isDouble(DEFAULT_IS_DOUBLE)
            .isDate(DEFAULT_IS_DATE)
            .isBoolean(DEFAULT_IS_BOOLEAN);
        return attribute;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Attribute createUpdatedEntity(EntityManager em) {
        Attribute attribute = new Attribute()
            .name(UPDATED_NAME)
            .isString(UPDATED_IS_STRING)
            .isLong(UPDATED_IS_LONG)
            .isDouble(UPDATED_IS_DOUBLE)
            .isDate(UPDATED_IS_DATE)
            .isBoolean(UPDATED_IS_BOOLEAN);
        return attribute;
    }

    @BeforeEach
    public void initTest() {
        attribute = createEntity(em);
    }

    @Test
    @Transactional
    public void createAttribute() throws Exception {
        int databaseSizeBeforeCreate = attributeRepository.findAll().size();
        // Create the Attribute
        AttributeDTO attributeDTO = attributeMapper.toDto(attribute);
        restAttributeMockMvc.perform(post("/api/attributes").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(attributeDTO)))
            .andExpect(status().isCreated());

        // Validate the Attribute in the database
        List<Attribute> attributeList = attributeRepository.findAll();
        assertThat(attributeList).hasSize(databaseSizeBeforeCreate + 1);
        Attribute testAttribute = attributeList.get(attributeList.size() - 1);
        assertThat(testAttribute.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testAttribute.isIsString()).isEqualTo(DEFAULT_IS_STRING);
        assertThat(testAttribute.isIsLong()).isEqualTo(DEFAULT_IS_LONG);
        assertThat(testAttribute.isIsDouble()).isEqualTo(DEFAULT_IS_DOUBLE);
        assertThat(testAttribute.isIsDate()).isEqualTo(DEFAULT_IS_DATE);
        assertThat(testAttribute.isIsBoolean()).isEqualTo(DEFAULT_IS_BOOLEAN);
    }

    @Test
    @Transactional
    public void createAttributeWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = attributeRepository.findAll().size();

        // Create the Attribute with an existing ID
        attribute.setId(1L);
        AttributeDTO attributeDTO = attributeMapper.toDto(attribute);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAttributeMockMvc.perform(post("/api/attributes").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(attributeDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Attribute in the database
        List<Attribute> attributeList = attributeRepository.findAll();
        assertThat(attributeList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllAttributes() throws Exception {
        // Initialize the database
        attributeRepository.saveAndFlush(attribute);

        // Get all the attributeList
        restAttributeMockMvc.perform(get("/api/attributes?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(attribute.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].isString").value(hasItem(DEFAULT_IS_STRING.booleanValue())))
            .andExpect(jsonPath("$.[*].isLong").value(hasItem(DEFAULT_IS_LONG.booleanValue())))
            .andExpect(jsonPath("$.[*].isDouble").value(hasItem(DEFAULT_IS_DOUBLE.booleanValue())))
            .andExpect(jsonPath("$.[*].isDate").value(hasItem(DEFAULT_IS_DATE.booleanValue())))
            .andExpect(jsonPath("$.[*].isBoolean").value(hasItem(DEFAULT_IS_BOOLEAN.booleanValue())));
    }
    
    @Test
    @Transactional
    public void getAttribute() throws Exception {
        // Initialize the database
        attributeRepository.saveAndFlush(attribute);

        // Get the attribute
        restAttributeMockMvc.perform(get("/api/attributes/{id}", attribute.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(attribute.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.isString").value(DEFAULT_IS_STRING.booleanValue()))
            .andExpect(jsonPath("$.isLong").value(DEFAULT_IS_LONG.booleanValue()))
            .andExpect(jsonPath("$.isDouble").value(DEFAULT_IS_DOUBLE.booleanValue()))
            .andExpect(jsonPath("$.isDate").value(DEFAULT_IS_DATE.booleanValue()))
            .andExpect(jsonPath("$.isBoolean").value(DEFAULT_IS_BOOLEAN.booleanValue()));
    }
    @Test
    @Transactional
    public void getNonExistingAttribute() throws Exception {
        // Get the attribute
        restAttributeMockMvc.perform(get("/api/attributes/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAttribute() throws Exception {
        // Initialize the database
        attributeRepository.saveAndFlush(attribute);

        int databaseSizeBeforeUpdate = attributeRepository.findAll().size();

        // Update the attribute
        Attribute updatedAttribute = attributeRepository.findById(attribute.getId()).get();
        // Disconnect from session so that the updates on updatedAttribute are not directly saved in db
        em.detach(updatedAttribute);
        updatedAttribute
            .name(UPDATED_NAME)
            .isString(UPDATED_IS_STRING)
            .isLong(UPDATED_IS_LONG)
            .isDouble(UPDATED_IS_DOUBLE)
            .isDate(UPDATED_IS_DATE)
            .isBoolean(UPDATED_IS_BOOLEAN);
        AttributeDTO attributeDTO = attributeMapper.toDto(updatedAttribute);

        restAttributeMockMvc.perform(put("/api/attributes").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(attributeDTO)))
            .andExpect(status().isOk());

        // Validate the Attribute in the database
        List<Attribute> attributeList = attributeRepository.findAll();
        assertThat(attributeList).hasSize(databaseSizeBeforeUpdate);
        Attribute testAttribute = attributeList.get(attributeList.size() - 1);
        assertThat(testAttribute.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testAttribute.isIsString()).isEqualTo(UPDATED_IS_STRING);
        assertThat(testAttribute.isIsLong()).isEqualTo(UPDATED_IS_LONG);
        assertThat(testAttribute.isIsDouble()).isEqualTo(UPDATED_IS_DOUBLE);
        assertThat(testAttribute.isIsDate()).isEqualTo(UPDATED_IS_DATE);
        assertThat(testAttribute.isIsBoolean()).isEqualTo(UPDATED_IS_BOOLEAN);
    }

    @Test
    @Transactional
    public void updateNonExistingAttribute() throws Exception {
        int databaseSizeBeforeUpdate = attributeRepository.findAll().size();

        // Create the Attribute
        AttributeDTO attributeDTO = attributeMapper.toDto(attribute);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAttributeMockMvc.perform(put("/api/attributes").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(attributeDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Attribute in the database
        List<Attribute> attributeList = attributeRepository.findAll();
        assertThat(attributeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAttribute() throws Exception {
        // Initialize the database
        attributeRepository.saveAndFlush(attribute);

        int databaseSizeBeforeDelete = attributeRepository.findAll().size();

        // Delete the attribute
        restAttributeMockMvc.perform(delete("/api/attributes/{id}", attribute.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Attribute> attributeList = attributeRepository.findAll();
        assertThat(attributeList).hasSize(databaseSizeBeforeDelete - 1);
    }
}

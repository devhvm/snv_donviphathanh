package com.manager.donviphathanh.web.rest;

import com.manager.donviphathanh.DonviphathanhApp;

import com.manager.donviphathanh.domain.PhamVi;
import com.manager.donviphathanh.repository.PhamViRepository;
import com.manager.donviphathanh.service.PhamViService;
import com.manager.donviphathanh.service.dto.PhamViDTO;
import com.manager.donviphathanh.service.mapper.PhamViMapper;
import com.manager.donviphathanh.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.util.List;


import static com.manager.donviphathanh.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the PhamViResource REST controller.
 *
 * @see PhamViResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DonviphathanhApp.class)
public class PhamViResourceIntTest {

    private static final String DEFAULT_BEGIN = "AAAAAAAAAA";
    private static final String UPDATED_BEGIN = "BBBBBBBBBB";

    private static final String DEFAULT_END = "AAAAAAAAAA";
    private static final String UPDATED_END = "BBBBBBBBBB";

    @Autowired
    private PhamViRepository phamViRepository;

    @Autowired
    private PhamViMapper phamViMapper;

    @Autowired
    private PhamViService phamViService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restPhamViMockMvc;

    private PhamVi phamVi;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final PhamViResource phamViResource = new PhamViResource(phamViService);
        this.restPhamViMockMvc = MockMvcBuilders.standaloneSetup(phamViResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PhamVi createEntity(EntityManager em) {
        PhamVi phamVi = new PhamVi()
            .begin(DEFAULT_BEGIN)
            .end(DEFAULT_END);
        return phamVi;
    }

    @Before
    public void initTest() {
        phamVi = createEntity(em);
    }

    @Test
    @Transactional
    public void createPhamVi() throws Exception {
        int databaseSizeBeforeCreate = phamViRepository.findAll().size();

        // Create the PhamVi
        PhamViDTO phamViDTO = phamViMapper.toDto(phamVi);
        restPhamViMockMvc.perform(post("/api/pham-vis")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(phamViDTO)))
            .andExpect(status().isCreated());

        // Validate the PhamVi in the database
        List<PhamVi> phamViList = phamViRepository.findAll();
        assertThat(phamViList).hasSize(databaseSizeBeforeCreate + 1);
        PhamVi testPhamVi = phamViList.get(phamViList.size() - 1);
        assertThat(testPhamVi.getBegin()).isEqualTo(DEFAULT_BEGIN);
        assertThat(testPhamVi.getEnd()).isEqualTo(DEFAULT_END);
    }

    @Test
    @Transactional
    public void createPhamViWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = phamViRepository.findAll().size();

        // Create the PhamVi with an existing ID
        phamVi.setId(1L);
        PhamViDTO phamViDTO = phamViMapper.toDto(phamVi);

        // An entity with an existing ID cannot be created, so this API call must fail
        restPhamViMockMvc.perform(post("/api/pham-vis")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(phamViDTO)))
            .andExpect(status().isBadRequest());

        // Validate the PhamVi in the database
        List<PhamVi> phamViList = phamViRepository.findAll();
        assertThat(phamViList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkBeginIsRequired() throws Exception {
        int databaseSizeBeforeTest = phamViRepository.findAll().size();
        // set the field null
        phamVi.setBegin(null);

        // Create the PhamVi, which fails.
        PhamViDTO phamViDTO = phamViMapper.toDto(phamVi);

        restPhamViMockMvc.perform(post("/api/pham-vis")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(phamViDTO)))
            .andExpect(status().isBadRequest());

        List<PhamVi> phamViList = phamViRepository.findAll();
        assertThat(phamViList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkEndIsRequired() throws Exception {
        int databaseSizeBeforeTest = phamViRepository.findAll().size();
        // set the field null
        phamVi.setEnd(null);

        // Create the PhamVi, which fails.
        PhamViDTO phamViDTO = phamViMapper.toDto(phamVi);

        restPhamViMockMvc.perform(post("/api/pham-vis")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(phamViDTO)))
            .andExpect(status().isBadRequest());

        List<PhamVi> phamViList = phamViRepository.findAll();
        assertThat(phamViList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllPhamVis() throws Exception {
        // Initialize the database
        phamViRepository.saveAndFlush(phamVi);

        // Get all the phamViList
        restPhamViMockMvc.perform(get("/api/pham-vis?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(phamVi.getId().intValue())))
            .andExpect(jsonPath("$.[*].begin").value(hasItem(DEFAULT_BEGIN.toString())))
            .andExpect(jsonPath("$.[*].end").value(hasItem(DEFAULT_END.toString())));
    }
    
    @Test
    @Transactional
    public void getPhamVi() throws Exception {
        // Initialize the database
        phamViRepository.saveAndFlush(phamVi);

        // Get the phamVi
        restPhamViMockMvc.perform(get("/api/pham-vis/{id}", phamVi.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(phamVi.getId().intValue()))
            .andExpect(jsonPath("$.begin").value(DEFAULT_BEGIN.toString()))
            .andExpect(jsonPath("$.end").value(DEFAULT_END.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingPhamVi() throws Exception {
        // Get the phamVi
        restPhamViMockMvc.perform(get("/api/pham-vis/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updatePhamVi() throws Exception {
        // Initialize the database
        phamViRepository.saveAndFlush(phamVi);

        int databaseSizeBeforeUpdate = phamViRepository.findAll().size();

        // Update the phamVi
        PhamVi updatedPhamVi = phamViRepository.findById(phamVi.getId()).get();
        // Disconnect from session so that the updates on updatedPhamVi are not directly saved in db
        em.detach(updatedPhamVi);
        updatedPhamVi
            .begin(UPDATED_BEGIN)
            .end(UPDATED_END);
        PhamViDTO phamViDTO = phamViMapper.toDto(updatedPhamVi);

        restPhamViMockMvc.perform(put("/api/pham-vis")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(phamViDTO)))
            .andExpect(status().isOk());

        // Validate the PhamVi in the database
        List<PhamVi> phamViList = phamViRepository.findAll();
        assertThat(phamViList).hasSize(databaseSizeBeforeUpdate);
        PhamVi testPhamVi = phamViList.get(phamViList.size() - 1);
        assertThat(testPhamVi.getBegin()).isEqualTo(UPDATED_BEGIN);
        assertThat(testPhamVi.getEnd()).isEqualTo(UPDATED_END);
    }

    @Test
    @Transactional
    public void updateNonExistingPhamVi() throws Exception {
        int databaseSizeBeforeUpdate = phamViRepository.findAll().size();

        // Create the PhamVi
        PhamViDTO phamViDTO = phamViMapper.toDto(phamVi);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPhamViMockMvc.perform(put("/api/pham-vis")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(phamViDTO)))
            .andExpect(status().isBadRequest());

        // Validate the PhamVi in the database
        List<PhamVi> phamViList = phamViRepository.findAll();
        assertThat(phamViList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deletePhamVi() throws Exception {
        // Initialize the database
        phamViRepository.saveAndFlush(phamVi);

        int databaseSizeBeforeDelete = phamViRepository.findAll().size();

        // Delete the phamVi
        restPhamViMockMvc.perform(delete("/api/pham-vis/{id}", phamVi.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<PhamVi> phamViList = phamViRepository.findAll();
        assertThat(phamViList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PhamVi.class);
        PhamVi phamVi1 = new PhamVi();
        phamVi1.setId(1L);
        PhamVi phamVi2 = new PhamVi();
        phamVi2.setId(phamVi1.getId());
        assertThat(phamVi1).isEqualTo(phamVi2);
        phamVi2.setId(2L);
        assertThat(phamVi1).isNotEqualTo(phamVi2);
        phamVi1.setId(null);
        assertThat(phamVi1).isNotEqualTo(phamVi2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PhamViDTO.class);
        PhamViDTO phamViDTO1 = new PhamViDTO();
        phamViDTO1.setId(1L);
        PhamViDTO phamViDTO2 = new PhamViDTO();
        assertThat(phamViDTO1).isNotEqualTo(phamViDTO2);
        phamViDTO2.setId(phamViDTO1.getId());
        assertThat(phamViDTO1).isEqualTo(phamViDTO2);
        phamViDTO2.setId(2L);
        assertThat(phamViDTO1).isNotEqualTo(phamViDTO2);
        phamViDTO1.setId(null);
        assertThat(phamViDTO1).isNotEqualTo(phamViDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(phamViMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(phamViMapper.fromId(null)).isNull();
    }
}

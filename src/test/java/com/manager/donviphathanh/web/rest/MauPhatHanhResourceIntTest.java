package com.manager.donviphathanh.web.rest;

import com.manager.donviphathanh.DonviphathanhApp;

import com.manager.donviphathanh.domain.MauPhatHanh;
import com.manager.donviphathanh.repository.MauPhatHanhRepository;
import com.manager.donviphathanh.service.MauPhatHanhService;
import com.manager.donviphathanh.service.dto.MauPhatHanhDTO;
import com.manager.donviphathanh.service.mapper.MauPhatHanhMapper;
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

import com.manager.donviphathanh.domain.enumeration.ReportStatus;
/**
 * Test class for the MauPhatHanhResource REST controller.
 *
 * @see MauPhatHanhResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DonviphathanhApp.class)
public class MauPhatHanhResourceIntTest {

    private static final String DEFAULT_MAU_PHAT_HANH_CODE = "AAAAAAAAAA";
    private static final String UPDATED_MAU_PHAT_HANH_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final ReportStatus DEFAULT_STATUS = ReportStatus.NEW;
    private static final ReportStatus UPDATED_STATUS = ReportStatus.ACTIVED;

    @Autowired
    private MauPhatHanhRepository mauPhatHanhRepository;

    @Autowired
    private MauPhatHanhMapper mauPhatHanhMapper;

    @Autowired
    private MauPhatHanhService mauPhatHanhService;

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

    private MockMvc restMauPhatHanhMockMvc;

    private MauPhatHanh mauPhatHanh;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final MauPhatHanhResource mauPhatHanhResource = new MauPhatHanhResource(mauPhatHanhService);
        this.restMauPhatHanhMockMvc = MockMvcBuilders.standaloneSetup(mauPhatHanhResource)
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
    public static MauPhatHanh createEntity(EntityManager em) {
        MauPhatHanh mauPhatHanh = new MauPhatHanh()
            .mauPhatHanhCode(DEFAULT_MAU_PHAT_HANH_CODE)
            .name(DEFAULT_NAME)
            .status(DEFAULT_STATUS);
        return mauPhatHanh;
    }

    @Before
    public void initTest() {
        mauPhatHanh = createEntity(em);
    }

    @Test
    @Transactional
    public void createMauPhatHanh() throws Exception {
        int databaseSizeBeforeCreate = mauPhatHanhRepository.findAll().size();

        // Create the MauPhatHanh
        MauPhatHanhDTO mauPhatHanhDTO = mauPhatHanhMapper.toDto(mauPhatHanh);
        restMauPhatHanhMockMvc.perform(post("/api/mau-phat-hanhs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(mauPhatHanhDTO)))
            .andExpect(status().isCreated());

        // Validate the MauPhatHanh in the database
        List<MauPhatHanh> mauPhatHanhList = mauPhatHanhRepository.findAll();
        assertThat(mauPhatHanhList).hasSize(databaseSizeBeforeCreate + 1);
        MauPhatHanh testMauPhatHanh = mauPhatHanhList.get(mauPhatHanhList.size() - 1);
        assertThat(testMauPhatHanh.getMauPhatHanhCode()).isEqualTo(DEFAULT_MAU_PHAT_HANH_CODE);
        assertThat(testMauPhatHanh.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testMauPhatHanh.getStatus()).isEqualTo(DEFAULT_STATUS);
    }

    @Test
    @Transactional
    public void createMauPhatHanhWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = mauPhatHanhRepository.findAll().size();

        // Create the MauPhatHanh with an existing ID
        mauPhatHanh.setId(1L);
        MauPhatHanhDTO mauPhatHanhDTO = mauPhatHanhMapper.toDto(mauPhatHanh);

        // An entity with an existing ID cannot be created, so this API call must fail
        restMauPhatHanhMockMvc.perform(post("/api/mau-phat-hanhs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(mauPhatHanhDTO)))
            .andExpect(status().isBadRequest());

        // Validate the MauPhatHanh in the database
        List<MauPhatHanh> mauPhatHanhList = mauPhatHanhRepository.findAll();
        assertThat(mauPhatHanhList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkMauPhatHanhCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = mauPhatHanhRepository.findAll().size();
        // set the field null
        mauPhatHanh.setMauPhatHanhCode(null);

        // Create the MauPhatHanh, which fails.
        MauPhatHanhDTO mauPhatHanhDTO = mauPhatHanhMapper.toDto(mauPhatHanh);

        restMauPhatHanhMockMvc.perform(post("/api/mau-phat-hanhs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(mauPhatHanhDTO)))
            .andExpect(status().isBadRequest());

        List<MauPhatHanh> mauPhatHanhList = mauPhatHanhRepository.findAll();
        assertThat(mauPhatHanhList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = mauPhatHanhRepository.findAll().size();
        // set the field null
        mauPhatHanh.setName(null);

        // Create the MauPhatHanh, which fails.
        MauPhatHanhDTO mauPhatHanhDTO = mauPhatHanhMapper.toDto(mauPhatHanh);

        restMauPhatHanhMockMvc.perform(post("/api/mau-phat-hanhs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(mauPhatHanhDTO)))
            .andExpect(status().isBadRequest());

        List<MauPhatHanh> mauPhatHanhList = mauPhatHanhRepository.findAll();
        assertThat(mauPhatHanhList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkStatusIsRequired() throws Exception {
        int databaseSizeBeforeTest = mauPhatHanhRepository.findAll().size();
        // set the field null
        mauPhatHanh.setStatus(null);

        // Create the MauPhatHanh, which fails.
        MauPhatHanhDTO mauPhatHanhDTO = mauPhatHanhMapper.toDto(mauPhatHanh);

        restMauPhatHanhMockMvc.perform(post("/api/mau-phat-hanhs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(mauPhatHanhDTO)))
            .andExpect(status().isBadRequest());

        List<MauPhatHanh> mauPhatHanhList = mauPhatHanhRepository.findAll();
        assertThat(mauPhatHanhList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllMauPhatHanhs() throws Exception {
        // Initialize the database
        mauPhatHanhRepository.saveAndFlush(mauPhatHanh);

        // Get all the mauPhatHanhList
        restMauPhatHanhMockMvc.perform(get("/api/mau-phat-hanhs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(mauPhatHanh.getId().intValue())))
            .andExpect(jsonPath("$.[*].mauPhatHanhCode").value(hasItem(DEFAULT_MAU_PHAT_HANH_CODE.toString())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME.toString())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.toString())));
    }
    
    @Test
    @Transactional
    public void getMauPhatHanh() throws Exception {
        // Initialize the database
        mauPhatHanhRepository.saveAndFlush(mauPhatHanh);

        // Get the mauPhatHanh
        restMauPhatHanhMockMvc.perform(get("/api/mau-phat-hanhs/{id}", mauPhatHanh.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(mauPhatHanh.getId().intValue()))
            .andExpect(jsonPath("$.mauPhatHanhCode").value(DEFAULT_MAU_PHAT_HANH_CODE.toString()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME.toString()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingMauPhatHanh() throws Exception {
        // Get the mauPhatHanh
        restMauPhatHanhMockMvc.perform(get("/api/mau-phat-hanhs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateMauPhatHanh() throws Exception {
        // Initialize the database
        mauPhatHanhRepository.saveAndFlush(mauPhatHanh);

        int databaseSizeBeforeUpdate = mauPhatHanhRepository.findAll().size();

        // Update the mauPhatHanh
        MauPhatHanh updatedMauPhatHanh = mauPhatHanhRepository.findById(mauPhatHanh.getId()).get();
        // Disconnect from session so that the updates on updatedMauPhatHanh are not directly saved in db
        em.detach(updatedMauPhatHanh);
        updatedMauPhatHanh
            .mauPhatHanhCode(UPDATED_MAU_PHAT_HANH_CODE)
            .name(UPDATED_NAME)
            .status(UPDATED_STATUS);
        MauPhatHanhDTO mauPhatHanhDTO = mauPhatHanhMapper.toDto(updatedMauPhatHanh);

        restMauPhatHanhMockMvc.perform(put("/api/mau-phat-hanhs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(mauPhatHanhDTO)))
            .andExpect(status().isOk());

        // Validate the MauPhatHanh in the database
        List<MauPhatHanh> mauPhatHanhList = mauPhatHanhRepository.findAll();
        assertThat(mauPhatHanhList).hasSize(databaseSizeBeforeUpdate);
        MauPhatHanh testMauPhatHanh = mauPhatHanhList.get(mauPhatHanhList.size() - 1);
        assertThat(testMauPhatHanh.getMauPhatHanhCode()).isEqualTo(UPDATED_MAU_PHAT_HANH_CODE);
        assertThat(testMauPhatHanh.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testMauPhatHanh.getStatus()).isEqualTo(UPDATED_STATUS);
    }

    @Test
    @Transactional
    public void updateNonExistingMauPhatHanh() throws Exception {
        int databaseSizeBeforeUpdate = mauPhatHanhRepository.findAll().size();

        // Create the MauPhatHanh
        MauPhatHanhDTO mauPhatHanhDTO = mauPhatHanhMapper.toDto(mauPhatHanh);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restMauPhatHanhMockMvc.perform(put("/api/mau-phat-hanhs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(mauPhatHanhDTO)))
            .andExpect(status().isBadRequest());

        // Validate the MauPhatHanh in the database
        List<MauPhatHanh> mauPhatHanhList = mauPhatHanhRepository.findAll();
        assertThat(mauPhatHanhList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteMauPhatHanh() throws Exception {
        // Initialize the database
        mauPhatHanhRepository.saveAndFlush(mauPhatHanh);

        int databaseSizeBeforeDelete = mauPhatHanhRepository.findAll().size();

        // Delete the mauPhatHanh
        restMauPhatHanhMockMvc.perform(delete("/api/mau-phat-hanhs/{id}", mauPhatHanh.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<MauPhatHanh> mauPhatHanhList = mauPhatHanhRepository.findAll();
        assertThat(mauPhatHanhList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MauPhatHanh.class);
        MauPhatHanh mauPhatHanh1 = new MauPhatHanh();
        mauPhatHanh1.setId(1L);
        MauPhatHanh mauPhatHanh2 = new MauPhatHanh();
        mauPhatHanh2.setId(mauPhatHanh1.getId());
        assertThat(mauPhatHanh1).isEqualTo(mauPhatHanh2);
        mauPhatHanh2.setId(2L);
        assertThat(mauPhatHanh1).isNotEqualTo(mauPhatHanh2);
        mauPhatHanh1.setId(null);
        assertThat(mauPhatHanh1).isNotEqualTo(mauPhatHanh2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(MauPhatHanhDTO.class);
        MauPhatHanhDTO mauPhatHanhDTO1 = new MauPhatHanhDTO();
        mauPhatHanhDTO1.setId(1L);
        MauPhatHanhDTO mauPhatHanhDTO2 = new MauPhatHanhDTO();
        assertThat(mauPhatHanhDTO1).isNotEqualTo(mauPhatHanhDTO2);
        mauPhatHanhDTO2.setId(mauPhatHanhDTO1.getId());
        assertThat(mauPhatHanhDTO1).isEqualTo(mauPhatHanhDTO2);
        mauPhatHanhDTO2.setId(2L);
        assertThat(mauPhatHanhDTO1).isNotEqualTo(mauPhatHanhDTO2);
        mauPhatHanhDTO1.setId(null);
        assertThat(mauPhatHanhDTO1).isNotEqualTo(mauPhatHanhDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(mauPhatHanhMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(mauPhatHanhMapper.fromId(null)).isNull();
    }
}

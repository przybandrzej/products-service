package tech.przybysz.pms.productsservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.przybysz.pms.productsservice.domain.Category;
import tech.przybysz.pms.productsservice.repository.CategoryRepository;
import tech.przybysz.pms.productsservice.service.CategoryService;
import tech.przybysz.pms.productsservice.service.dto.CategoryDTO;
import tech.przybysz.pms.productsservice.service.dto.fulldata.CategoryFDTO;
import tech.przybysz.pms.productsservice.service.mapper.CategoryMapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Category}.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        log.debug("Request to save Category : {}", categoryDTO);
        Category category = categoryMapper.toEntity(categoryDTO);
        category = categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        log.debug("Request to get all Categories");
        return categoryRepository.findAll().stream()
            .map(categoryMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<CategoryDTO> findOne(Long id) {
        log.debug("Request to get Category : {}", id);
        return categoryRepository.findById(id)
            .map(categoryMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Category : {}", id);
        categoryRepository.deleteById(id);
    }

    @Override
    public Optional<CategoryFDTO> findOneWithFullInfo(Long id) {
        return categoryRepository.findById(id).map(categoryMapper::toFDto);
    }
}

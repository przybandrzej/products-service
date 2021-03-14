package tech.przybysz.pms.productsservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.przybysz.pms.productsservice.domain.Brand;
import tech.przybysz.pms.productsservice.repository.BrandRepository;
import tech.przybysz.pms.productsservice.service.BrandService;
import tech.przybysz.pms.productsservice.service.dto.BrandDTO;
import tech.przybysz.pms.productsservice.service.mapper.BrandMapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Brand}.
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService {

    private final Logger log = LoggerFactory.getLogger(BrandServiceImpl.class);

    private final BrandRepository brandRepository;

    private final BrandMapper brandMapper;

    public BrandServiceImpl(BrandRepository brandRepository, BrandMapper brandMapper) {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }

    @Override
    public BrandDTO save(BrandDTO brandDTO) {
        log.debug("Request to save Brand : {}", brandDTO);
        Brand brand = brandMapper.toEntity(brandDTO);
        brand = brandRepository.save(brand);
        return brandMapper.toDto(brand);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BrandDTO> findAll() {
        log.debug("Request to get all Brands");
        return brandRepository.findAll().stream()
            .map(brandMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<BrandDTO> findOne(Long id) {
        log.debug("Request to get Brand : {}", id);
        return brandRepository.findById(id)
            .map(brandMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Brand : {}", id);
        brandRepository.deleteById(id);
    }
}

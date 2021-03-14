package tech.przybysz.pms.productsservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.przybysz.pms.productsservice.domain.AttributeEntry;
import tech.przybysz.pms.productsservice.repository.AttributeEntryRepository;
import tech.przybysz.pms.productsservice.service.AttributeEntryService;
import tech.przybysz.pms.productsservice.service.dto.AttributeEntryDTO;
import tech.przybysz.pms.productsservice.service.mapper.AttributeEntryMapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link AttributeEntry}.
 */
@Service
@Transactional
public class AttributeEntryServiceImpl implements AttributeEntryService {

    private final Logger log = LoggerFactory.getLogger(AttributeEntryServiceImpl.class);

    private final AttributeEntryRepository attributeEntryRepository;

    private final AttributeEntryMapper attributeEntryMapper;

    public AttributeEntryServiceImpl(AttributeEntryRepository attributeEntryRepository, AttributeEntryMapper attributeEntryMapper) {
        this.attributeEntryRepository = attributeEntryRepository;
        this.attributeEntryMapper = attributeEntryMapper;
    }

    @Override
    public AttributeEntryDTO save(AttributeEntryDTO attributeEntryDTO) {
        log.debug("Request to save AttributeEntry : {}", attributeEntryDTO);
        AttributeEntry attributeEntry = attributeEntryMapper.toEntity(attributeEntryDTO);
        attributeEntry = attributeEntryRepository.save(attributeEntry);
        return attributeEntryMapper.toDto(attributeEntry);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AttributeEntryDTO> findAll() {
        log.debug("Request to get all AttributeEntries");
        return attributeEntryRepository.findAll().stream()
            .map(attributeEntryMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<AttributeEntryDTO> findOne(Long id) {
        log.debug("Request to get AttributeEntry : {}", id);
        return attributeEntryRepository.findById(id)
            .map(attributeEntryMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete AttributeEntry : {}", id);
        attributeEntryRepository.deleteById(id);
    }
}

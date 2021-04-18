package tech.przybysz.pms.productsservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.przybysz.pms.productsservice.domain.AttributeType;
import tech.przybysz.pms.productsservice.repository.AttributeTypeRepository;
import tech.przybysz.pms.productsservice.service.AttributeTypeService;
import tech.przybysz.pms.productsservice.service.dto.AttributeTypeDTO;
import tech.przybysz.pms.productsservice.service.mapper.AttributeTypeMapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link AttributeType}.
 */
@Service
@Transactional
public class AttributeTypeServiceImpl implements AttributeTypeService {

  private final Logger log = LoggerFactory.getLogger(AttributeTypeServiceImpl.class);

  private final AttributeTypeRepository attributeTypeRepository;

  private final AttributeTypeMapper attributeTypeMapper;

  public AttributeTypeServiceImpl(AttributeTypeRepository attributeTypeRepository, AttributeTypeMapper attributeTypeMapper) {
    this.attributeTypeRepository = attributeTypeRepository;
    this.attributeTypeMapper = attributeTypeMapper;
  }

  @Override
  public AttributeTypeDTO save(AttributeTypeDTO attributeTypeDTO) {
    log.debug("Request to save AttributeType : {}", attributeTypeDTO);
    AttributeType attributeType = attributeTypeMapper.toEntity(attributeTypeDTO);
    attributeType = attributeTypeRepository.save(attributeType);
    return attributeTypeMapper.toDto(attributeType);
  }

  @Override
  @Transactional(readOnly = true)
  public List<AttributeTypeDTO> findAll() {
    log.debug("Request to get all AttributeTypes");
    return attributeTypeRepository.findAll().stream()
        .map(attributeTypeMapper::toDto)
        .collect(Collectors.toCollection(LinkedList::new));
  }


  @Override
  @Transactional(readOnly = true)
  public Optional<AttributeTypeDTO> findOne(Long id) {
    log.debug("Request to get AttributeType : {}", id);
    return attributeTypeRepository.findById(id)
        .map(attributeTypeMapper::toDto);
  }

  @Override
  public void delete(Long id) {
    log.debug("Request to delete AttributeType : {}", id);
    attributeTypeRepository.deleteById(id);
  }
}

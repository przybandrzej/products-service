package tech.przybysz.pms.productsservice.service.mapper;


import org.mapstruct.Mapper;
import tech.przybysz.pms.productsservice.domain.AttributeType;
import tech.przybysz.pms.productsservice.service.dto.AttributeTypeDTO;

/**
 * Mapper for the entity {@link AttributeType} and its DTO {@link AttributeTypeDTO}.
 */
@Mapper(componentModel = "spring", uses = {UnitMapper.class})
public interface AttributeTypeMapper extends EntityMapper<AttributeTypeDTO, AttributeType> {

  AttributeTypeDTO toDto(AttributeType attributeType);

  AttributeType toEntity(AttributeTypeDTO attributeTypeDTO);

  default AttributeType fromId(Long id) {
    if(id == null) {
      return null;
    }
    AttributeType attributeType = new AttributeType();
    attributeType.setId(id);
    return attributeType;
  }
}

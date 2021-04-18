package tech.przybysz.pms.productsservice.service.mapper;


import org.mapstruct.Mapper;
import tech.przybysz.pms.productsservice.domain.Attribute;
import tech.przybysz.pms.productsservice.service.dto.AttributeDTO;

/**
 * Mapper for the entity {@link Attribute} and its DTO {@link AttributeDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AttributeMapper extends EntityMapper<AttributeDTO, Attribute> {

  AttributeDTO toDto(Attribute attribute);

  Attribute toEntity(AttributeDTO attributeDTO);

  default Attribute fromId(Long id) {
    if(id == null) {
      return null;
    }
    Attribute attribute = new Attribute();
    attribute.setId(id);
    return attribute;
  }
}

package tech.przybysz.pms.productsservice.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.przybysz.pms.productsservice.domain.Attribute;
import tech.przybysz.pms.productsservice.service.dto.AttributeDTO;
import tech.przybysz.pms.productsservice.service.dto.fulldata.AttributeFDTO;

/**
 * Mapper for the entity {@link Attribute} and its DTO {@link AttributeDTO}.
 */
@Mapper(componentModel = "spring", uses = {AttributeTypeMapper.class})
public interface AttributeMapper extends EntityMapper<AttributeDTO, Attribute> {

  @Mapping(source = "attributeType.id", target = "attributeTypeId")
  AttributeDTO toDto(Attribute attribute);

  @Mapping(source = "attributeTypeId", target = "attributeType")
  @Mapping(target = "categories", ignore = true)
  Attribute toEntity(AttributeDTO attributeDTO);

  AttributeFDTO toFDto(Attribute attribute);

  default Attribute fromId(Long id) {
    if(id == null) {
      return null;
    }
    Attribute attribute = new Attribute();
    attribute.setId(id);
    return attribute;
  }
}

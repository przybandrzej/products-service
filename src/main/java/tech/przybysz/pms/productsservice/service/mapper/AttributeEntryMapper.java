package tech.przybysz.pms.productsservice.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.przybysz.pms.productsservice.domain.AttributeEntry;
import tech.przybysz.pms.productsservice.service.dto.AttributeEntryDTO;
import tech.przybysz.pms.productsservice.service.dto.fulldata.AttributeEntryFDTO;

/**
 * Mapper for the entity {@link AttributeEntry} and its DTO {@link AttributeEntryDTO}.
 */
@Mapper(componentModel = "spring", uses = {AttributeMapper.class, ProductMapper.class})
public interface AttributeEntryMapper extends EntityMapper<AttributeEntryDTO, AttributeEntry> {

  @Mapping(source = "product.id", target = "productId")
  @Mapping(source = "attribute.id", target = "attributeId")
  AttributeEntryDTO toDto(AttributeEntry attributeEntry);

  @Mapping(source = "attributeId", target = "attribute")
  @Mapping(source = "productId", target = "product")
  AttributeEntry toEntity(AttributeEntryDTO attributeEntryDTO);

  @Mapping(source = "product.id", target = "productId")
  AttributeEntryFDTO toFDto(AttributeEntry attributeEntry);

  default AttributeEntry fromId(Long id) {
    if(id == null) {
      return null;
    }
    AttributeEntry attributeEntry = new AttributeEntry();
    attributeEntry.setId(id);
    return attributeEntry;
  }
}

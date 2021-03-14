package tech.przybysz.pms.productsservice.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.przybysz.pms.productsservice.domain.*;
import tech.przybysz.pms.productsservice.domain.AttributeEntry;
import tech.przybysz.pms.productsservice.service.dto.AttributeEntryDTO;

/**
 * Mapper for the entity {@link AttributeEntry} and its DTO {@link AttributeEntryDTO}.
 */
@Mapper(componentModel = "spring", uses = {AttributeMapper.class})
public interface AttributeEntryMapper extends EntityMapper<AttributeEntryDTO, AttributeEntry> {

    @Mapping(source = "attribute.id", target = "attributeId")
    AttributeEntryDTO toDto(AttributeEntry attributeEntry);

    @Mapping(source = "attributeId", target = "attribute")
    @Mapping(target = "products", ignore = true)
    @Mapping(target = "removeProduct", ignore = true)
    AttributeEntry toEntity(AttributeEntryDTO attributeEntryDTO);

    default AttributeEntry fromId(Long id) {
        if (id == null) {
            return null;
        }
        AttributeEntry attributeEntry = new AttributeEntry();
        attributeEntry.setId(id);
        return attributeEntry;
    }
}

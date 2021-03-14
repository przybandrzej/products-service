package tech.przybysz.pms.service.mapper;


import tech.przybysz.pms.domain.*;
import tech.przybysz.pms.service.dto.AttributeEntryDTO;

import org.mapstruct.*;

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

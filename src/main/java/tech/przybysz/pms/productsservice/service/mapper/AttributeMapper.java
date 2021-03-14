package tech.przybysz.pms.productsservice.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.przybysz.pms.productsservice.domain.*;
import tech.przybysz.pms.productsservice.service.dto.AttributeDTO;

/**
 * Mapper for the entity {@link Attribute} and its DTO {@link AttributeDTO}.
 */
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface AttributeMapper extends EntityMapper<AttributeDTO, Attribute> {

    @Mapping(source = "category.id", target = "categoryId")
    AttributeDTO toDto(Attribute attribute);

    @Mapping(source = "categoryId", target = "category")
    Attribute toEntity(AttributeDTO attributeDTO);

    default Attribute fromId(Long id) {
        if (id == null) {
            return null;
        }
        Attribute attribute = new Attribute();
        attribute.setId(id);
        return attribute;
    }
}

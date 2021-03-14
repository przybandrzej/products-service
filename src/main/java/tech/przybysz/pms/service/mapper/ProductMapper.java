package tech.przybysz.pms.service.mapper;


import tech.przybysz.pms.domain.*;
import tech.przybysz.pms.service.dto.ProductDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Product} and its DTO {@link ProductDTO}.
 */
@Mapper(componentModel = "spring", uses = {BrandMapper.class, CategoryMapper.class, AttributeEntryMapper.class, ShopMapper.class})
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {

    @Mapping(source = "brand.id", target = "brandId")
    ProductDTO toDto(Product product);

    @Mapping(source = "brandId", target = "brand")
    @Mapping(target = "removeCategory", ignore = true)
    @Mapping(target = "removeAttributeEntry", ignore = true)
    @Mapping(target = "removeShop", ignore = true)
    Product toEntity(ProductDTO productDTO);

    default Product fromId(Long id) {
        if (id == null) {
            return null;
        }
        Product product = new Product();
        product.setId(id);
        return product;
    }
}

package tech.przybysz.pms.productsservice.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.przybysz.pms.productsservice.domain.*;
import tech.przybysz.pms.productsservice.service.dto.ShopDTO;

/**
 * Mapper for the entity {@link Shop} and its DTO {@link ShopDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ShopMapper extends EntityMapper<ShopDTO, Shop> {


    @Mapping(target = "products", ignore = true)
    @Mapping(target = "removeProduct", ignore = true)
    Shop toEntity(ShopDTO shopDTO);

    default Shop fromId(Long id) {
        if (id == null) {
            return null;
        }
        Shop shop = new Shop();
        shop.setId(id);
        return shop;
    }
}

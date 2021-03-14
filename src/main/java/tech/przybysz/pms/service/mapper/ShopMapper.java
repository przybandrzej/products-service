package tech.przybysz.pms.service.mapper;


import tech.przybysz.pms.domain.*;
import tech.przybysz.pms.service.dto.ShopDTO;

import org.mapstruct.*;

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

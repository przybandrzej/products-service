package tech.przybysz.pms.productsservice.service.mapper;


import org.mapstruct.Mapper;
import tech.przybysz.pms.productsservice.domain.Shop;
import tech.przybysz.pms.productsservice.service.dto.ShopDTO;

/**
 * Mapper for the entity {@link Shop} and its DTO {@link ShopDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ShopMapper extends EntityMapper<ShopDTO, Shop> {

  ShopDTO toDto(Shop shop);

  Shop toEntity(ShopDTO shopDTO);

  default Shop fromId(Long id) {
    if(id == null) {
      return null;
    }
    Shop shop = new Shop();
    shop.setId(id);
    return shop;
  }
}

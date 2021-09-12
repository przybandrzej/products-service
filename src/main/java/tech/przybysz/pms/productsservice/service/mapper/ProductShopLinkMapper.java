package tech.przybysz.pms.productsservice.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.przybysz.pms.productsservice.domain.Product;
import tech.przybysz.pms.productsservice.domain.ProductShopLink;
import tech.przybysz.pms.productsservice.service.dto.ProductDTO;
import tech.przybysz.pms.productsservice.service.dto.ProductShopLinkDTO;
import tech.przybysz.pms.productsservice.service.dto.fulldata.ProductShopFDTO;

/**
 * Mapper for the entity {@link Product} and its DTO {@link ProductDTO}.
 */
@Mapper(componentModel = "spring", uses = {ShopMapper.class, ProductMapper.class, CurrencyMapper.class})
public interface ProductShopLinkMapper extends EntityMapper<ProductShopLinkDTO, ProductShopLink> {

  @Mapping(source = "product.id", target = "productId")
  @Mapping(source = "shop.id", target = "shopId")
  @Mapping(source = "currency.id", target = "currencyId")
  ProductShopLinkDTO toDto(ProductShopLink product);

  @Mapping(source = "productId", target = "product")
  @Mapping(source = "shopId", target = "shop")
  @Mapping(source = "currencyId", target = "currency")
  ProductShopLink toEntity(ProductShopLinkDTO productDTO);

  @Mapping(source = "product.id", target = "productId")
  @Mapping(source = "shop.id", target = "shopId")
  @Mapping(source = "currency.id", target = "currencyId")
  @Mapping(source = "id", target = "linkId")
  ProductShopFDTO toFDto(ProductShopLink link);

  default ProductShopLink fromId(Long id) {
    if(id == null) {
      return null;
    }
    ProductShopLink product = new ProductShopLink();
    product.setId(id);
    return product;
  }
}

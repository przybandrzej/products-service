package tech.przybysz.pms.productsservice.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.przybysz.pms.productsservice.domain.Product;
import tech.przybysz.pms.productsservice.service.dto.ProductDTO;

/**
 * Mapper for the entity {@link Product} and its DTO {@link ProductDTO}.
 */
@Mapper(componentModel = "spring", uses = {BrandMapper.class, CategoryMapper.class, CurrencyMapper.class,
    ShopMapper.class, ImageUrlMapper.class, AttributeEntryMapper.class})
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {

  @Mapping(source = "brand.id", target = "brandId")
  @Mapping(source = "brand.name", target = "brandName")
  @Mapping(source = "currency.id", target = "currencyId")
  @Mapping(source = "currency.symbol", target = "currencySymbol")
  @Mapping(source = "previewImage.id", target = "previewImageId")
  @Mapping(source = "previewImage.url", target = "previewImageUrl")
  ProductDTO toDto(Product product);

  @Mapping(source = "brandId", target = "brand")
  @Mapping(source = "currencyId", target = "currency")
  @Mapping(source = "previewImageId", target = "previewImage")
  @Mapping(target = "removeCategory", ignore = true)
  @Mapping(target = "removeAttributeEntry", ignore = true)
  @Mapping(target = "removeShop", ignore = true)
  Product toEntity(ProductDTO productDTO);

  default Product fromId(Long id) {
    if(id == null) {
      return null;
    }
    Product product = new Product();
    product.setId(id);
    return product;
  }
}

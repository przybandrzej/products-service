package tech.przybysz.pms.productsservice.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.przybysz.pms.productsservice.domain.Product;
import tech.przybysz.pms.productsservice.domain.ProductShopLink;
import tech.przybysz.pms.productsservice.service.dto.ProductDTO;
import tech.przybysz.pms.productsservice.service.dto.fulldata.ProductFDTO;

import java.util.List;

/**
 * Mapper for the entity {@link Product} and its DTO {@link ProductDTO}.
 */
@Mapper(componentModel = "spring", uses = {BrandMapper.class, CategoryMapper.class, CurrencyMapper.class,
    ShopMapper.class, ImageUrlMapper.class, AttributeEntryMapper.class, ProductShopLinkMapper.class})
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {

  @Mapping(source = "brand.id", target = "brandId")
  @Mapping(source = "brand.name", target = "brandName")
  @Mapping(source = "previewImage.id", target = "previewImageId")
  @Mapping(source = "previewImage.url", target = "previewImageUrl")
  @Mapping(source = "category.id", target = "categoryId")
  @Mapping(source = "category.name", target = "categoryName")
  ProductDTO toDto(Product product);

  @Mapping(source = "brandId", target = "brand")
  @Mapping(source = "previewImageId", target = "previewImage")
  @Mapping(source = "categoryId", target = "category")
  @Mapping(target = "attributeEntries", ignore = true)
  Product toEntity(ProductDTO productDTO);

  @Mapping(source = "product.brand.id", target = "brandId")
  @Mapping(source = "product.brand.name", target = "brandName")
  @Mapping(source = "product.previewImage.id", target = "previewImageId")
  @Mapping(source = "product.previewImage.url", target = "previewImageUrl")
  @Mapping(source = "product.category.id", target = "categoryId")
  @Mapping(source = "product.category.name", target = "categoryName")
  @Mapping(source = "shops", target = "shops")
  ProductFDTO toFDto(Product product, List<ProductShopLink> shops);

  default Product fromId(Long id) {
    if(id == null) {
      return null;
    }
    Product product = new Product();
    product.setId(id);
    return product;
  }
}

package tech.przybysz.pms.productsservice.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.przybysz.pms.productsservice.domain.Product;
import tech.przybysz.pms.productsservice.domain.ProductProductsListLink;
import tech.przybysz.pms.productsservice.domain.ProductShopLink;
import tech.przybysz.pms.productsservice.service.dto.ProductDTO;
import tech.przybysz.pms.productsservice.service.dto.ProductProductsListLinkDTO;
import tech.przybysz.pms.productsservice.service.dto.fulldata.ProductProductsListFDTO;

import java.util.List;

/**
 * Mapper for the entity {@link Product} and its DTO {@link ProductDTO}.
 */
@Mapper(componentModel = "spring", uses = {ProductMapper.class, ProductListMapper.class, ProductShopLinkMapper.class})
public interface ProductProductsListLinkMapper extends EntityMapper<ProductProductsListLinkDTO, ProductProductsListLink> {

  @Mapping(source = "product.id", target = "productId")
  @Mapping(source = "list.id", target = "listId")
  ProductProductsListLinkDTO toDto(ProductProductsListLink product);

  @Mapping(source = "productId", target = "product")
  @Mapping(source = "listId", target = "list")
  ProductProductsListLink toEntity(ProductProductsListLinkDTO productDTO);

  @Mapping(source = "link.id", target = "id")
  @Mapping(source = "link.order", target = "order")
  @Mapping(source = "link.note", target = "note")
  @Mapping(source = "link.product", target = "product")
  @Mapping(source = "shops", target = "product.shops")
  ProductProductsListFDTO toFDto(ProductProductsListLink link, List<ProductShopLink> shops);

  default ProductProductsListLink fromId(Long id) {
    if(id == null) {
      return null;
    }
    ProductProductsListLink product = new ProductProductsListLink();
    product.setId(id);
    return product;
  }
}

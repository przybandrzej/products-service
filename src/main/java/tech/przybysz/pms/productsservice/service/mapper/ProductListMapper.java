package tech.przybysz.pms.productsservice.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.przybysz.pms.productsservice.domain.Product;
import tech.przybysz.pms.productsservice.domain.ProductsList;
import tech.przybysz.pms.productsservice.service.dto.ProductDTO;
import tech.przybysz.pms.productsservice.service.dto.ProductsListDTO;
import tech.przybysz.pms.productsservice.service.dto.fulldata.ProductProductsListFDTO;
import tech.przybysz.pms.productsservice.service.dto.fulldata.ProductsListFDTO;

import java.util.List;

/**
 * Mapper for the entity {@link Product} and its DTO {@link ProductDTO}.
 */
@Mapper(componentModel = "spring", uses = {ProductProductsListLinkMapper.class})
public interface ProductListMapper extends EntityMapper<ProductsListDTO, ProductsList> {

  ProductsListDTO toDto(ProductsList product);

  ProductsList toEntity(ProductsListDTO productDTO);

  @Mapping(source = "list.id", target = "id")
  @Mapping(source = "list.avatar", target = "avatar")
  @Mapping(source = "list.avatarContentType", target = "avatarContentType")
  @Mapping(source = "list.description", target = "description")
  @Mapping(source = "products", target = "products")
  ProductsListFDTO toFDto(ProductsList list, List<ProductProductsListFDTO> products);

  default ProductsList fromId(Long id) {
    if(id == null) {
      return null;
    }
    ProductsList product = new ProductsList();
    product.setId(id);
    return product;
  }
}

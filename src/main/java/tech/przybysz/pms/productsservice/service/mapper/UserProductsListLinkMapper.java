package tech.przybysz.pms.productsservice.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.przybysz.pms.productsservice.domain.Product;
import tech.przybysz.pms.productsservice.domain.UserProductsListLink;
import tech.przybysz.pms.productsservice.service.dto.ProductDTO;
import tech.przybysz.pms.productsservice.service.dto.UserProductsListLinkDTO;

/**
 * Mapper for the entity {@link Product} and its DTO {@link ProductDTO}.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class, ProductListMapper.class})
public interface UserProductsListLinkMapper extends EntityMapper<UserProductsListLinkDTO, UserProductsListLink> {

  @Mapping(source = "user.id", target = "userId")
  @Mapping(source = "list.id", target = "listId")
  UserProductsListLinkDTO toDto(UserProductsListLink product);

  @Mapping(source = "userId", target = "user")
  @Mapping(source = "listId", target = "list")
  UserProductsListLink toEntity(UserProductsListLinkDTO productDTO);


  default UserProductsListLink fromId(Long id) {
    if(id == null) {
      return null;
    }
    UserProductsListLink product = new UserProductsListLink();
    product.setId(id);
    return product;
  }
}

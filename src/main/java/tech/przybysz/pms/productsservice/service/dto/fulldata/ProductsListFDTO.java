package tech.przybysz.pms.productsservice.service.dto.fulldata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsListFDTO {
  private Long id;
  private byte[] avatar;
  private String avatarContentType;
  private String description;
  private List<ProductProductsListFDTO> products = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public byte[] getAvatar() {
    return avatar;
  }

  public void setAvatar(byte[] avatar) {
    this.avatar = avatar;
  }

  public String getAvatarContentType() {
    return avatarContentType;
  }

  public void setAvatarContentType(String avatarContentType) {
    this.avatarContentType = avatarContentType;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<ProductProductsListFDTO> getProducts() {
    return products;
  }

  public void setProducts(List<ProductProductsListFDTO> products) {
    this.products = products;
  }

  @Override
  public String toString() {
    return "ProductsListFDTO{" +
        "id=" + id +
        ", avatar=" + Arrays.toString(avatar) +
        ", avatarContentType='" + avatarContentType + '\'' +
        ", description='" + description + '\'' +
        ", products=" + products +
        '}';
  }
}

package tech.przybysz.pms.productsservice.service.dto;

import java.util.Arrays;

public class ProductsListDTO {
  private Long id;
  private byte[] avatar;
  private String avatarContentType;
  private String description;

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

  @Override
  public String toString() {
    return "ProductsListDTO{" +
        "id=" + id +
        ", avatar=" + Arrays.toString(avatar) +
        ", avatarContentType='" + avatarContentType + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}

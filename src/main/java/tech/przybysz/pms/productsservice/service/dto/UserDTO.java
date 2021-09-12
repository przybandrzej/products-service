package tech.przybysz.pms.productsservice.service.dto;

import java.util.Arrays;

public class UserDTO {

  private Long id;
  private String username;
  private byte[] avatar;
  private String avatarContentType;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
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

  @Override
  public String toString() {
    return "UserDTO{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", avatar=" + Arrays.toString(avatar) +
        ", avatarContentType='" + avatarContentType + '\'' +
        '}';
  }
}

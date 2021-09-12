package tech.przybysz.pms.productsservice.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="products_list")
public class ProductsList implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
  @SequenceGenerator(name = "sequenceGenerator")
  private Long id;

  @Lob
  @Column(name = "avatar")
  private byte[] avatar;

  @Column(name = "avatar_content_type")
  private String avatarContentType;

  @Column(name = "description")
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
  public boolean equals(Object o) {
    if(this == o) {
      return true;
    }
    if(!(o instanceof ProductsList)) {
      return false;
    }
    return id != null && id.equals(((ProductsList) o).id);
  }

  @Override
  public int hashCode() {
    return 31;
  }
}

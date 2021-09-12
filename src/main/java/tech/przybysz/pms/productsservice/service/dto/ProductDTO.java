package tech.przybysz.pms.productsservice.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link tech.przybysz.pms.productsservice.domain.Product} entity.
 */
public class ProductDTO implements Serializable {

  private Long id;
  private String name;
  private String subtitle;
  private String description;
  private Long brandId;
  private Long previewImageId;
  private Long categoryId;

  private String brandName;
  private String categoryName;
  private String previewImageUrl;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getBrandId() {
    return brandId;
  }

  public void setBrandId(Long brandId) {
    this.brandId = brandId;
  }

  public String getSubtitle() {
    return subtitle;
  }

  public void setSubtitle(String subtitle) {
    this.subtitle = subtitle;
  }

  public Long getPreviewImageId() {
    return previewImageId;
  }

  public void setPreviewImageId(Long previewImageId) {
    this.previewImageId = previewImageId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public String getPreviewImageUrl() {
    return previewImageUrl;
  }

  public void setPreviewImageUrl(String previewImageUrl) {
    this.previewImageUrl = previewImageUrl;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) {
      return true;
    }
    if(!(o instanceof ProductDTO)) {
      return false;
    }

    return id != null && id.equals(((ProductDTO) o).id);
  }

  @Override
  public int hashCode() {
    return 31;
  }

  @Override
  public String toString() {
    return "ProductDTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", subtitle='" + subtitle + '\'' +
        ", description='" + description + '\'' +
        ", brandId=" + brandId +
        ", previewImageId=" + previewImageId +
        ", categoryId=" + categoryId +
        '}';
  }
}

package tech.przybysz.pms.productsservice.service.dto.fulldata;

import java.util.ArrayList;
import java.util.List;

public class CategoryFDTO {

  private Long id;
  private String name;
  private Long parentCategoryId;
  private List<AttributeFDTO> attributes = new ArrayList<>();

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

  public Long getParentCategoryId() {
    return parentCategoryId;
  }

  public void setParentCategoryId(Long parentCategoryId) {
    this.parentCategoryId = parentCategoryId;
  }

  public List<AttributeFDTO> getAttributes() {
    return attributes;
  }

  public void setAttributes(List<AttributeFDTO> attributes) {
    this.attributes = attributes;
  }

  @Override
  public String toString() {
    return "CategoryFDTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", parentCategoryId=" + parentCategoryId +
        ", attributes=" + attributes +
        '}';
  }
}

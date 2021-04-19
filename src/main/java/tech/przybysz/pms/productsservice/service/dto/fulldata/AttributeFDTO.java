package tech.przybysz.pms.productsservice.service.dto.fulldata;

import tech.przybysz.pms.productsservice.service.dto.AttributeTypeDTO;

public class AttributeFDTO {

  private Long id;
  private String name;
  private AttributeTypeDTO attributeType;

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

  public AttributeTypeDTO getAttributeType() {
    return attributeType;
  }

  public void setAttributeType(AttributeTypeDTO attributeType) {
    this.attributeType = attributeType;
  }

  @Override
  public String toString() {
    return "AttributeFDTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", attributeType=" + attributeType +
        '}';
  }
}

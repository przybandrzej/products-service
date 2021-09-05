package tech.przybysz.pms.productsservice.service.dto.fulldata;

import tech.przybysz.pms.productsservice.service.dto.UnitDTO;

public class AttributeEntryFDTO {

  private Long id;
  private String value;
  private Long productId;
  private AttributeFDTO attribute;
  private UnitDTO unit;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public AttributeFDTO getAttribute() {
    return attribute;
  }

  public void setAttribute(AttributeFDTO attribute) {
    this.attribute = attribute;
  }

  public UnitDTO getUnit() {
    return unit;
  }

  public void setUnit(UnitDTO unit) {
    this.unit = unit;
  }

  @Override
  public String toString() {
    return "AttributeEntryFDTO{" +
        "id=" + id +
        ", value='" + value + '\'' +
        ", productId=" + productId +
        ", attribute=" + attribute +
        ", unit=" + unit +
        '}';
  }
}

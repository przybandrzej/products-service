package tech.przybysz.pms.productsservice.service.dto;

import tech.przybysz.pms.productsservice.domain.enumeration.ValueDataType;

import java.util.ArrayList;
import java.util.List;

public class AttributeTypeDTO {

  private Long id;
  private String name;
  private String materialIcon;
  private ValueDataType dataType;
  private List<UnitDTO> units = new ArrayList<>();

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

  public String getMaterialIcon() {
    return materialIcon;
  }

  public void setMaterialIcon(String materialIcon) {
    this.materialIcon = materialIcon;
  }

  public ValueDataType getDataType() {
    return dataType;
  }

  public void setDataType(ValueDataType dataType) {
    this.dataType = dataType;
  }

  public List<UnitDTO> getUnits() {
    return units;
  }

  public void setUnits(List<UnitDTO> units) {
    this.units = units;
  }

  @Override
  public String toString() {
    return "AttributeTypeDTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", materialIcon='" + materialIcon + '\'' +
        ", dataType=" + dataType +
        ", units=" + units +
        '}';
  }
}

package tech.przybysz.pms.productsservice.domain;

import tech.przybysz.pms.productsservice.domain.enumeration.ValueDataType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "attribute_type")
public class AttributeType implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
  @SequenceGenerator(name = "sequenceGenerator")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "material_icon")
  private String materialIcon;

  @Enumerated(EnumType.STRING)
  @Column(name = "data_type")
  private ValueDataType dataType;

  @ManyToMany
  @JoinTable(name = "attribute_type_unit",
      joinColumns = @JoinColumn(name = "attribute_type_id"),
      inverseJoinColumns = @JoinColumn(name = "unit_id"))
  private Set<Unit> units = new HashSet<>();

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

  public Set<Unit> getUnits() {
    return units;
  }

  public void setUnits(Set<Unit> units) {
    this.units = units;
  }

  public ValueDataType getDataType() {
    return dataType;
  }

  public void setDataType(ValueDataType dataType) {
    this.dataType = dataType;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) {
      return true;
    }
    if(!(o instanceof AttributeType)) {
      return false;
    }
    return id != null && id.equals(((AttributeType) o).id);
  }

  @Override
  public int hashCode() {
    return 31;
  }
}

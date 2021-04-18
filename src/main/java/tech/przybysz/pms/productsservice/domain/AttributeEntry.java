package tech.przybysz.pms.productsservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A AttributeEntry.
 */
@Entity
@Table(name = "attribute_entry")
public class AttributeEntry implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
  @SequenceGenerator(name = "sequenceGenerator")
  private Long id;

  @Column(name = "value")
  private String value;

  @ManyToOne
  @JsonIgnoreProperties(value = "attributeEntries", allowSetters = true)
  private Attribute attribute;

  @ManyToOne
  private Product product;

  // jhipster-needle-entity-add-field - JHipster will add fields here
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getValue() {
    return value;
  }

  public AttributeEntry value(String value) {
    this.value = value;
    return this;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Attribute getAttribute() {
    return attribute;
  }

  public AttributeEntry attribute(Attribute attribute) {
    this.attribute = attribute;
    return this;
  }

  public void setAttribute(Attribute attribute) {
    this.attribute = attribute;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

  @Override
  public boolean equals(Object o) {
    if(this == o) {
      return true;
    }
    if(!(o instanceof AttributeEntry)) {
      return false;
    }
    return id != null && id.equals(((AttributeEntry) o).id);
  }

  @Override
  public int hashCode() {
    return 31;
  }

  // prettier-ignore
  @Override
  public String toString() {
    return "AttributeEntry{" +
        "id=" + getId() +
        ", value='" + getValue() + "'" +
        "}";
  }
}

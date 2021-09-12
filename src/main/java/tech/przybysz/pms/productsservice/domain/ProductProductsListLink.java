package tech.przybysz.pms.productsservice.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="product_products_list_link")
public class ProductProductsListLink implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
  @SequenceGenerator(name = "sequenceGenerator")
  private Long id;

  @OneToOne
  @JoinColumn(unique = true)
  private Product product;

  @OneToOne
  @JoinColumn(unique = true)
  private ProductsList list;

  @Column(name = "product_order")
  private float order;

  @Column(name = "note")
  private String note;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public ProductsList getList() {
    return list;
  }

  public void setList(ProductsList list) {
    this.list = list;
  }

  public float getOrder() {
    return order;
  }

  public void setOrder(float order) {
    this.order = order;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) {
      return true;
    }
    if(!(o instanceof ProductProductsListLink)) {
      return false;
    }
    return id != null && id.equals(((ProductProductsListLink) o).id);
  }

  @Override
  public int hashCode() {
    return 31;
  }
}

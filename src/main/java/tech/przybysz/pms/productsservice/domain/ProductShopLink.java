package tech.przybysz.pms.productsservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="product_shop_link")
public class ProductShopLink implements Serializable {

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
  private Shop shop;

  @Column(name = "price", precision = 21, scale = 2)
  private BigDecimal price;

  @ManyToOne
  @JsonIgnoreProperties(value = "products", allowSetters = true)
  private Currency currency;

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

  public Shop getShop() {
    return shop;
  }

  public void setShop(Shop shop) {
    this.shop = shop;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) {
      return true;
    }
    if(!(o instanceof ProductShopLink)) {
      return false;
    }
    return id != null && id.equals(((ProductShopLink) o).id);
  }

  @Override
  public int hashCode() {
    return 31;
  }
}

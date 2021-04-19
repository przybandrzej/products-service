package tech.przybysz.pms.productsservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * A Product.
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
  @SequenceGenerator(name = "sequenceGenerator")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "subtitle")
  private String subtitle;

  @Column(name = "description")
  private String description;

  @Column(name = "price", precision = 21, scale = 2)
  private BigDecimal price;

  @ManyToOne
  @JsonIgnoreProperties(value = "products", allowSetters = true)
  private Currency currency;

  @ManyToOne
  @Fetch(FetchMode.JOIN)
  @JsonIgnoreProperties(value = "products", allowSetters = true)
  private Brand brand;

  @ManyToOne
  @JsonIgnoreProperties(value = "products", allowSetters = true)
  private ImageUrl previewImage;

  @ManyToOne
  private Category category;

  @OneToMany(mappedBy = "product")
  private Set<AttributeEntry> attributeEntries = new HashSet<>();

  @ManyToMany
  @JoinTable(name = "product_shop",
      joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "shop_id", referencedColumnName = "id"))
  private Set<Shop> shops = new HashSet<>();

  // jhipster-needle-entity-add-field - JHipster will add fields here
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public Product name(String name) {
    this.name = name;
    return this;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public Product price(BigDecimal price) {
    this.price = price;
    return this;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Brand getBrand() {
    return brand;
  }

  public Product brand(Brand brand) {
    this.brand = brand;
    return this;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Set<AttributeEntry> getAttributeEntries() {
    return attributeEntries;
  }

  public void setAttributeEntries(Set<AttributeEntry> attributeEntries) {
    this.attributeEntries = attributeEntries;
  }

  public Set<Shop> getShops() {
    return shops;
  }

  public Product shops(Set<Shop> shops) {
    this.shops = shops;
    return this;
  }

  public Product addShop(Shop shop) {
    this.shops.add(shop);
    shop.getProducts().add(this);
    return this;
  }

  public Product removeShop(Shop shop) {
    this.shops.remove(shop);
    shop.getProducts().remove(this);
    return this;
  }

  public void setShops(Set<Shop> shops) {
    this.shops = shops;
  }

  public String getSubtitle() {
    return subtitle;
  }

  public void setSubtitle(String subtitle) {
    this.subtitle = subtitle;
  }

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  public ImageUrl getPreviewImage() {
    return previewImage;
  }

  public void setPreviewImage(ImageUrl previewImage) {
    this.previewImage = previewImage;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

  @Override
  public boolean equals(Object o) {
    if(this == o) {
      return true;
    }
    if(!(o instanceof Product)) {
      return false;
    }
    return id != null && id.equals(((Product) o).id);
  }

  @Override
  public int hashCode() {
    return 31;
  }

  // prettier-ignore
  @Override
  public String toString() {
    return "Product{" +
        "id=" + getId() +
        ", name='" + getName() + "'" +
        ", price=" + getPrice() +
        "}";
  }
}

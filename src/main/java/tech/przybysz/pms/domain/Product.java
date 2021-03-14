package tech.przybysz.pms.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    @Column(name = "price", precision = 21, scale = 2)
    private BigDecimal price;

    @ManyToOne
    @JsonIgnoreProperties(value = "products", allowSetters = true)
    private Brand brand;

    @ManyToMany
    @JoinTable(name = "product_category",
               joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private Set<Category> categories = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "product_attribute_entry",
               joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "attribute_entry_id", referencedColumnName = "id"))
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

    public Set<Category> getCategories() {
        return categories;
    }

    public Product categories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }

    public Product addCategory(Category category) {
        this.categories.add(category);
        category.getProducts().add(this);
        return this;
    }

    public Product removeCategory(Category category) {
        this.categories.remove(category);
        category.getProducts().remove(this);
        return this;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<AttributeEntry> getAttributeEntries() {
        return attributeEntries;
    }

    public Product attributeEntries(Set<AttributeEntry> attributeEntries) {
        this.attributeEntries = attributeEntries;
        return this;
    }

    public Product addAttributeEntry(AttributeEntry attributeEntry) {
        this.attributeEntries.add(attributeEntry);
        attributeEntry.getProducts().add(this);
        return this;
    }

    public Product removeAttributeEntry(AttributeEntry attributeEntry) {
        this.attributeEntries.remove(attributeEntry);
        attributeEntry.getProducts().remove(this);
        return this;
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
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
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

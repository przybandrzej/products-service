package tech.przybysz.pms.productsservice.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * A DTO for the {@link tech.przybysz.pms.productsservice.domain.Product} entity.
 */
public class ProductDTO implements Serializable {
    
    private Long id;

    private String name;

    private BigDecimal price;


    private Long brandId;
    private Set<CategoryDTO> categories = new HashSet<>();
    private Set<AttributeEntryDTO> attributeEntries = new HashSet<>();
    private Set<ShopDTO> shops = new HashSet<>();
    
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Set<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryDTO> categories) {
        this.categories = categories;
    }

    public Set<AttributeEntryDTO> getAttributeEntries() {
        return attributeEntries;
    }

    public void setAttributeEntries(Set<AttributeEntryDTO> attributeEntries) {
        this.attributeEntries = attributeEntries;
    }

    public Set<ShopDTO> getShops() {
        return shops;
    }

    public void setShops(Set<ShopDTO> shops) {
        this.shops = shops;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductDTO)) {
            return false;
        }

        return id != null && id.equals(((ProductDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", price=" + getPrice() +
            ", brandId=" + getBrandId() +
            ", categories='" + getCategories() + "'" +
            ", attributeEntries='" + getAttributeEntries() + "'" +
            ", shops='" + getShops() + "'" +
            "}";
    }
}
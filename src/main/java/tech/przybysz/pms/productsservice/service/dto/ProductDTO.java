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
    private String subtitle;
    private String description;
    private BigDecimal price;
    private Long currencyId;
    private String currencySymbol;
    private Long brandId;
    private String brandName;
    private Long previewImageId;
    private String previewImageUrl;
    private Set<CategoryDTO> categories = new HashSet<>();
    private Set<ShopDTO> shops = new HashSet<>();
    private Set<AttributeEntryDTO> attributeEntries = new HashSet<>();
    
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

    public Set<ShopDTO> getShops() {
        return shops;
    }

    public void setShops(Set<ShopDTO> shops) {
        this.shops = shops;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getPreviewImageId() {
        return previewImageId;
    }

    public void setPreviewImageId(Long previewImageId) {
        this.previewImageId = previewImageId;
    }

    public String getPreviewImageUrl() {
        return previewImageUrl;
    }

    public void setPreviewImageUrl(String previewImageUrl) {
        this.previewImageUrl = previewImageUrl;
    }

    public Set<AttributeEntryDTO> getAttributeEntries() {
        return attributeEntries;
    }

    public void setAttributeEntries(Set<AttributeEntryDTO> attributeEntries) {
        this.attributeEntries = attributeEntries;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
            "id=" + id +
            ", name='" + name + '\'' +
            ", subtitle='" + subtitle + '\'' +
            ", description='" + description + '\'' +
            ", price=" + price +
            ", currencyId=" + currencyId +
            ", currencySymbol='" + currencySymbol + '\'' +
            ", brandId=" + brandId +
            ", brandName='" + brandName + '\'' +
            ", previewImageId=" + previewImageId +
            ", previewImageUrl='" + previewImageUrl + '\'' +
            ", categories=" + categories +
            ", shops=" + shops +
            ", attributeEntries=" + attributeEntries +
            '}';
    }
}

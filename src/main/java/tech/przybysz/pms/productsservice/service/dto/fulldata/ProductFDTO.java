package tech.przybysz.pms.productsservice.service.dto.fulldata;

import tech.przybysz.pms.productsservice.service.dto.ShopDTO;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ProductFDTO {

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
  private Long categoryId;
  private String categoryName;
  private Set<ShopDTO> shops = new HashSet<>();
  private Set<AttributeEntryFDTO> attributeEntries = new HashSet<>();

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

  public String getSubtitle() {
    return subtitle;
  }

  public void setSubtitle(String subtitle) {
    this.subtitle = subtitle;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
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

  public Long getBrandId() {
    return brandId;
  }

  public void setBrandId(Long brandId) {
    this.brandId = brandId;
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

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public Set<ShopDTO> getShops() {
    return shops;
  }

  public void setShops(Set<ShopDTO> shops) {
    this.shops = shops;
  }

  public Set<AttributeEntryFDTO> getAttributeEntries() {
    return attributeEntries;
  }

  public void setAttributeEntries(Set<AttributeEntryFDTO> attributeEntries) {
    this.attributeEntries = attributeEntries;
  }

  @Override
  public String toString() {
    return "ProductFDTO{" +
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
        ", categoryId=" + categoryId +
        ", categoryName='" + categoryName + '\'' +
        ", shops=" + shops +
        ", attributeEntries=" + attributeEntries +
        '}';
  }
}

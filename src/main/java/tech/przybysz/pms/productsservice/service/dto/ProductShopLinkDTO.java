package tech.przybysz.pms.productsservice.service.dto;

import java.math.BigDecimal;

public class ProductShopLinkDTO {

  private Long id;
  private Long productId;
  private Long shopId;
  private BigDecimal price;
  private Long currencyId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public Long getShopId() {
    return shopId;
  }

  public void setShopId(Long shopId) {
    this.shopId = shopId;
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

  @Override
  public String toString() {
    return "ProductShopLinkDTO{" +
        "id=" + id +
        ", productId=" + productId +
        ", shopId=" + shopId +
        ", price=" + price +
        ", currencyId=" + currencyId +
        '}';
  }
}

package tech.przybysz.pms.productsservice.service.dto.fulldata;

import tech.przybysz.pms.productsservice.service.dto.CurrencyDTO;
import tech.przybysz.pms.productsservice.service.dto.ShopDTO;

import java.math.BigDecimal;

public class ProductShopFDTO {

  private Long productId;
  private Long shopId;
  private Long linkId;
  private Long currencyId;
  private ShopDTO shop;
  private CurrencyDTO currency;
  private BigDecimal price;


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

  public Long getLinkId() {
    return linkId;
  }

  public void setLinkId(Long linkId) {
    this.linkId = linkId;
  }

  public ShopDTO getShop() {
    return shop;
  }

  public void setShop(ShopDTO shop) {
    this.shop = shop;
  }

  public CurrencyDTO getCurrency() {
    return currency;
  }

  public void setCurrency(CurrencyDTO currency) {
    this.currency = currency;
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
    return "ProductShopFDTO{" +
        "productId=" + productId +
        ", shopId=" + shopId +
        ", linkId=" + linkId +
        ", shop=" + shop +
        ", currency=" + currency +
        ", price=" + price +
        '}';
  }
}

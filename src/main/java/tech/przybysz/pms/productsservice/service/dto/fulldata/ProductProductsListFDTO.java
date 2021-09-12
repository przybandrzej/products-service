package tech.przybysz.pms.productsservice.service.dto.fulldata;

public class ProductProductsListFDTO {

  private Long id;
  private float order;
  private String note;
  private ProductFDTO product;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public ProductFDTO getProduct() {
    return product;
  }

  public void setProduct(ProductFDTO product) {
    this.product = product;
  }

  @Override
  public String toString() {
    return "ProductProductsListFDTO{" +
        "id=" + id +
        ", order=" + order +
        ", note='" + note + '\'' +
        ", product=" + product +
        '}';
  }
}

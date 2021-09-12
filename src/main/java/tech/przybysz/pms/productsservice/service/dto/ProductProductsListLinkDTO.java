package tech.przybysz.pms.productsservice.service.dto;

public class ProductProductsListLinkDTO {

  private Long id;
  private Long productId;
  private Long listId;
  private float order;
  private String note;

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

  public Long getListId() {
    return listId;
  }

  public void setListId(Long listId) {
    this.listId = listId;
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
  public String toString() {
    return "ProductProductsListLinkDTO{" +
        "id=" + id +
        ", productId=" + productId +
        ", listId=" + listId +
        ", order=" + order +
        ", note='" + note + '\'' +
        '}';
  }
}

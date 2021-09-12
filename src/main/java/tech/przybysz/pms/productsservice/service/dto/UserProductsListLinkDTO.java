package tech.przybysz.pms.productsservice.service.dto;

public class UserProductsListLinkDTO {

  private Long id;
  private Long userId;
  private Long listId;
  private boolean canAddProducts;
  private boolean canRemoveProducts;
  private boolean canEditProducts;
  private boolean canChangeOrder;
  private boolean canManageAccess;
  private boolean canEditInfo;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getListId() {
    return listId;
  }

  public void setListId(Long listId) {
    this.listId = listId;
  }

  public boolean isCanAddProducts() {
    return canAddProducts;
  }

  public void setCanAddProducts(boolean canAddProducts) {
    this.canAddProducts = canAddProducts;
  }

  public boolean isCanRemoveProducts() {
    return canRemoveProducts;
  }

  public void setCanRemoveProducts(boolean canRemoveProducts) {
    this.canRemoveProducts = canRemoveProducts;
  }

  public boolean isCanEditProducts() {
    return canEditProducts;
  }

  public void setCanEditProducts(boolean canEditProducts) {
    this.canEditProducts = canEditProducts;
  }

  public boolean isCanChangeOrder() {
    return canChangeOrder;
  }

  public void setCanChangeOrder(boolean canChangeOrder) {
    this.canChangeOrder = canChangeOrder;
  }

  public boolean isCanManageAccess() {
    return canManageAccess;
  }

  public void setCanManageAccess(boolean canManageAccess) {
    this.canManageAccess = canManageAccess;
  }

  public boolean isCanEditInfo() {
    return canEditInfo;
  }

  public void setCanEditInfo(boolean canEditInfo) {
    this.canEditInfo = canEditInfo;
  }

  @Override
  public String toString() {
    return "UserProductsListLinkDTO{" +
        "id=" + id +
        ", userId=" + userId +
        ", listId=" + listId +
        ", canAddProducts=" + canAddProducts +
        ", canRemoveProducts=" + canRemoveProducts +
        ", canEditProducts=" + canEditProducts +
        ", canChangeOrder=" + canChangeOrder +
        ", canManageAccess=" + canManageAccess +
        ", canEditInfo=" + canEditInfo +
        '}';
  }
}

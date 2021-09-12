package tech.przybysz.pms.productsservice.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user_products_list_link")
public class UserProductsListLink implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
  @SequenceGenerator(name = "sequenceGenerator")
  private Long id;

  @OneToOne
  @JoinColumn(unique = true)
  private User user;

  @OneToOne
  @JoinColumn(unique = true)
  private ProductsList list;

  @Column(name = "can_add_products")
  private boolean canAddProducts;

  @Column(name = "can_remove_products")
  private boolean canRemoveProducts;

  @Column(name = "can_edit_products")
  private boolean canEditProducts;

  @Column(name = "can_change_products_order")
  private boolean canChangeOrder;

  @Column(name = "can_manage_access")
  private boolean canManageAccess;

  @Column(name = "can_edit_info")
  private boolean canEditInfo;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public ProductsList getList() {
    return list;
  }

  public void setList(ProductsList list) {
    this.list = list;
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
  public boolean equals(Object o) {
    if(this == o) {
      return true;
    }
    if(!(o instanceof UserProductsListLink)) {
      return false;
    }
    return id != null && id.equals(((UserProductsListLink) o).id);
  }

  @Override
  public int hashCode() {
    return 31;
  }
}

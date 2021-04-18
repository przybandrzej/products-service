package tech.przybysz.pms.productsservice.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link tech.przybysz.pms.productsservice.domain.Category} entity.
 */
public class CategoryDTO implements Serializable {
    
    private Long id;
    private String name;
    private Long parentCategoryId;

    
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

    public Long getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Long parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CategoryDTO)) {
            return false;
        }

        return id != null && id.equals(((CategoryDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", parentCategoryId=" + parentCategoryId +
            '}';
    }
}

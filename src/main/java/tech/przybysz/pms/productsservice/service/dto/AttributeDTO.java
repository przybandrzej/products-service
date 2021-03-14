package tech.przybysz.pms.productsservice.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link tech.przybysz.pms.productsservice.domain.Attribute} entity.
 */
public class AttributeDTO implements Serializable {
    
    private Long id;

    private String name;

    private Boolean isString;

    private Boolean isLong;

    private Boolean isDouble;

    private Boolean isDate;

    private Boolean isBoolean;


    private Long categoryId;
    
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

    public Boolean isIsString() {
        return isString;
    }

    public void setIsString(Boolean isString) {
        this.isString = isString;
    }

    public Boolean isIsLong() {
        return isLong;
    }

    public void setIsLong(Boolean isLong) {
        this.isLong = isLong;
    }

    public Boolean isIsDouble() {
        return isDouble;
    }

    public void setIsDouble(Boolean isDouble) {
        this.isDouble = isDouble;
    }

    public Boolean isIsDate() {
        return isDate;
    }

    public void setIsDate(Boolean isDate) {
        this.isDate = isDate;
    }

    public Boolean isIsBoolean() {
        return isBoolean;
    }

    public void setIsBoolean(Boolean isBoolean) {
        this.isBoolean = isBoolean;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AttributeDTO)) {
            return false;
        }

        return id != null && id.equals(((AttributeDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AttributeDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", isString='" + isIsString() + "'" +
            ", isLong='" + isIsLong() + "'" +
            ", isDouble='" + isIsDouble() + "'" +
            ", isDate='" + isIsDate() + "'" +
            ", isBoolean='" + isIsBoolean() + "'" +
            ", categoryId=" + getCategoryId() +
            "}";
    }
}

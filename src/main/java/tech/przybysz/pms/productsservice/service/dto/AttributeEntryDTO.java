package tech.przybysz.pms.productsservice.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link tech.przybysz.pms.productsservice.domain.AttributeEntry} entity.
 */
public class AttributeEntryDTO implements Serializable {
    
    private Long id;
    private String value;
    private Long attributeId;
    private Long productId;
    private UnitDTO unit;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public UnitDTO getUnit() {
        return unit;
    }

    public void setUnit(UnitDTO unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AttributeEntryDTO)) {
            return false;
        }

        return id != null && id.equals(((AttributeEntryDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "AttributeEntryDTO{" +
            "id=" + id +
            ", value='" + value + '\'' +
            ", attributeId=" + attributeId +
            ", productId=" + productId +
            ", unit=" + unit +
            '}';
    }
}

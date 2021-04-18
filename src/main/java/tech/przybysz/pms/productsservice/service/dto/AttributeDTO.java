package tech.przybysz.pms.productsservice.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link tech.przybysz.pms.productsservice.domain.Attribute} entity.
 */
public class AttributeDTO implements Serializable {
    
    private Long id;
    private String name;
    private Long attributeTypeId;

    
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

    public Long getAttributeTypeId() {
        return attributeTypeId;
    }

    public void setAttributeTypeId(Long attributeTypeId) {
        this.attributeTypeId = attributeTypeId;
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

    @Override
    public String toString() {
        return "AttributeDTO{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", attributeTypeId=" + attributeTypeId +
            '}';
    }
}

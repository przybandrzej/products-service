package tech.przybysz.pms.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link tech.przybysz.pms.domain.AttributeEntry} entity.
 */
public class AttributeEntryDTO implements Serializable {
    
    private Long id;

    private String value;


    private Long attributeId;
    
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

    // prettier-ignore
    @Override
    public String toString() {
        return "AttributeEntryDTO{" +
            "id=" + getId() +
            ", value='" + getValue() + "'" +
            ", attributeId=" + getAttributeId() +
            "}";
    }
}

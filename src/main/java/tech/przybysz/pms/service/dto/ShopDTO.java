package tech.przybysz.pms.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link tech.przybysz.pms.domain.Shop} entity.
 */
public class ShopDTO implements Serializable {
    
    private Long id;

    private String name;

    
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ShopDTO)) {
            return false;
        }

        return id != null && id.equals(((ShopDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ShopDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}

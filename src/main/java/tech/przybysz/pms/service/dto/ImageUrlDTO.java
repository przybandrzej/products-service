package tech.przybysz.pms.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link tech.przybysz.pms.domain.ImageUrl} entity.
 */
public class ImageUrlDTO implements Serializable {
    
    private Long id;

    private String url;

    private Float applyingOrder;


    private Long productId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Float getApplyingOrder() {
        return applyingOrder;
    }

    public void setApplyingOrder(Float applyingOrder) {
        this.applyingOrder = applyingOrder;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ImageUrlDTO)) {
            return false;
        }

        return id != null && id.equals(((ImageUrlDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ImageUrlDTO{" +
            "id=" + getId() +
            ", url='" + getUrl() + "'" +
            ", applyingOrder=" + getApplyingOrder() +
            ", productId=" + getProductId() +
            "}";
    }
}

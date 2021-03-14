package tech.przybysz.pms.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A ImageUrl.
 */
@Entity
@Table(name = "image_url")
public class ImageUrl implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "url")
    private String url;

    @Column(name = "applying_order")
    private Float applyingOrder;

    @ManyToOne
    @JsonIgnoreProperties(value = "imageUrls", allowSetters = true)
    private Product product;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public ImageUrl url(String url) {
        this.url = url;
        return this;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Float getApplyingOrder() {
        return applyingOrder;
    }

    public ImageUrl applyingOrder(Float applyingOrder) {
        this.applyingOrder = applyingOrder;
        return this;
    }

    public void setApplyingOrder(Float applyingOrder) {
        this.applyingOrder = applyingOrder;
    }

    public Product getProduct() {
        return product;
    }

    public ImageUrl product(Product product) {
        this.product = product;
        return this;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ImageUrl)) {
            return false;
        }
        return id != null && id.equals(((ImageUrl) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ImageUrl{" +
            "id=" + getId() +
            ", url='" + getUrl() + "'" +
            ", applyingOrder=" + getApplyingOrder() +
            "}";
    }
}

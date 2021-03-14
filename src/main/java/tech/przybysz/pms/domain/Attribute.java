package tech.przybysz.pms.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A Attribute.
 */
@Entity
@Table(name = "attribute")
public class Attribute implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_string")
    private Boolean isString;

    @Column(name = "is_long")
    private Boolean isLong;

    @Column(name = "is_double")
    private Boolean isDouble;

    @Column(name = "is_date")
    private Boolean isDate;

    @Column(name = "is_boolean")
    private Boolean isBoolean;

    @ManyToOne
    @JsonIgnoreProperties(value = "attributes", allowSetters = true)
    private Category category;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Attribute name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isIsString() {
        return isString;
    }

    public Attribute isString(Boolean isString) {
        this.isString = isString;
        return this;
    }

    public void setIsString(Boolean isString) {
        this.isString = isString;
    }

    public Boolean isIsLong() {
        return isLong;
    }

    public Attribute isLong(Boolean isLong) {
        this.isLong = isLong;
        return this;
    }

    public void setIsLong(Boolean isLong) {
        this.isLong = isLong;
    }

    public Boolean isIsDouble() {
        return isDouble;
    }

    public Attribute isDouble(Boolean isDouble) {
        this.isDouble = isDouble;
        return this;
    }

    public void setIsDouble(Boolean isDouble) {
        this.isDouble = isDouble;
    }

    public Boolean isIsDate() {
        return isDate;
    }

    public Attribute isDate(Boolean isDate) {
        this.isDate = isDate;
        return this;
    }

    public void setIsDate(Boolean isDate) {
        this.isDate = isDate;
    }

    public Boolean isIsBoolean() {
        return isBoolean;
    }

    public Attribute isBoolean(Boolean isBoolean) {
        this.isBoolean = isBoolean;
        return this;
    }

    public void setIsBoolean(Boolean isBoolean) {
        this.isBoolean = isBoolean;
    }

    public Category getCategory() {
        return category;
    }

    public Attribute category(Category category) {
        this.category = category;
        return this;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Attribute)) {
            return false;
        }
        return id != null && id.equals(((Attribute) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Attribute{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", isString='" + isIsString() + "'" +
            ", isLong='" + isIsLong() + "'" +
            ", isDouble='" + isIsDouble() + "'" +
            ", isDate='" + isIsDate() + "'" +
            ", isBoolean='" + isIsBoolean() + "'" +
            "}";
    }
}

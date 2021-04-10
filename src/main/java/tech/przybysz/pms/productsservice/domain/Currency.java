package tech.przybysz.pms.productsservice.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A Currency.
 */
@Entity
@Table(name = "currency")
public class Currency implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
  @SequenceGenerator(name = "sequenceGenerator")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "symbol")
  private String symbol;

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

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) {
      return true;
    }
    if(!(o instanceof Currency)) {
      return false;
    }
    return id != null && id.equals(((Currency) o).id);
  }

  @Override
  public int hashCode() {
    return 31;
  }
}

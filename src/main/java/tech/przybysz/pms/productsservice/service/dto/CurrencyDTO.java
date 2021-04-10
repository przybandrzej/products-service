package tech.przybysz.pms.productsservice.service.dto;

public class CurrencyDTO {

  private Long id;
  private String name;
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
    if(!(o instanceof CurrencyDTO)) {
      return false;
    }

    return id != null && id.equals(((CurrencyDTO) o).id);
  }

  @Override
  public int hashCode() {
    return 31;
  }

  @Override
  public String toString() {
    return "CurrencyDTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", symbol='" + symbol + '\'' +
        '}';
  }
}

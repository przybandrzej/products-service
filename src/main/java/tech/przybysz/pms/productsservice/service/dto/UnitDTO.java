package tech.przybysz.pms.productsservice.service.dto;

public class UnitDTO {

  private Long id;
  private String name;
  private String symbol;
  private String shortName;

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

  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  @Override
  public String toString() {
    return "UnitDTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", symbol='" + symbol + '\'' +
        ", shortName='" + shortName + '\'' +
        '}';
  }
}

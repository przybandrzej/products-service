package tech.przybysz.pms.productsservice.service.mapper;


import org.mapstruct.Mapper;
import tech.przybysz.pms.productsservice.domain.Currency;
import tech.przybysz.pms.productsservice.service.dto.CurrencyDTO;

/**
 * Mapper for the entity {@link Currency} and its DTO {@link CurrencyDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CurrencyMapper extends EntityMapper<CurrencyDTO, Currency> {

  CurrencyDTO toDto(Currency currency);

  Currency toEntity(CurrencyDTO currencyDTO);

  default Currency fromId(Long id) {
    if(id == null) {
      return null;
    }
    Currency currency = new Currency();
    currency.setId(id);
    return currency;
  }
}

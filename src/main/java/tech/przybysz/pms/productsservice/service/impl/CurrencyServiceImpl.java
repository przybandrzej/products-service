package tech.przybysz.pms.productsservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.przybysz.pms.productsservice.domain.Currency;
import tech.przybysz.pms.productsservice.repository.CurrencyRepository;
import tech.przybysz.pms.productsservice.service.CurrencyService;
import tech.przybysz.pms.productsservice.service.dto.CurrencyDTO;
import tech.przybysz.pms.productsservice.service.mapper.CurrencyMapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Currency}.
 */
@Service
@Transactional
public class CurrencyServiceImpl implements CurrencyService {

  private final Logger log = LoggerFactory.getLogger(CurrencyServiceImpl.class);

  private final CurrencyRepository currencyRepository;
  private final CurrencyMapper currencyMapper;

  public CurrencyServiceImpl(CurrencyRepository currencyRepository, CurrencyMapper currencyMapper) {
    this.currencyRepository = currencyRepository;
    this.currencyMapper = currencyMapper;
  }

  @Override
  public CurrencyDTO save(CurrencyDTO currencyDTO) {
    log.debug("Request to save Currency : {}", currencyDTO);
    Currency currency = currencyMapper.toEntity(currencyDTO);
    currency = currencyRepository.save(currency);
    return currencyMapper.toDto(currency);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CurrencyDTO> findAll() {
    log.debug("Request to get all Currencies");
    return currencyRepository.findAll().stream()
        .map(currencyMapper::toDto)
        .collect(Collectors.toCollection(LinkedList::new));
  }


  @Override
  @Transactional(readOnly = true)
  public Optional<CurrencyDTO> findOne(Long id) {
    log.debug("Request to get Currency : {}", id);
    return currencyRepository.findById(id)
        .map(currencyMapper::toDto);
  }

  @Override
  public void delete(Long id) {
    log.debug("Request to delete Currency : {}", id);
    currencyRepository.deleteById(id);
  }
}

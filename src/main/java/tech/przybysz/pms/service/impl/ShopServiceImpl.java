package tech.przybysz.pms.service.impl;

import tech.przybysz.pms.service.ShopService;
import tech.przybysz.pms.domain.Shop;
import tech.przybysz.pms.repository.ShopRepository;
import tech.przybysz.pms.service.dto.ShopDTO;
import tech.przybysz.pms.service.mapper.ShopMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Shop}.
 */
@Service
@Transactional
public class ShopServiceImpl implements ShopService {

    private final Logger log = LoggerFactory.getLogger(ShopServiceImpl.class);

    private final ShopRepository shopRepository;

    private final ShopMapper shopMapper;

    public ShopServiceImpl(ShopRepository shopRepository, ShopMapper shopMapper) {
        this.shopRepository = shopRepository;
        this.shopMapper = shopMapper;
    }

    @Override
    public ShopDTO save(ShopDTO shopDTO) {
        log.debug("Request to save Shop : {}", shopDTO);
        Shop shop = shopMapper.toEntity(shopDTO);
        shop = shopRepository.save(shop);
        return shopMapper.toDto(shop);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ShopDTO> findAll() {
        log.debug("Request to get all Shops");
        return shopRepository.findAll().stream()
            .map(shopMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<ShopDTO> findOne(Long id) {
        log.debug("Request to get Shop : {}", id);
        return shopRepository.findById(id)
            .map(shopMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Shop : {}", id);
        shopRepository.deleteById(id);
    }
}

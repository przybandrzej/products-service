package tech.przybysz.pms.productsservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.przybysz.pms.productsservice.domain.Shop;
import tech.przybysz.pms.productsservice.repository.ShopRepository;
import tech.przybysz.pms.productsservice.service.ShopService;
import tech.przybysz.pms.productsservice.service.dto.ShopDTO;
import tech.przybysz.pms.productsservice.service.mapper.ShopMapper;

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

    @Override
    public List<ShopDTO> search(@Nullable String searchTerm, int size, int page) {
        var pageReq = PageRequest.of(page, size);
        if(searchTerm == null) {
            return shopRepository.findAll(pageReq).stream().map(shopMapper::toDto).collect(Collectors.toList());
        }
        String q = searchTerm.toLowerCase();
        return shopRepository.findAllByNameContainingIgnoreCase(q, pageReq).stream().map(shopMapper::toDto).collect(Collectors.toList());
    }
}

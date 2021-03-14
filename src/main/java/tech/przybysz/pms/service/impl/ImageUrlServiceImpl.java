package tech.przybysz.pms.service.impl;

import tech.przybysz.pms.service.ImageUrlService;
import tech.przybysz.pms.domain.ImageUrl;
import tech.przybysz.pms.repository.ImageUrlRepository;
import tech.przybysz.pms.service.dto.ImageUrlDTO;
import tech.przybysz.pms.service.mapper.ImageUrlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link ImageUrl}.
 */
@Service
@Transactional
public class ImageUrlServiceImpl implements ImageUrlService {

    private final Logger log = LoggerFactory.getLogger(ImageUrlServiceImpl.class);

    private final ImageUrlRepository imageUrlRepository;

    private final ImageUrlMapper imageUrlMapper;

    public ImageUrlServiceImpl(ImageUrlRepository imageUrlRepository, ImageUrlMapper imageUrlMapper) {
        this.imageUrlRepository = imageUrlRepository;
        this.imageUrlMapper = imageUrlMapper;
    }

    @Override
    public ImageUrlDTO save(ImageUrlDTO imageUrlDTO) {
        log.debug("Request to save ImageUrl : {}", imageUrlDTO);
        ImageUrl imageUrl = imageUrlMapper.toEntity(imageUrlDTO);
        imageUrl = imageUrlRepository.save(imageUrl);
        return imageUrlMapper.toDto(imageUrl);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ImageUrlDTO> findAll() {
        log.debug("Request to get all ImageUrls");
        return imageUrlRepository.findAll().stream()
            .map(imageUrlMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<ImageUrlDTO> findOne(Long id) {
        log.debug("Request to get ImageUrl : {}", id);
        return imageUrlRepository.findById(id)
            .map(imageUrlMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ImageUrl : {}", id);
        imageUrlRepository.deleteById(id);
    }
}

package tech.przybysz.pms.service.mapper;


import tech.przybysz.pms.domain.*;
import tech.przybysz.pms.service.dto.ImageUrlDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ImageUrl} and its DTO {@link ImageUrlDTO}.
 */
@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface ImageUrlMapper extends EntityMapper<ImageUrlDTO, ImageUrl> {

    @Mapping(source = "product.id", target = "productId")
    ImageUrlDTO toDto(ImageUrl imageUrl);

    @Mapping(source = "productId", target = "product")
    ImageUrl toEntity(ImageUrlDTO imageUrlDTO);

    default ImageUrl fromId(Long id) {
        if (id == null) {
            return null;
        }
        ImageUrl imageUrl = new ImageUrl();
        imageUrl.setId(id);
        return imageUrl;
    }
}

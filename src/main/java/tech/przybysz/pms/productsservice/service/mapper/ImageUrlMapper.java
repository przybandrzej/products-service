package tech.przybysz.pms.productsservice.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.przybysz.pms.productsservice.domain.*;
import tech.przybysz.pms.productsservice.service.dto.ImageUrlDTO;

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

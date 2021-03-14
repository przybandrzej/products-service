package tech.przybysz.pms.productsservice.service.mapper;


import org.mapstruct.Mapper;
import tech.przybysz.pms.productsservice.domain.*;
import tech.przybysz.pms.productsservice.service.dto.BrandDTO;

/**
 * Mapper for the entity {@link Brand} and its DTO {@link BrandDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BrandMapper extends EntityMapper<BrandDTO, Brand> {



    default Brand fromId(Long id) {
        if (id == null) {
            return null;
        }
        Brand brand = new Brand();
        brand.setId(id);
        return brand;
    }
}

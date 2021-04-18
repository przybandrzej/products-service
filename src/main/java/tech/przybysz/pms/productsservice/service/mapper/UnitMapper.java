package tech.przybysz.pms.productsservice.service.mapper;


import org.mapstruct.Mapper;
import tech.przybysz.pms.productsservice.domain.Unit;
import tech.przybysz.pms.productsservice.service.dto.UnitDTO;

/**
 * Mapper for the entity {@link Unit} and its DTO {@link UnitDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UnitMapper extends EntityMapper<UnitDTO, Unit> {

  UnitDTO toDto(Unit unit);

  Unit toEntity(UnitDTO unitDTO);

  default Unit fromId(Long id) {
    if(id == null) {
      return null;
    }
    Unit unit = new Unit();
    unit.setId(id);
    return unit;
  }
}

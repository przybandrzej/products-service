package tech.przybysz.pms.productsservice.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.przybysz.pms.productsservice.domain.Category;
import tech.przybysz.pms.productsservice.service.dto.CategoryDTO;
import tech.przybysz.pms.productsservice.service.dto.fulldata.CategoryFDTO;

/**
 * Mapper for the entity {@link Category} and its DTO {@link CategoryDTO}.
 */
@Mapper(componentModel = "spring", uses = {AttributeMapper.class})
public interface CategoryMapper extends EntityMapper<CategoryDTO, Category> {

  @Mapping(source = "parentCategory.id", target = "parentCategoryId")
  CategoryDTO toDto(Category category);

  @Mapping(source = "parentCategoryId", target = "parentCategory")
  @Mapping(target = "attributes", ignore = true)
  Category toEntity(CategoryDTO categoryDTO);

  @Mapping(source = "parentCategory.id", target = "parentCategoryId")
  CategoryFDTO toFDto(Category category);

  default Category fromId(Long id) {
    if(id == null) {
      return null;
    }
    Category category = new Category();
    category.setId(id);
    return category;
  }
}

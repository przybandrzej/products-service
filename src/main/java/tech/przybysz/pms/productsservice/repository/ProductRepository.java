package tech.przybysz.pms.productsservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.przybysz.pms.productsservice.domain.Product;

/**
 * Spring Data  repository for the Product entity.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  Page<Product> findAllByNameContainingIgnoreCaseOrSubtitleContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrBrandNameContainingIgnoreCaseOrCategoryNameContainingIgnoreCase(String searchVal1, String searchVal2, String searchVal3, String searchVal4, String searchVal5, Pageable pageRequest);
}

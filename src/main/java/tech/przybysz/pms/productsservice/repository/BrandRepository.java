package tech.przybysz.pms.productsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.przybysz.pms.productsservice.domain.Brand;

/**
 * Spring Data  repository for the Brand entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}

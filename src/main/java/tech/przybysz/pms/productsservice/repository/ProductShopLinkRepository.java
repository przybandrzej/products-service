package tech.przybysz.pms.productsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.przybysz.pms.productsservice.domain.ProductShopLink;

import java.util.Collection;

/**
 * Spring Data  repository for the Product entity.
 */
@Repository
public interface ProductShopLinkRepository extends JpaRepository<ProductShopLink, Long> {

  Collection<ProductShopLink> findAllByProductId(Long productId);
}

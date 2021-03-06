package tech.przybysz.pms.productsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.przybysz.pms.productsservice.domain.ImageUrl;

import java.util.Collection;

/**
 * Spring Data  repository for the ImageUrl entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ImageUrlRepository extends JpaRepository<ImageUrl, Long> {

  Collection<ImageUrl> findAllByProductId(Long productId);
}

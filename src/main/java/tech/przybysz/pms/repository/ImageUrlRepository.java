package tech.przybysz.pms.repository;

import tech.przybysz.pms.domain.ImageUrl;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ImageUrl entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ImageUrlRepository extends JpaRepository<ImageUrl, Long> {
}

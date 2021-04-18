package tech.przybysz.pms.productsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.przybysz.pms.productsservice.domain.AttributeType;

/**
 * Spring Data  repository for the AttributeType entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AttributeTypeRepository extends JpaRepository<AttributeType, Long> {
}

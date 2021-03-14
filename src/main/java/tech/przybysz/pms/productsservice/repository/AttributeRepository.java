package tech.przybysz.pms.productsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.przybysz.pms.productsservice.domain.Attribute;

/**
 * Spring Data  repository for the Attribute entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long> {
}

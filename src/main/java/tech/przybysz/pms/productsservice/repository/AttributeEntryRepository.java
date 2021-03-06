package tech.przybysz.pms.productsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.przybysz.pms.productsservice.domain.AttributeEntry;

/**
 * Spring Data  repository for the AttributeEntry entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AttributeEntryRepository extends JpaRepository<AttributeEntry, Long> {
}

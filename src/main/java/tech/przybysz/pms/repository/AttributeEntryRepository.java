package tech.przybysz.pms.repository;

import tech.przybysz.pms.domain.AttributeEntry;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AttributeEntry entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AttributeEntryRepository extends JpaRepository<AttributeEntry, Long> {
}

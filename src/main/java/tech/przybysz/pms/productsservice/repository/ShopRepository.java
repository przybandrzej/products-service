package tech.przybysz.pms.productsservice.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.przybysz.pms.productsservice.domain.Shop;

import java.util.Collection;

/**
 * Spring Data  repository for the Shop entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

  Collection<Shop> findAllByNameContainingIgnoreCase(String q, PageRequest pageRequest);
}

package tech.przybysz.pms.productsservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.przybysz.pms.productsservice.domain.Product;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the Product entity.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select distinct product from Product product left join fetch product.category left join fetch product.brand left join fetch product.currency left join fetch product.previewImage left join fetch product.attributeEntries left join fetch product.shops",
        countQuery = "select count(distinct product) from Product product")
    Page<Product> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct product from Product product left join fetch product.category left join fetch product.brand left join fetch product.currency left join fetch product.previewImage left join fetch product.attributeEntries left join fetch product.shops")
    List<Product> findAllWithEagerRelationships();

    @Query("select product from Product product left join fetch product.category left join fetch product.brand left join fetch product.currency left join fetch product.previewImage left join fetch product.attributeEntries left join fetch product.shops where product.id =:id")
    Optional<Product> findOneWithEagerRelationships(@Param("id") Long id);
}

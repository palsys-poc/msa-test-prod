package com.redhat.product;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "product", path = "products")
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    List<Product> findByName(@Param("name") String name);

    Product findById(long id);

}

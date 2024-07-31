package space.bum.social.repo;

import org.springframework.data.repository.CrudRepository;

import space.bum.social.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}

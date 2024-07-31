package space.bum.social.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import space.bum.social.entity.StoreUser;

public interface StoreUserRepository extends CrudRepository<StoreUser, Long> {
  public StoreUser getByUsername(@Param("username") String username);
}

package space.bum.social.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import space.bum.social.entity.StoreUser;
import space.bum.social.repo.StoreUserRepository;

public class StoreUserDetailsService implements UserDetailsService {
  @Autowired
  private StoreUserRepository userRepository;

  @Override
  public StoreUserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {

    StoreUser user = userRepository.getByUsername(username);

    if (user == null) {
      String msg = username + "은 존재하지 않는 사용자입니다.";
      throw new UsernameNotFoundException(msg);
    }
    return new StoreUserDetails(user);
  }

}
package space.bum.social.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import space.bum.social.entity.StoreUser;

@SuppressWarnings("serial")
@AllArgsConstructor
public class StoreUserDetails implements UserDetails {

    private StoreUser storeUser;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var authority = new SimpleGrantedAuthority(storeUser.getRole());
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return storeUser.getPassword();
    }

    @Override
    public String getUsername() {
        return storeUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

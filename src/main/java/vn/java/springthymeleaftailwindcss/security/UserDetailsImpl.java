package vn.java.springthymeleaftailwindcss.security;


import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import vn.java.springthymeleaftailwindcss.entity.User;
import vn.java.springthymeleaftailwindcss.enums.Status;

import java.util.Collection;

@Log4j2
public record UserDetailsImpl(User user) implements org.springframework.security.core.userdetails.UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRole().getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getId())).toList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        if (user.getAccountNonLocked() == null) {
            return true;
        }

        return user.getAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !Status.LOCK.equals(user.getStatus()) && !Status.LOCK.equals(user.getRole().getStatus());
    }
}

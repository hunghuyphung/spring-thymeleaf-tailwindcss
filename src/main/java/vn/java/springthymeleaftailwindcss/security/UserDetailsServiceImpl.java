package vn.java.springthymeleaftailwindcss.security;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import vn.java.springthymeleaftailwindcss.entity.User;
import vn.java.springthymeleaftailwindcss.repository.SystemUserRepository;

@Log4j2
@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final SystemUserRepository systemUserRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!StringUtils.hasText(username)) {
            throw new UsernameNotFoundException(String.format("User not found: '%s'", username));
        }

        var systemUser = systemUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User not found: '%s'", username)));
        trace(systemUser);

        return new UserDetailsImpl(systemUser);
    }

    private void trace(User user) {
        log.info("System user: [id: {},fullName: {},username: {},role: {}]",
                user.getId(), user.getFullName(), user.getUsername(), user.getRoleName());
    }
}

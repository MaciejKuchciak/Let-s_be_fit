package pl.coderslab.letsbefit.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.letsbefit.repository.UserRepository;
import java.util.Collections;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerUserDetailsService implements UserDetailsService {
    private final UserRepository repository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        log.debug("Searching for user by username '{}", login);
        if(!repository.existsByLogin(login)){
            throw new UsernameNotFoundException(String.format("Username %s not found", login));
        }
        pl.coderslab.letsbefit.entity.User userEntity = repository.getByLogin(login);
        return new User(userEntity.getLogin(),
                userEntity.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("USER")));
        //        userEntity.getRoles().stream().
        //       map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    }
}

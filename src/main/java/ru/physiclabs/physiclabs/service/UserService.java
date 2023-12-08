package ru.physiclabs.physiclabs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.physiclabs.physiclabs.model.User;
import ru.physiclabs.physiclabs.repository.UserRepository;
import ru.physiclabs.physiclabs.service.impl.UserDetailsImpl;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found!"));
        return UserDetailsImpl.build(user);
    }

    public Boolean existsUserByEmail(String email) {
        return userRepository.existsUserByEmail(email);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}

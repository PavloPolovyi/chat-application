package com.example.chatapp.service;

import com.example.chatapp.exception.AuthenticationException;
import com.example.chatapp.model.User;
import com.example.chatapp.repository.UserRepository;
import com.example.chatapp.security.TokenService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @Override
    public void register(String nickName, String password) {
        Optional<User> userByNickName = userRepository.findUserByNickName(nickName);
        if (userByNickName.isPresent()) {
            throw new AuthenticationException("User with such nick name already exists!");
        }
        User user = new User();
        user.setNickName(nickName);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

    @Override
    public String login(String nickName, String password) {
        Optional<User> userByNickName = userRepository.findUserByNickName(nickName);
        if (userByNickName.isPresent()) {
            User user = userByNickName.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return tokenService.generateToken(user);
            }
        }
        throw new AuthenticationException("Nickname or password are incorrect");
    }
}

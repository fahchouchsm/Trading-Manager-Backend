package fahchouch.trading_manager.service;

import fahchouch.trading_manager.DTO.UserLoginDTO;
import fahchouch.trading_manager.DTO.UserRegisterDTO;
import fahchouch.trading_manager.constant.TIME;
import fahchouch.trading_manager.database.entity.User;
import fahchouch.trading_manager.database.repository.UserRepository;
import fahchouch.trading_manager.mapper.UserMapper;
import fahchouch.trading_manager.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final UserMapper userMapper;

    public AuthService(UserRepository userRepository, BCryptPasswordEncoder encoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.userMapper = userMapper;
    }

    public void register(UserRegisterDTO dto) {
        if (userRepository.existsByEmail((dto.getEmail()))) {
            throw new RuntimeException("Email already in use");
        }

        User user = userMapper.toEntity(dto);
        user.setPassword(encoder.encode(dto.getPassword()));
        userRepository.save(user);
    }


    public String login(UserLoginDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail());
        if (user == null) {
            throw new RuntimeException("User with " + dto.getEmail() + " mail not found.");
        }

        if (!encoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return JwtUtil.genToken(user.getEmail(), TIME.ONEDAY);
    }
}
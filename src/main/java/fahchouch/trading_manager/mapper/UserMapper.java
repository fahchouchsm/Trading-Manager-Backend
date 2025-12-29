package fahchouch.trading_manager.mapper;

import fahchouch.trading_manager.DTO.UserRegisterDTO;
import fahchouch.trading_manager.database.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRegisterDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }
}

package fahchouch.trading_manager.controller;

import fahchouch.trading_manager.DTO.UserLoginDTO;
import fahchouch.trading_manager.DTO.UserRegisterDTO;
import fahchouch.trading_manager.DTO.res.ApiResponse;
import fahchouch.trading_manager.DTO.res.LoginResDTO;
import fahchouch.trading_manager.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Void>> register(@Valid UserRegisterDTO dto) {
        authService.register(dto);
        ApiResponse<Void> res = ApiResponse.success("User created.");
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PostMapping("/loging")
    public ResponseEntity<ApiResponse<LoginResDTO>> loging(@RequestBody UserLoginDTO dto) {
        String token = authService.login(dto);
        ApiResponse<LoginResDTO> res = ApiResponse.success("Login successful.", new LoginResDTO(token));
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}

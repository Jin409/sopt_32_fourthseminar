package sopt.org.FourthSeminar.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.FourthSeminar.common.ApiResponse;
import sopt.org.FourthSeminar.controller.dto.UserRequestDto;
import sopt.org.FourthSeminar.controller.dto.UserResponseDto;
import sopt.org.FourthSeminar.exception.Success;
import sopt.org.FourthSeminar.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<UserResponseDto> create(@RequestBody @Valid final UserRequestDto request) {
        return ApiResponse.success(Success.SIGNUP_SUCCESS, userService.create(request));
    }
}

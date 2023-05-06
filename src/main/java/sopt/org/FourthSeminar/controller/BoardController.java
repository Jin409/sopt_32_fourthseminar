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
import sopt.org.FourthSeminar.controller.dto.BoardRequestDto;
import sopt.org.FourthSeminar.exception.Success;
import sopt.org.FourthSeminar.service.BoardService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(@RequestBody @Valid final BoardRequestDto request) {
        boardService.create(request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }
}
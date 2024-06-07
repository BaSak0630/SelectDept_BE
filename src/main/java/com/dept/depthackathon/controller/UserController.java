package com.dept.depthackathon.controller;

import com.dept.depthackathon.domain.UserEditor;
import com.dept.depthackathon.request.SearchWord;
import com.dept.depthackathon.request.UserCreate;
import com.dept.depthackathon.request.UserListCreate;
import com.dept.depthackathon.request.UserSearch;
import com.dept.depthackathon.response.UserResponse;
import com.dept.depthackathon.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/all")
    public List<UserResponse> getAll() {
        return userService.getAll();
    }

    @GetMapping("/users")
    public List<UserResponse> search(@ModelAttribute SearchWord searchWord) {
        return userService.getSearchList(searchWord.getWord());
    }


    @PostMapping("/users")
    public void post(@RequestBody @Valid UserCreate request) {
        request.validate();
        userService.write(request);
    }

    @GetMapping("/users/{userId}")
    public UserResponse get(@PathVariable Long userId) {
        return userService.get(userId);
    }

    @GetMapping("/users/list")
    public List<UserResponse> getList(@ModelAttribute UserSearch userSearch) {
        return userService.getList(userSearch);
    }

    @PatchMapping("/users/{userId}")
    public void edit(@PathVariable Long userId, @RequestBody @Valid UserEditor request) {
        userService.edit(userId, request);
    }

    @DeleteMapping("/users/{userId}")
    public void delete(@PathVariable Long userId) {
        userService.delete(userId);
    }
}













package com.dept.depthackathon.service;

import com.dept.depthackathon.domain.User;
import com.dept.depthackathon.domain.UserEditor;
import com.dept.depthackathon.exception.UserNotFound;
import com.dept.depthackathon.repository.UserRepository;
import com.dept.depthackathon.request.UserCreate;
import com.dept.depthackathon.request.UserSearch;
import com.dept.depthackathon.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void write(UserCreate userCreate) {
        User user = User.builder()
                .username(userCreate.getUsername())
                .dept(userCreate.getDept())
                .shNum(userCreate.getShNum())
                .location(userCreate.getLocation())
                .phoneNumber(userCreate.getPhoneNumber())
                .build();

        userRepository.save(user);
    }

    public UserResponse get(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .dept(user.getDept())
                .shNum(user.getShNum())
                .location(user.getLocation())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

    public List<UserResponse> getList(UserSearch userSearch) {
        return userRepository.getList(userSearch).stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void edit(Long id, UserEditor userEditor) {
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        UserEditor.UserEditorBuilder editorBuilder = user.toEditor();

        UserEditor postEditor = editorBuilder.username(userEditor.getUsername())
                .dept(userEditor.getDept())
                .shNum(userEditor.getShNum())
                .location(userEditor.getLocation())
                .phoneNumber(userEditor.getPhoneNumber())
                .build();

        user.edit(postEditor);
    }

    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFound::new);

        userRepository.delete(user);
    }

    public  List<UserResponse> getAll(){
        return userRepository.findAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    public List<UserResponse> getSearchList(String word) {
        return userRepository.getSearchList(word).stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }
}











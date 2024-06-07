package com.dept.depthackathon.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserListCreate {
    private List<UserCreate> userCreateList;
}

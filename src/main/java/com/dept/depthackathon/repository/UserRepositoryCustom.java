package com.dept.depthackathon.repository;


import com.dept.depthackathon.domain.User;
import com.dept.depthackathon.request.UserSearch;

import java.util.List;

public interface UserRepositoryCustom {

    List<User> getList(UserSearch postSearch);
    List<User> getSearchList(String word);
}

package com.dept.depthackathon.repository;

import com.dept.depthackathon.domain.QUser;
import com.dept.depthackathon.domain.User;
import com.dept.depthackathon.request.UserSearch;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static com.dept.depthackathon.domain.QUser.user;


@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<User> getList(UserSearch userSerch) {
        return jpaQueryFactory.selectFrom(user)
                .limit(userSerch.getSize())
                .offset(userSerch.getOffset())
                .orderBy(user.id.desc())
                .fetch();
    }

    @Override
    public List<User> getSearchList(String word) {

        return jpaQueryFactory.selectFrom(user)
                .where(eqUsername(word).or(eqDept(word)))
                .fetch();
    }

    private BooleanExpression eqUsername(String word) {
        if(word == null || word.isEmpty()) {
            return null;
        }
        return user.username.eq(word);
    }

    private BooleanExpression eqDept(String word) {
        if(word == null || word.isEmpty()) {
            return null;
        }
        return user.dept.eq(word);
    }

    private BooleanExpression eqShNum(String word) {
        if(word == null || word.isEmpty()) {
            return null;
        }
        return user.shNum.like(word);
    }

    private BooleanExpression eqLocation(String word) {
        if(word == null || word.isEmpty()) {
            return null;
        }
        return user.location.like(word);
    }
}

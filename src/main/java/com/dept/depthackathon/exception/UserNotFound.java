package com.dept.depthackathon.exception;

/**
 * status -> 404
 */
public class UserNotFound extends DeptException {

    private static final String MESSAGE = "존재하지 않는 유저입니다.";

    public UserNotFound() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 404;
    }
}

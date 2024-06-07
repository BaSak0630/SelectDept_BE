package com.dept.depthackathon.response;

import com.dept.depthackathon.domain.User;
import lombok.Builder;
import lombok.Getter;

/**
 * 서비스 정책에 맞는 클래스
 */
@Getter
public class UserResponse {

    private final Long id;

    private String username;

    private String dept;

    private String shNum;

    private String location;

    private String phoneNumber;

    // 생성자 오버로딩
    public UserResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.dept = user.getDept();
        this.shNum = user.getShNum();
        this.location = user.getLocation();
        this.phoneNumber = user.getPhoneNumber();
    }

    @Builder
    public UserResponse(Long id, String username, String dept, String shNum, String location, String phoneNumber) {
        this.id = id;
        this.username = username.substring(0, Math.min(username.length(), 10));
        this.dept = dept.substring(0, Math.min(dept.length(), 10));
        this.shNum = shNum.substring(0, Math.min(shNum.length(), 10));
        this.location = location.substring(0, Math.min(location.length(), 10));
        this.phoneNumber = phoneNumber.substring(0, Math.min(phoneNumber.length(), 10));
    }
}

package com.dept.depthackathon.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String dept;

    private String shNum;

    private String location;

    private String phoneNumber;

    @Builder
    public User(String username, String dept, String shNum, String location, String phoneNumber) {
        this.username = username;
        this.dept = dept;
        this.shNum = shNum;
        this.location = location;
        this.phoneNumber = phoneNumber;
    }
    public UserEditor.UserEditorBuilder toEditor(){
        return UserEditor.builder()
                .username(username)
                .dept(dept)
                .shNum(shNum)
                .location(location)
                .phoneNumber(phoneNumber);
    }

    public void edit(UserEditor userEditor) {
        this.username = userEditor.getUsername();
        this.dept = userEditor.getDept();
        this.shNum = userEditor.getShNum();
        this.location = userEditor.getLocation();
        this.phoneNumber = userEditor.getPhoneNumber();
    }
}










package com.dept.depthackathon.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class UserEdit {
    private String username; //20

    private String dept; //15

    private String shNum; //9

    private String location; //5

    private String phoneNumber; //9

    @Builder
    public UserEdit(String username, String dept, String shNum, String location, String phoneNumber) {
        this.username = username;
        this.dept = dept;
        this.shNum = shNum;
        this.location = location;
        this.phoneNumber = phoneNumber;
    }
}

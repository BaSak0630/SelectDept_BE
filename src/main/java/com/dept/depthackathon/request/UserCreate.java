package com.dept.depthackathon.request;

import com.dept.depthackathon.exception.InvalidRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class UserCreate {

    private String username; //20

    private String dept; //15

    private String shNum; //9

    private String location; //5

    private String phoneNumber; //9

    @Builder
    public UserCreate(String username, String dept, String shNum, String location, String phoneNumber) {
        this.username = username;
        this.dept = dept;
        this.shNum = shNum;
        this.location = location;
        this.phoneNumber = phoneNumber;
    }

    public void validate() {
        if (username.length() > 20) {
            throw new InvalidRequest("username", "이름 길이 체크 해주세요");
        }else if(dept.length() > 15) {
            throw new InvalidRequest("dept", "dept 길이 체크 해주세요");
        }
        else if(shNum.length() > 9) {
            throw new InvalidRequest("shNum", "shNum 길이 체크 해주세요");
        }
        else if(location.length() > 5) {
            throw new InvalidRequest("location", "location 길이 체크 해주세요");
        }
        else if(phoneNumber.length() > 15) {
            throw new InvalidRequest("phoneNumber", "phoneNumber 길이 체크 해주세요");
        }

    }


}

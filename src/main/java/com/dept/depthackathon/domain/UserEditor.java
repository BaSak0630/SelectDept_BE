package com.dept.depthackathon.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserEditor {

    private String username;

    private String dept;

    private String shNum;

    private String location;

    private String phoneNumber;

    @Builder
    public UserEditor(String username, String dept, String shNum, String location, String phoneNumber) {
        this.username = username;
        this.dept = dept;
        this.shNum = shNum;
        this.location = location;
        this.phoneNumber = phoneNumber;
    }
    public static UserEditorBuilder builder() {
        return new UserEditorBuilder();
    }

    public static class UserEditorBuilder {
        private String username;

        private String dept;

        private String shNum;

        private String location;

        private String phoneNumber;

        UserEditorBuilder() {
        }

        public UserEditorBuilder username(final String username) {
            if (username != null) {
                this.username = username;
            }
            return this;
        }

        public UserEditorBuilder dept(final String dept) {
            if (dept != null) {
                this.dept = dept;
            }
            return this;
        }

        public UserEditorBuilder shNum(final String shNum) {
            if (shNum != null) {
                this.shNum = shNum;
            }
            return this;
        }

        public UserEditorBuilder location(final String location) {
            if (location != null) {
                this.location = location;
            }
            return this;
        }

        public UserEditorBuilder phoneNumber(final String phoneNumber) {
            if (phoneNumber != null) {
                this.phoneNumber = phoneNumber;
            }
            return this;
        }


        public UserEditor build() {
            return new UserEditor(this.username, this.dept, this.shNum, this.location, this.phoneNumber);
        }

        public String toString() {
            return "PostEditor.PostEditorBuilder(username=" + this.username + ", dept=" + this.dept + ", shNum=" + this.shNum + ", location=" + this.location + ", phoneNumber=" + this.phoneNumber + ")";
        }
    }
}

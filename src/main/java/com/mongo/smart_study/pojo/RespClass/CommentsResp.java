package com.mongo.smart_study.pojo.RespClass;

import com.mongo.smart_study.pojo.ClassComments;

public class CommentsResp {
        private String nickName;
        private ClassComments classComments;

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public ClassComments getClassComments() {
            return classComments;
        }

        public void setClassComments(ClassComments classComments) {
            this.classComments = classComments;
        }

    public CommentsResp(String nickName, ClassComments classComments) {
        this.nickName = nickName;
        this.classComments = classComments;
    }
}

package com.hzq.domain;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Auther: blue
 * @Date: 2019/10/15
 * @Description: 跟安卓交互的消息表
 * @version: 1.0
 */
public class Content implements Serializable {
        /*
        通知类型 --- 后台发送通知告诉安卓
         apply---对应好友申请通知--》安卓对应进行有好友申请的通知
         friend---对应好友通过通知--》安坐对应发布消息
         */
        private String notice;
        /*
        消息内容
         */
        private String message;
        /*
        发送消息的时间
         */
        private Timestamp time;

        public String getNotice() {
          return notice;
        }

        public void setNotice(String notice) {
          this.notice = notice;
        }

        public String getMessage() {
          return message;
        }

        public void setMessage(String message) {
          this.message = message;
        }

        public Timestamp getTime() {
          return time;
        }

        public void setTime(Timestamp time) {
          this.time = time;
        }

        public String toJson(){
          return gson.toJson(this);
        }

        private static Gson gson = new Gson();


    public static void main(String[] args) {
        Content content = new Content();
        content.setNotice("fsfsd");
        content.setMessage("sdfsd");
        content.setTime(new Timestamp(System.currentTimeMillis()));
        System.out.println(content.toJson()); //这个对于时间是转换为字符串
        System.out.println(JSON.toJSON(content)); //这个对于时间是转换为long
    }
}
package com.hzq.vo;

import com.hzq.domain.Apply;
import com.hzq.domain.Content;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Auther: blue
 * @Date: 2019/10/18
 * @Description: com.hzq.vo
 * @version: 1.0
 */
public class CommonResult implements Serializable {

    private List<SendMessage> contentList;

    public List<SendMessage> getContentList() {
        return contentList;
    }

    public void setContentList(List<SendMessage> contentList) {
        this.contentList = contentList;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                ", contentList=" + contentList +
                '}';
    }


}

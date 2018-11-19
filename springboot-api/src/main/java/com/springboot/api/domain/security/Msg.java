package com.springboot.api.domain.security;

/**
 * @author 章辉勇
 * @创建时间 2018年11月19日
 * @描述: 用来做权限测试的数据展示
 **/

public class Msg {
    /**
     * 标题
     * */
    private String title;
    /**
     * 内容
     * */
    private String content;
    private String etraInfo;


    public Msg() {
    }

    public Msg(String title, String content, String etraInfo) {
        super();
        this.title = title;
        this.content = content;
        this.etraInfo = etraInfo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEtraInfo() {
        return etraInfo;
    }

    public void setEtraInfo(String etraInfo) {
        this.etraInfo = etraInfo;
    }
}

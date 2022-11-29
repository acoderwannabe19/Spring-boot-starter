package com.example.demo.practice;

public class Info {
    private String content;

    @Override
    public String toString() {
        return "Info{" +
                "content='" + content + '\'' +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Info() {
    }
}

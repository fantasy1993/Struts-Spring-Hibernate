package com.web.model;

/**
 * Created by zhuxinquan on 6/14/17.
 */
public class LeaveMessage {
    private String something;
    private String time;

    @Override
    public String toString() {
        return "LeaveMessage{" +
                "something='" + something + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSomething() {

        return something;
    }

    public void setSomething(String something) {
        this.something = something;
    }
}

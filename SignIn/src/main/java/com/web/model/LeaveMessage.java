package com.web.model;

/**
 * Created by zhuxinquan on 6/14/17.
 */
public class LeaveMessage {
    private int id;
    private int uid;
    private String something;
    private String time;

    @Override
    public String toString() {
        return "LeaveMessage{" +
                "id=" + id +
                ", uid=" + uid +
                ", something='" + something + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

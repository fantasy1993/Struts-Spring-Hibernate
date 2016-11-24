package com.chinasei.hibernate.mode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhuxinquan on 16-11-9.
 */

public class School {
    private int schoolId;
    private String schoolName;
    private String schoolAddress;
    private Set student = new HashSet<>();

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public Set getStudent() {
        return student;
    }

    public void setStudent(Set student) {
        this.student = student;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        School that = (School) o;

        if (schoolId != that.schoolId) return false;
        if (schoolName != null ? !schoolName.equals(that.schoolName) : that.schoolName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = schoolId;
        result = 31 * result + (schoolName != null ? schoolName.hashCode() : 0);
        return result;
    }
}

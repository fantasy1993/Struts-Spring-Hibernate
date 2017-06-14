package com.web.dao;

import com.web.model.LeaveMessage;
import org.springframework.stereotype.Repository;

/**
 * Created by zhuxinquan on 6/14/17.
 */
@Repository("AskLeaveDao")
public interface AskLeaveDao {
    public void insertLeaveMessage(LeaveMessage leaveMessage);
}

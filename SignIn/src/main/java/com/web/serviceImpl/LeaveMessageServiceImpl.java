package com.web.serviceImpl;

import com.web.dao.AskLeaveDao;
import com.web.model.LeaveMessage;
import com.web.service.LeaveMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhuxinquan on 6/14/17.
 */
@Service
public class LeaveMessageServiceImpl implements LeaveMessageService{

    @Autowired
    AskLeaveDao askLeaveDao;

    public void insertLeaveMessage(LeaveMessage leaveMessage) {
        askLeaveDao.insertLeaveMessage(leaveMessage);
    }
}

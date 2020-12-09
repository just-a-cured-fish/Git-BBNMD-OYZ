package com.yc.bbnmd.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ViewServiceImpl implements ViewService{
    @Override
    public void getBoardAndTopic() {

    }
    //uid-uname
    @Override
    public void getTopicByBid(Integer bid) {

    }

    //uid->uname
    @Override
    public void getTopicByPage(Integer id) {

    }
    //topic+repaly(uid-uname)
    @Override
    public void getTopic(Integer id) {

    }
}

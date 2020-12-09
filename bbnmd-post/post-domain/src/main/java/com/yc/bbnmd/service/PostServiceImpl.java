package com.yc.bbnmd.service;

import com.yc.bbnmd.entity.Replay;
import com.yc.bbnmd.entity.Topic;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostServiceImpl implements PostService{
    @Override
    public void postTopic(Topic topic) {

    }

    @Override
    public void postReplay(Replay replay) {

    }
}

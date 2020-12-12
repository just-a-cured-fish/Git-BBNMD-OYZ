package com.yc.bbnmd.service;

import com.yc.bbnmd.dao.impl.ReplayMapper;
import com.yc.bbnmd.entity.Replay;
import com.yc.bbnmd.entity.Topic;
import com.yc.bbnmd.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class PostServiceImpl implements PostService{
    @Autowired(required = false)
    private ReplayMapper replayMapper;


    @Override
    public void postTopic(Topic topic) {

    }

    @Override
    public void postReplay(Replay replay) {

    }

    @Override
    public int update(Replay replay) {
        replay.setModifytime(CommonUtils.formatDateTime(new Date()));
        return replayMapper.updateByPrimaryKey(replay);
    }

}

package com.yc.bbnmd.service;

import com.yc.bbnmd.entity.Replay;
import com.yc.bbnmd.entity.Topic;

public interface PostService {
    /**
     * 发布帖子
     * @param topic
     */
    public void postTopic(Topic topic);

    /**
     * 发布评论
     * @param replay
     */
    public void postReplay(Replay replay);

}

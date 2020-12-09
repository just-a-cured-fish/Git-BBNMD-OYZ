package com.yc.bbnmd.service;

public interface ViewService {
    /**
     * 获取首页的所有版块的版块下的前五条帖子
     */
    public void getBoardAndTopic();

    /**
     * 获取指定板块下的所有帖子
     *
     * @param bid
     */
    public void getTopicByBid(Integer bid);


    /**
     * 分页获取指定板块下的帖子
     *
     * @param id
     */
    public void getTopicByPage(Integer id);

    /**
     * 根据id获取帖子详情
     * @param id
     */
    public void getTopic(Integer id);

}
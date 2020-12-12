package com.yc.bbnmd.service;

import com.yc.bbnmd.domain.PageDomain;
import com.yc.bbnmd.domain.ViewDomain;
import com.yc.bbnmd.entity.Board;
import com.yc.bbnmd.entity.Topic;

import java.util.List;
import java.util.Map;

public interface ViewService {
    /**
     * 获取首页的所有版块的版块下的前五条帖子
     * @return
     */
    public List<Board> getBoardAndTopic();

    /**
     * 获取指定板块下的所有帖子
     *
     * @param bid
     */
    public Topic getTopicByBid(Integer bid);




    /**
     * 分页获取指定板块下的帖子
     *
     * @param v
     */
    public PageDomain<ViewDomain> getTopicByPage(ViewDomain v);

    /**
     * 根据id获取帖子详情
     * @param id
     */
    public Topic getTopic(Integer id);


    public int deleteReplay(Integer id);

}
package com.yc.bbnmd1.service;

import com.yc.bbnmd1.domain.PageDomain;
import com.yc.bbnmd1.domain.ViewDomain;
import com.yc.bbnmd1.entity.Board;
import com.yc.bbnmd1.entity.Topic;

import java.util.List;

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
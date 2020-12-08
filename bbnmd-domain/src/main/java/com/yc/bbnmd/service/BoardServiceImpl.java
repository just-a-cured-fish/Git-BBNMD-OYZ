package com.yc.bbnmd.service;

import com.yc.bbnmd.dao.impl.BoardMapper;
import com.yc.bbnmd.entity.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
@Service
@Transactional
public class BoardServiceImpl implements BoardService{
    @Autowired(required = false)
    private BoardMapper boardMapper;
    @Override
    public void save(Board board) {
        //String title,String content,Integer tid,Integer uid
        Board boardBean = new Board(board.getBname(),board.getParentid());
        this.boardMapper.insert(boardBean);
        board.setBid(boardBean.getBid());
    }

    @Override
    public void delete(Integer id) {
        this.boardMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Board findOne(Integer id) {
        return this.boardMapper.selectByPrimaryKey(id);
    }
}

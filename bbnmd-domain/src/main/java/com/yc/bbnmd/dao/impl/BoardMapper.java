package com.yc.bbnmd.dao.impl;

import com.yc.bbnmd.dao.MisBaseMapper;
import com.yc.bbnmd.entity.Board;
import com.yc.bbnmd.entity.Topic;
import org.apache.ibatis.annotations.Mapper;

@Mapper  //具体操作topic表的mapper
public interface BoardMapper extends MisBaseMapper<Board> {

}

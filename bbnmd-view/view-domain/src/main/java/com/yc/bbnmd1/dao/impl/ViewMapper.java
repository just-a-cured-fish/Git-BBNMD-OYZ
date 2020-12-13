package com.yc.bbnmd1.dao.impl;

import com.yc.bbnmd1.domain.ViewDomain;
import com.yc.bbnmd1.entity.Board;
import com.yc.bbnmd1.entity.View;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface ViewMapper extends BaseMapper<View> {


    @Select(" select a.boardid,boardname,parentid,total ,topicid ,title , date_format(modifytime,'%Y-%m-%d %H:%I:%S') as recentmodifytime ,uname from  " +
            " (select tb_board.boardid,boardname,parentid,count(topicid) as total FROM tb_board left join tb_topic on tb_board.boardid=tb_topic.boardid GROUP BY tb_board.boardid,boardname,parentid)a left join  " +
            " (select topicid,title,a.modifytime,uname,a.boardid from  " +
            " (select boardid,topicid,title,modifytime,uname from tb_topic left join tb_user on tb_topic.uid=tb_user.uid  " +
            " )a,(select boardid,max(modifytime) as modifytime from tb_topic GROUP BY boardid " +
            " )b where a.boardid=b.boardid and a.modifytime =b.modifytime)b on a.boardid=b.boardid ")
    public List<Board> findIndex();


    @SelectProvider(type = SqlMapper.class,method = "SelectByChangeIf")
    public List<ViewDomain> findByPageVO(ViewDomain t);


}

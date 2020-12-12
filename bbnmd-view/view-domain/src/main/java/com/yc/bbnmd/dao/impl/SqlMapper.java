package com.yc.bbnmd.dao.impl;

import com.yc.bbnmd.domain.ViewDomain;
import com.yc.bbnmd.entity.View;

public class SqlMapper {
    public String SelectByChangeIf(ViewDomain t) throws Exception{


        StringBuffer sb=new StringBuffer();
        sb.append(" select b.*,a.total from ( ");
        sb.append("select replay.tid,count(*) as total from replay left join topic ");
        sb.append(" on topic.tid=replay.tid group by replay.tid ) a right join ( " );
        sb.append("select tid,title,content,DATE_FORMAT(publishtime,'%Y-%m-%d %H:%i') as publishtime, ");
        sb.append(" DATE_FORMAT(modifytime,'%Y-%m-%d %H:%i' ) as modifytime,t.uid,b.bid,bname, ");
        sb.append("parentid,uname,upwd,head,DATE_FORMAT(regtime,'%Y-%m-%d %H:%i')as regtime,gender from topic t left join board b on t.bid=b.bid  ");
        sb.append(" left join user u on u.uid=t.uid ) b on a.tid=b.tid where 1=1 ");
        if(null!=t) {
            if(null!=t.getBoardid()) {
                sb.append(" and b.bid= "+t.getBoardid());
            }

        }
        sb.append(" order by b.modifytime desc ");

        return sb.toString();
    }
}

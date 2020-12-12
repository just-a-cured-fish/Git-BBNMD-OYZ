package com.yc.bbnmd.domain;


import com.yc.bbnmd.entity.Board;
import com.yc.bbnmd.entity.Topic;
import lombok.Data;

import java.util.List;


@Data
public class ViewDomain extends PageDomain {

    private Integer topicid;
    private String title;
    private String content;
    private String publishtime;
    private String modifytime;
    private Integer uid;
    private Integer boardid;
    private String boardname;
    private String parentid;
    private String userid;
    private String uname;
    private String upass;
    private String head;
    private String regtime;
    private String gender;
}

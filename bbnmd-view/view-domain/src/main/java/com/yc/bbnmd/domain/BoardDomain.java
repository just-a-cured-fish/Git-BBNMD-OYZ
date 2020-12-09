package com.yc.bbnmd.domain;


import com.yc.bbnmd.entity.Board;
import com.yc.bbnmd.entity.Topic;
import lombok.Data;

import java.util.List;


@Data
public class BoardDomain extends Board {

    private List<Topic> topics;
}

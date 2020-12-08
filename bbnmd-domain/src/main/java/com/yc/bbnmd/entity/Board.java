package com.yc.bbnmd.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data      //  lombok 注解，节省getter, setter
@Table(name = "board")
public class Board {
    @Id  // JPA注解,指定此属性为表中的主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bid;   //注意: 对应的数据表中的字段名叫 book_id
    private String bname;
    private Integer parentid;

    public Board() {

    }

    public Board(String bname, Integer parentid) {
        this.bname = bname;
        this.parentid = parentid;
    }
}
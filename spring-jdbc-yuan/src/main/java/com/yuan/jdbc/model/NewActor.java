package com.yuan.jdbc.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by yuaneg on 2016/8/25.
 */
@Table(name = "sys_user")
public class NewActor implements Serializable{
    @Id
    @Column
    private Long id;
    @Column(name = "real_name")
    private String realName;


    @Override
    public String toString() {
        return "NewActor{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                '}';
    }
}

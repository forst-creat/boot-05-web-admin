package com.atguigu.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuyang
 * @create 2022-06-29-15:13
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    /**
     * 所有属性都应该在数据库中的表中
      */
    @TableField(exist = false)   //表明该属性在表中不存在
    private String userName;
    @TableField(exist = false)
    private String password;


    //以下是数据库字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}

package com.atguigu.admin.mapper;

import com.atguigu.admin.bean.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liuyang
 * @create 2022-07-11-10:09
 */
//@Mapper
public interface AccountMapper {

    public Account getAcct(Long id);
}

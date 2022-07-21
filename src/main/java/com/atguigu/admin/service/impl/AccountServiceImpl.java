package com.atguigu.admin.service.impl;

import com.atguigu.admin.bean.Account;
import com.atguigu.admin.mapper.AccountMapper;
import com.atguigu.admin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyang
 * @create 2022-07-11-10:38
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    public Account getAcctById(Long id) {
      return accountMapper.getAcct(id);
    }
}

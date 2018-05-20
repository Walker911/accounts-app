package com.walker.accountsapp.service.impl;

import com.walker.accountsapp.dao.AccountDao;
import com.walker.accountsapp.entity.Account;
import com.walker.accountsapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account save(Account account) {
        return accountDao.save(account);
    }

    @Override
    public List<Account> getAccounts() {
        return accountDao.findAll();
    }

    @Override
    public void remove(Long id) {
        accountDao.deleteById(id);
    }
}

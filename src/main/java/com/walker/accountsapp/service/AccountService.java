package com.walker.accountsapp.service;

import com.walker.accountsapp.entity.Account;

import java.util.List;

public interface AccountService {
    Account save(Account account);
    List<Account> getAccounts();
    void remove(Long id);
}

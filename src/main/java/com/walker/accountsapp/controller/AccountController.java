package com.walker.accountsapp.controller;

import com.walker.accountsapp.common.Constants;
import com.walker.accountsapp.common.ResultHandler;
import com.walker.accountsapp.entity.Account;
import com.walker.accountsapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "records")
    public ResultHandler<Account> addAccount(@RequestBody Account account) {
        return new ResultHandler<>(Constants.SUCCESS, "", accountService.save(account));
    }

    @GetMapping(value = "records")
    public ResultHandler<List<Account>> getAccounts() {
        return new ResultHandler<>(Constants.SUCCESS, "", accountService.getAccounts());
    }

    @PutMapping(value = "records/{id}")
    public ResultHandler<Account> updateAccount(@PathVariable Long id, @RequestBody Account account) {
        account.setId(id);
        return new ResultHandler<>(Constants.SUCCESS, "", accountService.save(account));
    }

    @DeleteMapping(value = "records/{id}")
    public ResultHandler<Boolean> removeAccount(@PathVariable Long id) {
        accountService.remove(id);
        return new ResultHandler<>(Constants.SUCCESS, "", true);
    }
}

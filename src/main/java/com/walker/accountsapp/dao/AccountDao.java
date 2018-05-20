package com.walker.accountsapp.dao;

import com.walker.accountsapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Long> {
}

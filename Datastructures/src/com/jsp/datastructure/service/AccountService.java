package com.jsp.datastructure.service;

import com.jsp.datastructure.dto.Account;
import com.jsp.datastructure.dto.AccountDTO;

public interface AccountService 
{
	void processCreateAccount(AccountDTO accountDto);
	Account processGetAccount(AccountDTO accountDto);
	boolean processUpdateAccount(AccountDTO accountDto);
	boolean processDeleteAccount(AccountDTO accountDto);
}


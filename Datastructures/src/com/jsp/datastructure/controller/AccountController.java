package com.jsp.datastructure.controller;

import com.jsp.datastructure.dto.Account;
import com.jsp.datastructure.dto.AccountDTO;
import com.jsp.datastructure.service.impl.AccountServiceImpl;

public class AccountController 
{
	private static final AccountServiceImpl accountServiceImpl = new AccountServiceImpl();

	public void create(AccountDTO accountDTO) 
	{
		accountServiceImpl.processCreateAccount(accountDTO);
	}

	public Account read(AccountDTO accountDTO) 
	{
		return accountServiceImpl.processGetAccount(accountDTO);
	}

	public boolean update(AccountDTO accountDTO)
	{
		return accountServiceImpl.processUpdateAccount(accountDTO);
	}

	public boolean delete(AccountDTO accountDTO) 
	{
		return accountServiceImpl.processDeleteAccount(accountDTO);
	}
}

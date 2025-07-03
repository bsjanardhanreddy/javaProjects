package com.jsp.datastructure.repository;

import java.util.HashMap;
import java.util.Map;

import com.jsp.datastructure.dto.Account;
import com.jsp.datastructure.dto.AccountDTO;

public class AccountRepository 
{
	private static final Map<String, Account> ACCOUNT_MAP = new HashMap<>();

	public void createAccount(Account account) 
	{
		ACCOUNT_MAP.put(account.getAccountNumber(), account);
	}

	public Account readAccount(AccountDTO accountDTO) 
	{
		return ACCOUNT_MAP.get(accountDTO.getAccountNumber());
	}

	public boolean updateAccount(Account account) 
	{
		if (ACCOUNT_MAP.containsKey(account.getAccountNumber())) 
		{
			ACCOUNT_MAP.put(account.getAccountNumber(), account);
			return true;
		}
		return false;
	}

	public boolean deleteAccount(AccountDTO accountDTO) 
	{
		return ACCOUNT_MAP.remove(accountDTO.getAccountNumber()) != null;
	}
}

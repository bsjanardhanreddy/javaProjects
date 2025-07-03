package com.jsp.datastructure.service.impl;

import java.util.Date;

import com.jsp.datastructure.dto.Account;
import com.jsp.datastructure.dto.AccountDTO;
import com.jsp.datastructure.repository.AccountRepository;
import com.jsp.datastructure.service.AccountService;

public class AccountServiceImpl implements AccountService 
{
	private static final AccountRepository accountRepository = new AccountRepository();

	@Override
	public void processCreateAccount(AccountDTO accountDto) 
	{
		Account account = new Account();
		account.setUserName(accountDto.getUserName());
		account.setAccountNumber(accountDto.getAccountNumber());
		account.setBalance(accountDto.getBalance());
		account.setEmail(accountDto.getEmail());
		account.setIfscCode(accountDto.getIfscCode());
		account.setCity(accountDto.getCity());
		account.setCountry(accountDto.getCountry());
		account.setPincode(accountDto.getPincode());
		account.setCreatedDate(new Date());

		accountRepository.createAccount(account);
	}

	@Override
	public Account processGetAccount(AccountDTO accountDto) 
	{
		return accountRepository.readAccount(accountDto);
	}

	@Override
	public boolean processUpdateAccount(AccountDTO accountDto) 
	{
		Account updatedAccount = new Account();
		updatedAccount.setUserName(accountDto.getUserName());
		updatedAccount.setAccountNumber(accountDto.getAccountNumber());
		updatedAccount.setBalance(accountDto.getBalance());
		updatedAccount.setEmail(accountDto.getEmail());
		updatedAccount.setIfscCode(accountDto.getIfscCode());
		updatedAccount.setCity(accountDto.getCity());
		updatedAccount.setCountry(accountDto.getCountry());
		updatedAccount.setPincode(accountDto.getPincode());
		updatedAccount.setCreatedDate(new Date());

		return accountRepository.updateAccount(updatedAccount);
	}

	@Override
	public boolean processDeleteAccount(AccountDTO accountDto)
	{
		return accountRepository.deleteAccount(accountDto);
	}
}

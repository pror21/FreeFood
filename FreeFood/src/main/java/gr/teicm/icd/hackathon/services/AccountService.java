package gr.teicm.icd.hackathon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.teicm.icd.hackathon.models.Account;
import gr.teicm.icd.hackathon.repositories.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public AccountService() {

	}
	
	public boolean insertAccount(Account account) {
		if(accountRepository.findByUsername(account.getUsername()) == null) {
			account.addRole("ROLE_USER");
			accountRepository.insert(account);
			return true;
		}
		else
			return false;
	}
}
package gr.teicm.icd.hackathon.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import gr.teicm.icd.hackathon.models.Account;
import gr.teicm.icd.hackathon.repositories.AccountRepository;

@Service
public class CustomAccountDetailsService implements UserDetailsService {
	
	@Autowired
    private AccountRepository accountRepository;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(account.getUsername(), account.getPassword(), getAuthorities(account));
    }
    
    private List<GrantedAuthority> getAuthorities(Account account) {
        Set<String> roles = account.getRoles();
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}

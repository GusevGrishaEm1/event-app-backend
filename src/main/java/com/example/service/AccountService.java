package com.example.service;

import com.example.entity.Account;
import com.example.entity.Role;
import com.example.model.account.NewAccountDto;
import com.example.model.account.AccountDto;
import com.example.model.auth.AuthDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.repository.AccountRepository;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

        public Account getById(Long id) {
             return accountRepository.findById(id).get();
        }

        public Long delete(Long id) {
            accountRepository.deleteById(id);
            return id;
        }

        public Account getByLogin(String login) {
            return accountRepository.findByLogin(login);
        }

         public Account add(NewAccountDto newAccountDto) {
            if(getByLogin(newAccountDto.getLogin()) == null) {
                newAccountDto.setPassword(passwordEncoder.encode(newAccountDto.getPassword()));
                Account accountEntity = NewAccountDto.toEntity(newAccountDto);
                return accountRepository.save(accountEntity);
            }
            else {
                // throw exception
            }
            return null;
         }

         public Account update(AccountDto accountDto) {
             if(getById(accountDto.getId()) != null) {
                 Account accountEntity = AccountDto.toEntity(accountDto);
                 return accountRepository.save(accountEntity);
             }
             else {
                 // throw exception
             }
             return null;
         }

         public List<Account> getAll() {
             return accountRepository.findAll();
         }

    public Account findByLoginAndPassword(String login, String password) {
        Account account = getByLogin(login);
        if (account != null) {
            if (passwordEncoder.matches(password, account.getPassword())) {
                return account;
            }
        }
        return null;
    }

    public AccountDto registerDefaultUser(AuthDto auth) {
        NewAccountDto newAccount = new NewAccountDto(auth.getLogin(), auth.getPassword(), Role.USER_DEFAULT);
        return AccountDto.toDto(add(newAccount));
    }

    public AccountDto registerBusinessUser(AuthDto auth) {
        NewAccountDto newAccount = new NewAccountDto(auth.getLogin(), auth.getPassword(), Role.USER_BUSINESS);
        return AccountDto.toDto(add(newAccount));
    }
}

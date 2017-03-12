package runner_api.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import runner_api.account.domain.Account;
import runner_api.account.repo.AccountRepository;
import runner_api.error.ErrorCode;
import runner_api.error.RestError;

/**
 * Created by yeleilu on 11/03/2017.
 */
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepo;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Iterable<Account> listAll() {
        return accountRepo.findAll();
    }

    @Override
    public Account getById(int id) throws RestError {
        Account account = accountRepo.getById(id);
        if (account == null) {
            throw new RestError(ErrorCode.ENTITY_NOT_FOUND, "Account not found!");
        }
        return account;
    }

    @Override
    public Account create(Account account) throws RestError{
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        Account createdAccount = accountRepo.save(account);
        return accountRepo.getById(createdAccount.getId());
    }

    @Override
    public Account update(Integer id, Account account) throws RestError{
        if (accountRepo.getById(id) == null) {
            throw new RestError(ErrorCode.ENTITY_NOT_FOUND, "Account not found!");
        }
        account.setId(id);
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        Account updatedAccount = accountRepo.save(account);
        return accountRepo.getById(updatedAccount.getId());
    }

    @Override
    public void delete(Integer id) throws RestError {
        accountRepo.delete(id);
    }
}


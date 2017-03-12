package runner_api.account.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import runner_api.account.domain.Account;
import runner_api.account.domain.AccountRest;
import runner_api.account.service.AccountService;
import runner_api.error.RestError;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity listAll() {
        try {
            Iterable<Account> list = accountService.listAll();
            return new ResponseEntity(list, HttpStatus.OK);
        }
        catch (RestError restError) {
            return new ResponseEntity(restError, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable Integer id) {
        try {
            Account account = accountService.getById(id);
            return new ResponseEntity(mapToRest(account), HttpStatus.OK);
        }
        catch (RestError restError) {
            return new ResponseEntity(restError, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody AccountRest accountRest) {
        try {
            Account account = accountService.create(mapFromRest(accountRest));
            return new ResponseEntity(mapToRest(account), HttpStatus.OK);
        }
        catch (RestError restError) {
            return new ResponseEntity(restError, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable Integer id, @RequestBody AccountRest accountRest) {
        try {
            Account account = accountService.update(id, mapFromRest(accountRest));
            return new ResponseEntity(mapToRest(account), HttpStatus.OK);
        }
        catch (RestError restError) {
            return new ResponseEntity(restError, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            accountService.delete(id);
            return new ResponseEntity("AccountRest deleted successfully", HttpStatus.OK);
        }
        catch (RestError restError) {
            return new ResponseEntity(restError, HttpStatus.BAD_REQUEST);
        }
    }

    private static Account mapFromRest (AccountRest accountRest) {
        Account account = new Account();
        account.setId(accountRest.getId());
        account.setName(accountRest.getName());
        account.setEmail(accountRest.getEmail());
        account.setPassword(accountRest.getPassword());

        return account;
    }

    private static AccountRest mapToRest (Account account) {
        return new AccountRest(account.getId(), account.getName(), account.getEmail(), account.getPassword());
    }
}

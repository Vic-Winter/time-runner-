package runner_api.account.service;

import runner_api.account.domain.Account;
import runner_api.error.RestError;

/**
 * Created by yeleilu on 12/03/2017.
 */
public interface AccountService {
    Iterable<Account> listAll() throws RestError;
    Account getById(int id) throws RestError;
    Account create(Account account) throws RestError;
    Account update(Integer id, Account account) throws RestError;
    void delete(Integer id) throws RestError;
}

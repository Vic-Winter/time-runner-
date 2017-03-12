package runner_api.account.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import runner_api.account.domain.Account;

/**
 * Created by yeleilu on 12/03/2017.
 */
@RepositoryRestResource(collectionResourceRel = "account", path = "accounts")
public interface AccountRepository extends CrudRepository<Account, Integer> {
    /**
     * Method that returns an account doing a search by the passed id parameter.
     *
     * @param id
     * @return account of the id passed as parameter.
     * */
    Account getById(@Param("id") Integer id);
}

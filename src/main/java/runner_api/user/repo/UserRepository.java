package runner_api.user.repo;

import org.springframework.data.repository.CrudRepository;

import runner_api.user.domain.User;

/**
 * Created by yeleilu on 12/03/2017.
 */
public interface UserRepository extends CrudRepository<User, String> {

}

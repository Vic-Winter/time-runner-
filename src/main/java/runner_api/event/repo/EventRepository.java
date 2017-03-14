package runner_api.event.repo;

import org.springframework.data.repository.CrudRepository;

import runner_api.event.domain.Event;


/**
 * Created by yeleilu on 12/03/2017.
 */
public interface EventRepository extends CrudRepository<Event, Integer> {

}

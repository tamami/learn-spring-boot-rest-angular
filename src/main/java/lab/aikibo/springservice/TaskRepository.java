package lab.aikibo.springservice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by tamami on 11/12/16.
 */
@RepositoryRestResource
public interface TaskRepository extends CrudRepository<Task, Integer> {

  List<Task> findByTaskArchived(@Param("archivedfalse") int taskArchivedFalse);
  List<Task> findByTaskStatus(@Param("status") String taskStatus);

}

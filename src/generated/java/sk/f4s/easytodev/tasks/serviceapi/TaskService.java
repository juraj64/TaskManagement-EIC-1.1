package sk.f4s.easytodev.tasks.serviceapi;

import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.context.ServiceContext;
import sk.f4s.easytodev.tasks.domain.Task;
import sk.f4s.easytodev.tasks.exception.TaskNotFoundException;

/**
 * Generated interface for the Service TaskService.
 */
public interface TaskService {

	public final static String BEAN_ID = "taskService";

	public List<Task> findByCondition(ServiceContext ctx, List<ConditionalCriteria> condition);

	public Task findById(ServiceContext ctx, Long id) throws TaskNotFoundException;

	public List<Task> findAll(ServiceContext ctx);

	public Task save(ServiceContext ctx, Task entity);

	public void delete(ServiceContext ctx, Task entity);

}

package sk.f4s.easytodev.tasks.domain;

import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import sk.f4s.easytodev.tasks.domain.Task;
import sk.f4s.easytodev.tasks.exception.TaskNotFoundException;

/**
 * Generated interface for Repository for Task
 */
public interface TaskRepository {

	public final static String BEAN_ID = "taskRepository";

	public List<Task> findByCondition(List<ConditionalCriteria> condition);

	public Task findById(Long id) throws TaskNotFoundException;

	public List<Task> findAll();

	public Task save(Task entity);

	public void delete(Task entity);

}

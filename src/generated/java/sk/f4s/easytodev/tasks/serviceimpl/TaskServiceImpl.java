package sk.f4s.easytodev.tasks.serviceimpl;

import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.context.ServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.f4s.easytodev.tasks.domain.Task;
import sk.f4s.easytodev.tasks.domain.TaskRepository;
import sk.f4s.easytodev.tasks.exception.TaskNotFoundException;
import sk.f4s.easytodev.tasks.serviceapi.TaskService;

/**
 * Implementation of TaskService.
 */
@Service("taskService")
public class TaskServiceImpl implements TaskService {

	public TaskServiceImpl() {
	}

	@Autowired
	private TaskRepository taskRepository;

	protected TaskRepository getTaskRepository() {
		return taskRepository;
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.TaskRepository#findByCondition}
	 */
	public List<Task> findByCondition(ServiceContext ctx, List<ConditionalCriteria> condition) {
		return taskRepository.findByCondition(condition);
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.TaskRepository#findById}
	 */
	public Task findById(ServiceContext ctx, Long id) throws TaskNotFoundException {
		return taskRepository.findById(id);
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.TaskRepository#findAll}
	 */
	public List<Task> findAll(ServiceContext ctx) {
		return taskRepository.findAll();
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.TaskRepository#save}
	 */
	public Task save(ServiceContext ctx, Task entity) {
		return taskRepository.save(entity);
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.TaskRepository#delete}
	 */
	public void delete(ServiceContext ctx, Task entity) {
		taskRepository.delete(entity);
	}

}

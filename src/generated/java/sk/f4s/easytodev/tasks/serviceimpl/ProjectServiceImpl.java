package sk.f4s.easytodev.tasks.serviceimpl;

import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.context.ServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.f4s.easytodev.tasks.domain.Project;
import sk.f4s.easytodev.tasks.domain.ProjectRepository;
import sk.f4s.easytodev.tasks.exception.ProjectNotFoundException;
import sk.f4s.easytodev.tasks.serviceapi.ProjectService;

/**
 * Implementation of ProjectService.
 */
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	public ProjectServiceImpl() {
	}

	@Autowired
	private ProjectRepository projectRepository;

	protected ProjectRepository getProjectRepository() {
		return projectRepository;
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.ProjectRepository#findByCondition}
	 */
	public List<Project> findByCondition(ServiceContext ctx, List<ConditionalCriteria> condition) {
		return projectRepository.findByCondition(condition);
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.ProjectRepository#findById}
	 */
	public Project findById(ServiceContext ctx, Long id) throws ProjectNotFoundException {
		return projectRepository.findById(id);
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.ProjectRepository#findAll}
	 */
	public List<Project> findAll(ServiceContext ctx) {
		return projectRepository.findAll();
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.ProjectRepository#save}
	 */
	public Project save(ServiceContext ctx, Project entity) {
		return projectRepository.save(entity);
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.ProjectRepository#delete}
	 */
	public void delete(ServiceContext ctx, Project entity) {
		projectRepository.delete(entity);
	}

}

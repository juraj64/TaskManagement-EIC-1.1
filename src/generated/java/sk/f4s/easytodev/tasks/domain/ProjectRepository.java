package sk.f4s.easytodev.tasks.domain;

import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import sk.f4s.easytodev.tasks.domain.Project;
import sk.f4s.easytodev.tasks.exception.ProjectNotFoundException;

/**
 * Generated interface for Repository for Project
 */
public interface ProjectRepository {

	public final static String BEAN_ID = "projectRepository";

	public List<Project> findByCondition(List<ConditionalCriteria> condition);

	public Project findById(Long id) throws ProjectNotFoundException;

	public List<Project> findAll();

	public Project save(Project entity);

	public void delete(Project entity);

}

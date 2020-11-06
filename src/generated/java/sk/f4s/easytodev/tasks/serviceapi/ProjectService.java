package sk.f4s.easytodev.tasks.serviceapi;

import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.context.ServiceContext;
import sk.f4s.easytodev.tasks.domain.Project;
import sk.f4s.easytodev.tasks.exception.ProjectNotFoundException;

/**
 * Generated interface for the Service ProjectService.
 */
public interface ProjectService {

	public final static String BEAN_ID = "projectService";

	public List<Project> findByCondition(ServiceContext ctx, List<ConditionalCriteria> condition);

	public Project findById(ServiceContext ctx, Long id) throws ProjectNotFoundException;

	public List<Project> findAll(ServiceContext ctx);

	public Project save(ServiceContext ctx, Project entity);

	public void delete(ServiceContext ctx, Project entity);

}

package sk.f4s.easytodev.tasks.serviceapi;

import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.context.ServiceContext;
import sk.f4s.easytodev.tasks.domain.Deployment;
import sk.f4s.easytodev.tasks.exception.DeploymentNotFoundException;

/**
 * Generated interface for the Service DeploymentService.
 */
public interface DeploymentService {

	public final static String BEAN_ID = "deploymentService";

	public List<Deployment> findByCondition(ServiceContext ctx, List<ConditionalCriteria> condition);

	public Deployment findById(ServiceContext ctx, Long id) throws DeploymentNotFoundException;

	public List<Deployment> findAll(ServiceContext ctx);

	public Deployment save(ServiceContext ctx, Deployment entity);

	public void delete(ServiceContext ctx, Deployment entity);

}

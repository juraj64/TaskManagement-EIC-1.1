package sk.f4s.easytodev.tasks.domain;

import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import sk.f4s.easytodev.tasks.domain.Deployment;
import sk.f4s.easytodev.tasks.exception.DeploymentNotFoundException;

/**
 * Generated interface for Repository for Deployment
 */
public interface DeploymentRepository {

	public final static String BEAN_ID = "deploymentRepository";

	public List<Deployment> findByCondition(List<ConditionalCriteria> condition);

	public Deployment findById(Long id) throws DeploymentNotFoundException;

	public List<Deployment> findAll();

	public Deployment save(Deployment entity);

	public void delete(Deployment entity);

}

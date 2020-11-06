package sk.f4s.easytodev.tasks.serviceimpl;

import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.context.ServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.f4s.easytodev.tasks.domain.Deployment;
import sk.f4s.easytodev.tasks.domain.DeploymentRepository;
import sk.f4s.easytodev.tasks.exception.DeploymentNotFoundException;
import sk.f4s.easytodev.tasks.serviceapi.DeploymentService;

/**
 * Implementation of DeploymentService.
 */
@Service("deploymentService")
public class DeploymentServiceImpl implements DeploymentService {

	public DeploymentServiceImpl() {
	}

	@Autowired
	private DeploymentRepository deploymentRepository;

	protected DeploymentRepository getDeploymentRepository() {
		return deploymentRepository;
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.DeploymentRepository#findByCondition}
	 */
	public List<Deployment> findByCondition(ServiceContext ctx, List<ConditionalCriteria> condition) {
		return deploymentRepository.findByCondition(condition);
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.DeploymentRepository#findById}
	 */
	public Deployment findById(ServiceContext ctx, Long id) throws DeploymentNotFoundException {
		return deploymentRepository.findById(id);
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.DeploymentRepository#findAll}
	 */
	public List<Deployment> findAll(ServiceContext ctx) {
		return deploymentRepository.findAll();
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.DeploymentRepository#save}
	 */
	public Deployment save(ServiceContext ctx, Deployment entity) {
		return deploymentRepository.save(entity);
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.DeploymentRepository#delete}
	 */
	public void delete(ServiceContext ctx, Deployment entity) {
		deploymentRepository.delete(entity);
	}

}

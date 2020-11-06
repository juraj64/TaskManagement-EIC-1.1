package sk.f4s.easytodev.tasks.serviceimpl;

import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.context.ServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.f4s.easytodev.tasks.domain.Communication;
import sk.f4s.easytodev.tasks.domain.CommunicationRepository;
import sk.f4s.easytodev.tasks.exception.CommunicationNotFoundException;
import sk.f4s.easytodev.tasks.serviceapi.CommunicationService;

/**
 * Implementation of CommunicationService.
 */
@Service("communicationService")
public class CommunicationServiceImpl implements CommunicationService {

	public CommunicationServiceImpl() {
	}

	@Autowired
	private CommunicationRepository communicationRepository;

	protected CommunicationRepository getCommunicationRepository() {
		return communicationRepository;
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.CommunicationRepository#findByCondition}
	 */
	public List<Communication> findByCondition(ServiceContext ctx, List<ConditionalCriteria> condition) {
		return communicationRepository.findByCondition(condition);
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.CommunicationRepository#findById}
	 */
	public Communication findById(ServiceContext ctx, Long id) throws CommunicationNotFoundException {
		return communicationRepository.findById(id);
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.CommunicationRepository#findAll}
	 */
	public List<Communication> findAll(ServiceContext ctx) {
		return communicationRepository.findAll();
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.CommunicationRepository#save}
	 */
	public Communication save(ServiceContext ctx, Communication entity) {
		return communicationRepository.save(entity);
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.CommunicationRepository#delete}
	 */
	public void delete(ServiceContext ctx, Communication entity) {
		communicationRepository.delete(entity);
	}

}

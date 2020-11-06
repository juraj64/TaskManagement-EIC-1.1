package sk.f4s.easytodev.tasks.serviceimpl;

import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.context.ServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.f4s.easytodev.tasks.domain.Useer;
import sk.f4s.easytodev.tasks.domain.UseerRepository;
import sk.f4s.easytodev.tasks.exception.UseerNotFoundException;
import sk.f4s.easytodev.tasks.serviceapi.UseerService;

/**
 * Implementation of UseerService.
 */
@Service("useerService")
public class UseerServiceImpl implements UseerService {

	public UseerServiceImpl() {
	}

	@Autowired
	private UseerRepository useerRepository;

	protected UseerRepository getUseerRepository() {
		return useerRepository;
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.UseerRepository#findByCondition}
	 */
	public List<Useer> findByCondition(ServiceContext ctx, List<ConditionalCriteria> condition) {
		return useerRepository.findByCondition(condition);
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.UseerRepository#findById}
	 */
	public Useer findById(ServiceContext ctx, Long id) throws UseerNotFoundException {
		return useerRepository.findById(id);
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.UseerRepository#findAll}
	 */
	public List<Useer> findAll(ServiceContext ctx) {
		return useerRepository.findAll();
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.UseerRepository#save}
	 */
	public Useer save(ServiceContext ctx, Useer entity) {
		return useerRepository.save(entity);
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.UseerRepository#delete}
	 */
	public void delete(ServiceContext ctx, Useer entity) {
		useerRepository.delete(entity);
	}

}

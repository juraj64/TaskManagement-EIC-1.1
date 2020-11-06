package sk.f4s.easytodev.tasks.domain;

import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import sk.f4s.easytodev.tasks.domain.Communication;
import sk.f4s.easytodev.tasks.exception.CommunicationNotFoundException;

/**
 * Generated interface for Repository for Communication
 */
public interface CommunicationRepository {

	public final static String BEAN_ID = "communicationRepository";

	public List<Communication> findByCondition(List<ConditionalCriteria> condition);

	public Communication findById(Long id) throws CommunicationNotFoundException;

	public List<Communication> findAll();

	public Communication save(Communication entity);

	public void delete(Communication entity);

}

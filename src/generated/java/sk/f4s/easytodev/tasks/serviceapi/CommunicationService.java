package sk.f4s.easytodev.tasks.serviceapi;

import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.context.ServiceContext;
import sk.f4s.easytodev.tasks.domain.Communication;
import sk.f4s.easytodev.tasks.exception.CommunicationNotFoundException;

/**
 * Generated interface for the Service CommunicationService.
 */
public interface CommunicationService {

	public final static String BEAN_ID = "communicationService";

	public List<Communication> findByCondition(ServiceContext ctx, List<ConditionalCriteria> condition);

	public Communication findById(ServiceContext ctx, Long id) throws CommunicationNotFoundException;

	public List<Communication> findAll(ServiceContext ctx);

	public Communication save(ServiceContext ctx, Communication entity);

	public void delete(ServiceContext ctx, Communication entity);

}

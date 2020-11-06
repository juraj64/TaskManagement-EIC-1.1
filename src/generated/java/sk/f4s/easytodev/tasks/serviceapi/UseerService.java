package sk.f4s.easytodev.tasks.serviceapi;

import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.context.ServiceContext;
import sk.f4s.easytodev.tasks.domain.Useer;
import sk.f4s.easytodev.tasks.exception.UseerNotFoundException;

/**
 * Generated interface for the Service UseerService.
 */
public interface UseerService {

	public final static String BEAN_ID = "useerService";

	public List<Useer> findByCondition(ServiceContext ctx, List<ConditionalCriteria> condition);

	public Useer findById(ServiceContext ctx, Long id) throws UseerNotFoundException;

	public List<Useer> findAll(ServiceContext ctx);

	public Useer save(ServiceContext ctx, Useer entity);

	public void delete(ServiceContext ctx, Useer entity);

}

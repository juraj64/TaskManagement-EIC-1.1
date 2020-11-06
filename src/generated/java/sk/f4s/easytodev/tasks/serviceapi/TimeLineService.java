package sk.f4s.easytodev.tasks.serviceapi;

import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.context.ServiceContext;
import sk.f4s.easytodev.tasks.domain.TimeLine;
import sk.f4s.easytodev.tasks.exception.TimeLineNotFoundException;

/**
 * Generated interface for the Service TimeLineService.
 */
public interface TimeLineService {

	public final static String BEAN_ID = "timeLineService";

	public List<TimeLine> findByCondition(ServiceContext ctx, List<ConditionalCriteria> condition);

	public TimeLine findById(ServiceContext ctx, Long id) throws TimeLineNotFoundException;

	public List<TimeLine> findAll(ServiceContext ctx);

	public TimeLine save(ServiceContext ctx, TimeLine entity);

	public void delete(ServiceContext ctx, TimeLine entity);

}

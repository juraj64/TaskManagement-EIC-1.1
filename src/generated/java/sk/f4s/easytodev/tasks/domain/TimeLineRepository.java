package sk.f4s.easytodev.tasks.domain;

import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import sk.f4s.easytodev.tasks.domain.TimeLine;
import sk.f4s.easytodev.tasks.exception.TimeLineNotFoundException;

/**
 * Generated interface for Repository for TimeLine
 */
public interface TimeLineRepository {

	public final static String BEAN_ID = "timeLineRepository";

	public List<TimeLine> findByCondition(List<ConditionalCriteria> condition);

	public TimeLine findById(Long id) throws TimeLineNotFoundException;

	public List<TimeLine> findAll();

	public TimeLine save(TimeLine entity);

	public void delete(TimeLine entity);

}

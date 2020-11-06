package sk.f4s.easytodev.tasks.serviceimpl;

import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.context.ServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.f4s.easytodev.tasks.domain.TimeLine;
import sk.f4s.easytodev.tasks.domain.TimeLineRepository;
import sk.f4s.easytodev.tasks.exception.TimeLineNotFoundException;
import sk.f4s.easytodev.tasks.serviceapi.TimeLineService;

/**
 * Implementation of TimeLineService.
 */
@Service("timeLineService")
public class TimeLineServiceImpl implements TimeLineService {

	public TimeLineServiceImpl() {
	}

	@Autowired
	private TimeLineRepository timeLineRepository;

	protected TimeLineRepository getTimeLineRepository() {
		return timeLineRepository;
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.TimeLineRepository#findByCondition}
	 */
	public List<TimeLine> findByCondition(ServiceContext ctx, List<ConditionalCriteria> condition) {
		return timeLineRepository.findByCondition(condition);
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.TimeLineRepository#findById}
	 */
	public TimeLine findById(ServiceContext ctx, Long id) throws TimeLineNotFoundException {
		return timeLineRepository.findById(id);
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.TimeLineRepository#findAll}
	 */
	public List<TimeLine> findAll(ServiceContext ctx) {
		return timeLineRepository.findAll();
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.TimeLineRepository#save}
	 */
	public TimeLine save(ServiceContext ctx, TimeLine entity) {
		return timeLineRepository.save(entity);
	}

	/**
	 * Delegates to {@link sk.f4s.easytodev.tasks.domain.TimeLineRepository#delete}
	 */
	public void delete(ServiceContext ctx, TimeLine entity) {
		timeLineRepository.delete(entity);
	}

}

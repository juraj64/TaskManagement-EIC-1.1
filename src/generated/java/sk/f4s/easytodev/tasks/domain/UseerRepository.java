package sk.f4s.easytodev.tasks.domain;

import java.util.List;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import sk.f4s.easytodev.tasks.domain.Useer;
import sk.f4s.easytodev.tasks.exception.UseerNotFoundException;

/**
 * Generated interface for Repository for Useer
 */
public interface UseerRepository {

	public final static String BEAN_ID = "useerRepository";

	public List<Useer> findByCondition(List<ConditionalCriteria> condition);

	public Useer findById(Long id) throws UseerNotFoundException;

	public List<Useer> findAll();

	public Useer save(Useer entity);

	public void delete(Useer entity);

}

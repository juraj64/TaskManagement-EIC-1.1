package sk.f4s.easytodev.tasks.serviceapi;

/**
 * Definition of test methods to implement.
 */
public interface CommunicationServiceTestBase {

	public void testOrderByDateDesc() throws Exception;

	public void testOrderByDateAsc() throws Exception;

	public void testOrderByTask() throws Exception;

	public void testOrderByTaskDesc() throws Exception;

	public void testShowByTaskDesc() throws Exception;

	public void testShowByTaskAsc() throws Exception;

	public void testFindByCondition() throws Exception;

	public void testFindById() throws Exception;

	public void testFindAll() throws Exception;

	public void testSave() throws Exception;

	public void testDelete() throws Exception;
}

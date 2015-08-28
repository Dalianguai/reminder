package com.ibm.iga.reminder.service.inter;



import java.util.List;
import com.ibm.iga.reminder.model.ReminderRequest;


public interface IReminderRequestService {
	public long add(ReminderRequest request);
	public ReminderRequest getById(long id);
	public long delete (long id);
	public long update(ReminderRequest request);
	public List<ReminderRequest> getByOwner(String owner);
}

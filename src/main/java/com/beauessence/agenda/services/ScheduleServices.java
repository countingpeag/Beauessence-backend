package com.beauessence.agenda.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauessence.agenda.models.Schedule;
import com.beauessence.agenda.repositories.ScheduleRep;

@Service
public class ScheduleServices {
	
	private ScheduleRep scheduleRep;

	@Autowired
	public ScheduleServices(ScheduleRep scheduleRep) {
		this.scheduleRep=scheduleRep;
	}
	
	public Optional<List<Schedule>> retrieveSchedulesByDate(Optional<Date> date){
		return scheduleRep.findByscheduleDate(date.get());
	}
	
	public List<Schedule> retrieveAllSchedules(){
		return (List<Schedule>) scheduleRep.findAll();
	}
	
	public Schedule appendSchedule(Schedule schedule) {
		return scheduleRep.save(schedule);
	}
	
	public void removeSchedule(Schedule schedule) {
		scheduleRep.delete(schedule);
	}
	
	public Schedule updateSchedule(Schedule schedule) {
		return scheduleRep.save(schedule);
	}
}

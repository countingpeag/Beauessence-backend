package com.beauessence.agenda.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beauessence.agenda.models.Schedule;

@Repository
public interface ScheduleRep extends CrudRepository<Schedule, Integer>{

	public List<Schedule> findByscheduleDate(Date date);
}

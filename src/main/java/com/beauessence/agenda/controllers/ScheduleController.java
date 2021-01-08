package com.beauessence.agenda.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beauessence.agenda.models.Schedule;
import com.beauessence.agenda.services.ScheduleServices;

@RestController
@RequestMapping("schedule")
public class ScheduleController {
	
	private ScheduleServices scheduleServices;
	
	@Autowired
	public ScheduleController(ScheduleServices scheduleServices) {
		this.scheduleServices=scheduleServices;
	}
	
	@GetMapping(value = {"/getSchedules", "/getSchedules/{date}"})
	public ResponseEntity<List<Schedule>> getSchedules(@PathVariable("date") Optional<Date> date){
		if(date.isPresent()) 
			return new ResponseEntity<>(scheduleServices.retrieveSchedulesByDate(date).get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(scheduleServices.retrieveAllSchedules(), HttpStatus.OK);
	}
	
	@PostMapping("/addSchedule")
	public ResponseEntity<Schedule> addSchedule(@Valid @RequestBody Schedule schedule, BindingResult br) {
		return new ResponseEntity<>(scheduleServices.appendSchedule(schedule), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/removeSchedule")
	public ResponseEntity<String> removeSchedule(@Valid @RequestBody Schedule schedule, BindingResult br) {
		scheduleServices.removeSchedule(schedule);
		return new ResponseEntity<>("Id:"+schedule.getIdSchedule(), HttpStatus.OK);
	}
	
	@PutMapping("/updateSchedule")
	public ResponseEntity<Schedule> updateSchedule(@Valid @RequestBody Schedule schedule, BindingResult br) {
		return new ResponseEntity<>(scheduleServices.updateSchedule(schedule), HttpStatus.OK);
	}
}

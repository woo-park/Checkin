package com.microservice.Checkin.component;

import com.microservice.Checkin.domain.CheckInRecord;
import com.microservice.Checkin.repository.CheckinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class CheckinComponent {
	private static final Logger logger = LoggerFactory.getLogger(CheckinComponent.class);

	CheckinRepository checkinRepository;
	Sender sender;
	
	@Autowired
	CheckinComponent(CheckinRepository checkinRepository, Sender sender){
		this.checkinRepository = checkinRepository;
		this.sender = sender;
	}

	public long checkIn(CheckInRecord checkIn) {
		checkIn.setCheckInTime(new Date());
		logger.info("Saving checkin ");

		//save
		CheckInRecord checkInRecord = checkinRepository.save(checkIn);
		long checkedInId = checkInRecord.getId();
		logger.info("Successfully saved checkin ");

		//send a message back to booking to update status
		long bookingId = checkInRecord.getBookingId();
		logger.info("Sending booking id "+ bookingId);
		sender.send(bookingId);

		return checkedInId;
	}
	
	public CheckInRecord getCheckInRecord(long id){
		return checkinRepository.findById(id).get();
	}
	
}	

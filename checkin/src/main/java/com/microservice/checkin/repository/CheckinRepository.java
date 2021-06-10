package com.microservice.checkin.repository;

import com.microservice.checkin.domain.CheckInRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckinRepository extends JpaRepository<CheckInRecord,Long> {

}

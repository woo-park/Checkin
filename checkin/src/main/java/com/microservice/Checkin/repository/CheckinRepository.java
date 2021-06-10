package com.microservice.Checkin.repository;

import com.microservice.Checkin.domain.CheckInRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckinRepository extends JpaRepository<CheckInRecord,Long> {

}

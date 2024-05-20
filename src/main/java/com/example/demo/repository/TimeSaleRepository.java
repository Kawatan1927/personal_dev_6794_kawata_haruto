package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Timesale;

public interface TimeSaleRepository extends JpaRepository<Timesale, Integer> {
	List<Timesale> findByStartTimeBeforeAndEndTimeAfter(LocalDateTime start, LocalDateTime end);

}

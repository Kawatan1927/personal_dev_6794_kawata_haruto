package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Timesale;
import com.example.demo.repository.TimeSaleRepository;

@Service
public class MakeTimesaleList {
	@Autowired
	TimeSaleRepository timeSaleRepository;
	public List<Integer> generate(){
		LocalDateTime now = LocalDateTime.now();
		List<Timesale> timesaleList = timeSaleRepository.findByStartTimeLessThanEqualAndEndTimeGreaterThanEqual(now, now);
		List<Integer> timesaleItemList = new ArrayList<Integer>();
		for (int i = 0; i < timesaleList.size(); i++) {
			timesaleItemList.add(timesaleList.get(i).getItemId());
			
		}
		return timesaleItemList;
	}

}

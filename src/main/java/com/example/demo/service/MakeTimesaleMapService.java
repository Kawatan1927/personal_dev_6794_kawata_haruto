package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Timesale;
import com.example.demo.repository.TimeSaleRepository;

@Service
public class MakeTimesaleMapService {
	@Autowired
	TimeSaleRepository timeSaleRepository;
	public Map<Integer, Double> generate(){
		LocalDateTime now = LocalDateTime.now();
		List<Timesale> timesaleList = timeSaleRepository.findByStartTimeLessThanEqualAndEndTimeGreaterThanEqual(now, now);
		Map<Integer, Double> timesaleMap = new HashMap<Integer, Double>();
		for (int i = 0; i < timesaleList.size(); i++) {
			timesaleMap.put(timesaleList.get(i).getItemId(),timesaleList.get(i).getDiscountPriceRatio());
			
		}
		
		return timesaleMap;
	}

}

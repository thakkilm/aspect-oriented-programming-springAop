package com.mahesh.learnspringaop.aopexample.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.mahesh.learnspringaop.aopexample.data.DataService1;

@Service
public class BusinessService1 {
	DataService1 dataService1;

	public BusinessService1(DataService1 dataService1) {
		super();
		this.dataService1 = dataService1;
	}

	 public int claculateMax() {
		 int[] data=dataService1.retrieveData();
//		 return Arrays.stream(data).max().orElse(0);
		 throw new RuntimeException("Created an exception");
	 }
	
	
}
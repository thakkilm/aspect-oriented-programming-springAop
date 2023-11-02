package com.mahesh.learnspringaop.aopexample.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {
	
	public int[] retrieveData() {
		return new int[] {11,12,13,14};
	}

}

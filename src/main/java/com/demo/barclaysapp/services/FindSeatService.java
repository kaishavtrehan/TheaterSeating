package com.demo.barclaysapp.services;

import java.util.Map;

import com.demo.barclaysapp.dto.OrderDTO;
import com.demo.barclaysapp.dto.TheaterLayoutDTO;
public class FindSeatService{

	public void findSeats(OrderDTO orderDTO, TheaterLayoutDTO theaterLayoutDTO) {
		
		for(Map.Entry<String, Integer> entry: orderDTO.getOrdersMap().entrySet()) {
			if(entry.getValue() <= theaterLayoutDTO.getTotalSeats()) {
				fullFillSeatRequest(orderDTO, theaterLayoutDTO, entry.getValue(), entry.getKey());
				theaterLayoutDTO.setTotalSeats(theaterLayoutDTO.getTotalSeats()-entry.getValue());
			}else {
				orderDTO.getResultsMap().put(entry.getKey(), "Sorry we can't handle your party.");
			}
		}
		
		printResults(orderDTO.getResultsMap());
	}
	
	private void fullFillSeatRequest(OrderDTO orderDTO, TheaterLayoutDTO theaterLayoutDTO, Integer r, String name) {
		
		boolean isSplitParty = false;
		Map<String, String> resultMap =  orderDTO.getResultsMap();
		Map<Integer, Map<Integer, Integer>> rowMap = theaterLayoutDTO.getRowMap();
		
		for (Map.Entry<Integer, Map<Integer, Integer>> entry: rowMap.entrySet()) {
				for(Map.Entry<Integer, Integer> entryObj: entry.getValue().entrySet()) {
						int diff = entryObj.getValue()-r;
						Map<Integer, Integer> sectionMap = rowMap.get(entry.getKey());
							if(diff==1 || diff<0)
								continue;
							else {
									if(resultMap.get(name)==null) {
										resultMap.put(name, "Row "+entry.getKey()+" Section "+entryObj.getKey());
										sectionMap.put(entryObj.getKey(), diff);
										rowMap.put(entry.getKey(),sectionMap);
									}
									isSplitParty =  true;
								}
				}
		}
		
		if (!isSplitParty) {
			resultMap.put(name, "Call to split party.");
		}
	}
	
	private void printResults(Map<String, String> resultMap) {
		for(Map.Entry<String, String> entry:resultMap.entrySet()) {
			System.out.println(entry.getKey()+ " " +entry.getValue());
		}
	}
}

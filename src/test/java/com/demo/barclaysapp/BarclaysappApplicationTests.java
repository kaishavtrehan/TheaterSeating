package com.demo.barclaysapp;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.TreeMap;

import org.junit.Test;

import com.demo.barclaysapp.dto.OrderDTO;
import com.demo.barclaysapp.dto.TheaterLayoutDTO;
import com.demo.barclaysapp.services.FindSeatService;


public class BarclaysappApplicationTests {

	@Test
	public void findSeats() {
		
		TheaterLayoutDTO theaterLayoutDTO = new TheaterLayoutDTO();
		OrderDTO orderDTO =  new OrderDTO();
		FindSeatService findSeatService = new FindSeatService();
		theaterLayoutDTO.setRowMap(new TreeMap<>());
		orderDTO.setOrdersMap(new LinkedHashMap<>());
		orderDTO.setResultsMap(new LinkedHashMap<>());
		
		StringBuilder stringExpectedOutput = new StringBuilder();
		stringExpectedOutput.append("{Smith=Row 1 Section 1, Jones=Row 2 Section 2, Davis=Row 1 Section 2, Wilson=Sorry we can't handle your party., Johnson=Row 2 Section 1, Williams=Row 1 Section 1, Brown=Row 4 Section 2, Miller=Call to split party.}");
		
		StringBuilder stringRowMap = new StringBuilder();
		stringRowMap.append("6 6\n" + 
				"3 5 5 3\n" + 
				"4 6 6 4\n" + 
				"2 8 8 2\n" + 
				"6 6");
		
		setInputRowMap(theaterLayoutDTO, stringRowMap);
		
		StringBuilder stringOrderMap = new StringBuilder();
		stringOrderMap.append("Smith 2\n" + 
				"Jones 5\n" + 
				"Davis 6\n" + 
				"Wilson 100\n" + 
				"Johnson 3\n" + 
				"Williams 4\n" + 
				"Brown 8\n" + 
				"Miller 12");
		setInputOrderMap(orderDTO, stringOrderMap);
		
		findSeatService.findSeats(orderDTO, theaterLayoutDTO);
		
		assertEquals(orderDTO.getResultsMap().toString(), stringExpectedOutput.toString());
	}
	
	public void setInputRowMap(TheaterLayoutDTO theaterLayoutDTO, StringBuilder stringRowMap) {
		String[] rowArr = stringRowMap.toString().split("\n");
		int i = 1;
		for(String row: rowArr) {
			String[] sectionArr = row.split(" ");
			int j = 1;
			theaterLayoutDTO.setSectionMap(new TreeMap<>());
			for(String section: sectionArr) {
				theaterLayoutDTO.getSectionMap().put(j++, Integer.parseInt(section));
				theaterLayoutDTO.setTotalSeats(theaterLayoutDTO.getTotalSeats()+Integer.parseInt(section));
			}
			theaterLayoutDTO.getRowMap().put(i++, theaterLayoutDTO.getSectionMap());
		}
	}
	
	public void setInputOrderMap(OrderDTO orderDTO, StringBuilder stringOrderMap) {
		String[] orderArr = stringOrderMap.toString().split("\n");
		for(String order: orderArr) {
			String[] requestArr = order.split(" ");
			orderDTO.getOrdersMap().put(requestArr[0], Integer.parseInt(requestArr[1]));
		}
	}

}

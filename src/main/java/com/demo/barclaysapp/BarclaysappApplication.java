package com.demo.barclaysapp;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

import com.demo.barclaysapp.dto.OrderDTO;
import com.demo.barclaysapp.dto.TheaterLayoutDTO;
import com.demo.barclaysapp.services.FindSeatService;

/**
 * @author kaishav
 *
 */
public class BarclaysappApplication {
	public static void main(String[] args) {
		startApplication(new TheaterLayoutDTO(), new OrderDTO(), new FindSeatService());
	}

	static void startApplication(TheaterLayoutDTO theaterLayoutDTO, OrderDTO orderDTO,
			FindSeatService findSeatService) {
		
		System.out.println("Enter Input");
		Scanner scanner = new Scanner(System.in);
		int i = 1;
		theaterLayoutDTO.setRowMap(new TreeMap<>());
		orderDTO.setOrdersMap(new LinkedHashMap<>());
		orderDTO.setResultsMap(new LinkedHashMap<>());

		while (scanner.hasNextLine()) {
			String[] temp = scanner.nextLine().split(" ");
			if (temp[0].equals(""))
				break;
			int j = 1;
			theaterLayoutDTO.setSectionMap(new TreeMap<>());
			for (String str : temp) {
				theaterLayoutDTO.getSectionMap().put(j++, Integer.parseInt(str));
				theaterLayoutDTO.setTotalSeats(theaterLayoutDTO.getTotalSeats() + Integer.parseInt(str));
			}
			theaterLayoutDTO.getRowMap().put(i++, theaterLayoutDTO.getSectionMap());
		}

		while (scanner.hasNextLine()) {
			String[] temp = scanner.nextLine().split(" ");
			if (temp[0].equals(""))
				break;
			orderDTO.getOrdersMap().put(temp[0], Integer.parseInt(temp[1]));
		}

		findSeatService.findSeats(orderDTO, theaterLayoutDTO);

		startApplication(new TheaterLayoutDTO(), new OrderDTO(), new FindSeatService());
	}
}

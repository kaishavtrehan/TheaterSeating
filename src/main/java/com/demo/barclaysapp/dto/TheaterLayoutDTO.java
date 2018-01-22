package com.demo.barclaysapp.dto;

import java.util.Map;

/**
 * @author kaishav
 *
 */
public class TheaterLayoutDTO {

	private Map<Integer, Map<Integer, Integer>> rowMap;
	private Map<Integer, Integer> sectionMap;
	private int totalSeats = 0;

	public Map<Integer, Map<Integer, Integer>> getRowMap() {
		return rowMap;
	}

	public void setRowMap(Map<Integer, Map<Integer, Integer>> rowMap) {
		this.rowMap = rowMap;
	}

	public Map<Integer, Integer> getSectionMap() {
		return sectionMap;
	}

	public void setSectionMap(Map<Integer, Integer> sectionMap) {
		this.sectionMap = sectionMap;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

}

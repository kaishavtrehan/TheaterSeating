package com.demo.barclaysapp.dto;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * @author kaishav
 *
 */
@Component
public class OrderDTO {
	private Map<String, Integer> ordersMap;
	private Map<String, String> resultsMap;
	
	
	public Map<String, Integer> getOrdersMap() {
		return ordersMap;
	}
	public void setOrdersMap(Map<String, Integer> ordersMap) {
		this.ordersMap = ordersMap;
	}
	public Map<String, String> getResultsMap() {
		return resultsMap;
	}
	public void setResultsMap(Map<String, String> resultsMap) {
		this.resultsMap = resultsMap;
	}

	
}

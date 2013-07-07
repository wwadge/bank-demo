/**
 * 
 */
package com.yourcompany.demo.controller.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author wwadge
 *
 */
public class CustomerSearchDTO {
	@NotEmpty
	private String searchTerm;
	
	@Min(0) @Max(1)
	private int searchBy;
	/**
	 * @return the searchTerm
	 */
	public String getSearchTerm() {
		return searchTerm;
	}
	/**
	 * @param searchTerm the searchTerm to set
	 */
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	/**
	 * @return the searchBy
	 */
	public int getSearchBy() {
		return searchBy;
	}
	/**
	 * @param searchBy the searchBy to set
	 */
	public void setSearchBy(int searchBy) {
		this.searchBy = searchBy;
	}
}

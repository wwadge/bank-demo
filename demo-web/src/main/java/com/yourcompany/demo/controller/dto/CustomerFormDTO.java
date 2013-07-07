/**
 * 
 */
package com.yourcompany.demo.controller.dto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.common.collect.Sets;
import com.yourname.demo.model.Account;

/**
 * A simple DTO for the customer form.
 * @author wwadge
 *
 */
@Component
@Scope("prototype")
public class CustomerFormDTO {

	private Long id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String surname;
	
	@NotNull
	private String address1Line1;
	
	@NotNull
	private String address1Line2;
	
	@NotNull
	private String address1City;
	
	@NotNull
	private String address1Country;
	
	@NotNull
	private String address2Line1;
	
	@NotNull
	private String address2Line2;
	
	@NotNull
	private String address2City;
	
	@NotNull
	private String address2Country;
	
	@NotNull
	private BigDecimal currentAccountOpeningBalance = BigDecimal.ZERO;
	
	@NotNull
	private BigDecimal savingsAccountOpeningBalance = BigDecimal.ZERO;
	
	private Set<CustomerTransactionsDTO> customerTransactions = Sets.newHashSet();

	private Set<AccountDTO> accounts = Sets.newHashSet();

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * @return the address1Line1
	 */
	public String getAddress1Line1() {
		return address1Line1;
	}
	/**
	 * @param address1Line1 the address1Line1 to set
	 */
	public void setAddress1Line1(String address1Line1) {
		this.address1Line1 = address1Line1;
	}
	/**
	 * @return the address1Line2
	 */
	public String getAddress1Line2() {
		return address1Line2;
	}
	/**
	 * @param address1Line2 the address1Line2 to set
	 */
	public void setAddress1Line2(String address1Line2) {
		this.address1Line2 = address1Line2;
	}
	/**
	 * @return the address1City
	 */
	public String getAddress1City() {
		return address1City;
	}
	/**
	 * @param address1City the address1City to set
	 */
	public void setAddress1City(String address1City) {
		this.address1City = address1City;
	}
	/**
	 * @return the address1Country
	 */
	public String getAddress1Country() {
		return address1Country;
	}
	/**
	 * @param address1Country the address1Country to set
	 */
	public void setAddress1Country(String address1Country) {
		this.address1Country = address1Country;
	}
	/**
	 * @return the address2Line1
	 */
	public String getAddress2Line1() {
		return address2Line1;
	}
	/**
	 * @param address2Line1 the address2Line1 to set
	 */
	public void setAddress2Line1(String address2Line1) {
		this.address2Line1 = address2Line1;
	}
	/**
	 * @return the address2Line2
	 */
	public String getAddress2Line2() {
		return address2Line2;
	}
	/**
	 * @param address2Line2 the address2Line2 to set
	 */
	public void setAddress2Line2(String address2Line2) {
		this.address2Line2 = address2Line2;
	}
	/**
	 * @return the address2City
	 */
	public String getAddress2City() {
		return address2City;
	}
	/**
	 * @param address2City the address2City to set
	 */
	public void setAddress2City(String address2City) {
		this.address2City = address2City;
	}
	/**
	 * @return the address2Country
	 */
	public String getAddress2Country() {
		return address2Country;
	}
	/**
	 * @param address2Country the address2Country to set
	 */
	public void setAddress2Country(String address2Country) {
		this.address2Country = address2Country;
	}
	/**
	 * @return the currentAccountOpeningBalance
	 */
	public BigDecimal getCurrentAccountOpeningBalance() {
		return currentAccountOpeningBalance;
	}
	/**
	 * @param currentAccountOpeningBalance the currentAccountOpeningBalance to set
	 */
	public void setCurrentAccountOpeningBalance(
			BigDecimal currentAccountOpeningBalance) {
		this.currentAccountOpeningBalance = currentAccountOpeningBalance;
	}
	/**
	 * @return the savingsAccountOpeningBalance
	 */
	public BigDecimal getSavingsAccountOpeningBalance() {
		return savingsAccountOpeningBalance;
	}
	/**
	 * @param savingsAccountOpeningBalance the savingsAccountOpeningBalance to set
	 */
	public void setSavingsAccountOpeningBalance(
			BigDecimal savingsAccountOpeningBalance) {
		this.savingsAccountOpeningBalance = savingsAccountOpeningBalance;
	}
	
	
	/**
	 * @return the customerTransactions
	 */
	public Set<CustomerTransactionsDTO> getCustomerTransactions() {
		return customerTransactions;
	}
	/**
	 * @param customerTransactions the customerTransactions to set
	 */
	public void setCustomerTransactions(
			Set<CustomerTransactionsDTO> customerTransactions) {
		this.customerTransactions = customerTransactions;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the accounts
	 */
	public Set<AccountDTO> getAccounts() {
		return accounts;
	}
	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(Set<AccountDTO> accounts) {
		this.accounts = accounts;
	}
	
	

}

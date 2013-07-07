/**
 * 
 */
package com.yourcompany.demo.controller.dto;

import java.math.BigDecimal;

import org.joda.time.DateTime;

import com.yourname.demo.model.enums.db.CustomerTransactionDrcrEnum;

/**
 * @author wwadge
 *
 */
public class CustomerTransactionsDTO {

	private Long id;
	private DateTime transactionDate;
	private CustomerTransactionDrcrEnum drcr;
	private AccountTO destinationAccount;
	private BigDecimal amount;
	/**
	 * @return the transactionDate
	 */
	public DateTime getTransactionDate() {
		return transactionDate;
	}
	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(DateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
	/**
	 * @return the drcr
	 */
	public CustomerTransactionDrcrEnum getDrcr() {
		return drcr;
	}
	/**
	 * @param drcr the drcr to set
	 */
	public void setDrcr(CustomerTransactionDrcrEnum drcr) {
		this.drcr = drcr;
	}
	/**
	 * @return the destinationAccount
	 */
	public AccountTO getDestinationAccount() {
		return destinationAccount;
	}
	/**
	 * @param destinationAccount the destinationAccount to set
	 */
	public void setDestinationAccount(AccountTO destinationAccount) {
		this.destinationAccount = destinationAccount;
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
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}

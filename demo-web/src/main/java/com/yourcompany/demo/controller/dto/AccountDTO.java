/**
 * 
 */
package com.yourcompany.demo.controller.dto;

import java.math.BigDecimal;

import com.yourname.demo.model.enums.db.AccountAcTypeEnum;

/**
 * @author wwadge
 *
 */
public class AccountDTO {

	private Long id;
	private AccountAcTypeEnum acType;
	private BigDecimal balance;
	/**
	 * @return the acType
	 */
	public AccountAcTypeEnum getAcType() {
		return acType;
	}
	/**
	 * @param acType the acType to set
	 */
	public void setAcType(AccountAcTypeEnum acType) {
		this.acType = acType;
	}
	/**
	 * @return the balance
	 */
	public BigDecimal getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
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
	
}

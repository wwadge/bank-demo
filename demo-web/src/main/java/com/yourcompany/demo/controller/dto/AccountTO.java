/**
 * 
 */
package com.yourcompany.demo.controller.dto;

import com.yourname.demo.model.enums.db.AccountAcTypeEnum;

/**
 * @author wwadge
 *
 */
public class AccountTO {
	
	private AccountAcTypeEnum acType;
	private java.math.BigDecimal balance;
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
	public java.math.BigDecimal getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(java.math.BigDecimal balance) {
		this.balance = balance;
	}
}

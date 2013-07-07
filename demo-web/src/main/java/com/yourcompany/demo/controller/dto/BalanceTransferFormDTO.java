/**
 * 
 */
package com.yourcompany.demo.controller.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author wwadge
 *
 */
public class BalanceTransferFormDTO {

	@Min(0)
	@NotNull
	private Long sourceAccount;

	@Min(0)
	@NotNull
	private Long targetAccount;

	@Min(0) @Max(999) @NotNull
	private BigDecimal transferAmount;
	
	@NotNull
	@Min(0)
	private Long customerId;
	
	/**
	 * @return the sourceAccount
	 */
	public Long getSourceAccount() {
		return sourceAccount;
	}
	/**
	 * @param sourceAccount the sourceAccount to set
	 */
	public void setSourceAccount(Long sourceAccount) {
		this.sourceAccount = sourceAccount;
	}
	/**
	 * @return the targetAccount
	 */
	public Long getTargetAccount() {
		return targetAccount;
	}
	/**
	 * @param targetAccount the targetAccount to set
	 */
	public void setTargetAccount(Long targetAccount) {
		this.targetAccount = targetAccount;
	}
	/**
	 * @return the transferAmount
	 */
	public BigDecimal getTransferAmount() {
		return transferAmount;
	}
	/**
	 * @param transferAmount the transferAmount to set
	 */
	public void setTransferAmount(BigDecimal transferAmount) {
		this.transferAmount = transferAmount;
	}
	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
}

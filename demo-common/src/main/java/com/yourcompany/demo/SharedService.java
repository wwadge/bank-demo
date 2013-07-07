/**
 * 
 */
package com.yourcompany.demo;

import java.math.BigDecimal;

import com.yourname.demo.model.Customer;

/**
 * Exposed services.
 * @author wwadge
 *
 */
public interface SharedService {

	Customer getClientByID(Long id);
	Customer getClientByName(String name);
	Long saveOrUpdateClient(Customer customer);
	void balanceTransfer(Long sourceAccount, Long targetAccount, BigDecimal amount);
}

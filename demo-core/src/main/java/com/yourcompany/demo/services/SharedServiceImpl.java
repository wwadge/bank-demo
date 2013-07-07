/**
 * 
 */
package com.yourcompany.demo.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.yourcompany.demo.SharedService;
import com.yourname.demo.model.Account;
import com.yourname.demo.model.Customer;
import com.yourname.demo.service.data.DataLayerDemo;

/**
 * @author wwadge
 *
 */
@Component
public class SharedServiceImpl implements SharedService {

	@Autowired
	DataLayerDemo dataLayer;
	
	/* (non-Javadoc)
	 * @see com.yourcompany.demo.SharedService#getClientByID()
	 */
	@Override
	@Transactional
	public Customer getClientByID(Long id) {
		Preconditions.checkNotNull(id); // safety
		
		return dataLayer.getCustomer(id);
	}

	/* (non-Javadoc)
	 * @see com.yourcompany.demo.SharedService#getClientByName(java.lang.String)
	 */
	@Override
	@Transactional
	public Customer getClientByName(String name) {
		Preconditions.checkNotNull(name); // safety
		
		return (Customer) dataLayer.createQuery("from Customer c where c.name = :name").setParameter("name", name).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.yourcompany.demo.SharedService#SaveOrUpdateClient(com.yourname.demo.model.Customer)
	 */
	@Override
	@Transactional
	public Long saveOrUpdateClient(Customer customer) {
		Preconditions.checkNotNull(customer); // safety
		
		dataLayer.saveOrUpdate(customer);
		return customer.getId();
	}

	/* (non-Javadoc)
	 * @see com.yourcompany.demo.SharedService#balanceTransfer(java.lang.Long, java.lang.Long, java.math.BigDecimal)
	 */
	@Override
	@Transactional
	public void balanceTransfer(Long sourceAccount, Long targetAccount, BigDecimal amount) {
		Account source = dataLayer.getAccount(sourceAccount);
		Account target = dataLayer.getAccount(targetAccount);

		Preconditions.checkNotNull(source); // safety
 		Preconditions.checkNotNull(target); // safety
		Preconditions.checkState(source.getBalance().compareTo(amount) >= 0, "Insufficient Balance"); 
 		
		source.setBalance(source.getBalance().subtract(amount));
		target.setBalance(target.getBalance().add(amount));
		
		dataLayer.saveOrUpdate(source);
		dataLayer.saveOrUpdate(target);
	}

}

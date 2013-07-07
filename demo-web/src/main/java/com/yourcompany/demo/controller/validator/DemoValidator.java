/**
 * 
 */
package com.yourcompany.demo.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.yourcompany.demo.SharedService;
import com.yourcompany.demo.controller.dto.BalanceTransferFormDTO;
import com.yourname.demo.model.Account;
import com.yourname.demo.model.Customer;


/**
 * Called automatically via spring (see InitBinder) to perform extra validation 
 * @author wwadge
 *
 */
@Component
public class DemoValidator extends AbstractValidator  {

	@Autowired
	SharedService service;

	@Override
	protected void addExtraValidation(Object obj, Errors errors) {
		if (obj instanceof BalanceTransferFormDTO){
			BalanceTransferFormDTO bdto = (BalanceTransferFormDTO)obj;

			
			if (bdto.getSourceAccount().equals(bdto.getTargetAccount())){
				errors.rejectValue("targetAccount",  "targetAccount.invalid", new Object[]{}, "Target Account must be different than source account");
			}
			
			Customer c = service.getClientByID(bdto.getCustomerId());
			if (c == null){
				errors.rejectValue("customerId",  "customerId.invalid", new Object[]{}, "Invalid customer ID");
			} else {
				for (Account a: c.getAccounts()){
					// we can optimize this via a remote query or a remote validation
					if (a.getId().equals(bdto.getSourceAccount()) && (bdto.getTransferAmount().compareTo(a.getBalance()) > 0)){
						errors.rejectValue("sourceAccount",  "sourceAccount.invalid", new Object[]{}, "Source account has insufficient funds");
						break;
					}
				}
			}
		 	
		}
		

	}


}

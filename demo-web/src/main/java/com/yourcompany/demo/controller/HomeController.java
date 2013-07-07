/**
 * 
 */
package com.yourcompany.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yourcompany.demo.SharedService;
import com.yourcompany.demo.controller.dto.BalanceTransferFormDTO;
import com.yourcompany.demo.controller.dto.CustomerFormDTO;
import com.yourcompany.demo.controller.dto.CustomerSearchDTO;
import com.yourcompany.demo.controller.validator.DemoValidator;
import com.yourname.demo.model.Address;
import com.yourname.demo.model.Customer;

/**
 * The controller in use.
 * 
 * @author wwadge
 *
 */
@Controller
public class HomeController {

	@Autowired
	SharedService service;

	@Autowired
	Mapper dozerMapper;

	@Autowired
	DemoValidator demoValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// ignore trailing and preceeding spaces in strings...
		binder.registerCustomEditor(String.class, new StringTrimmerEditor("\r\n\f", false));
		binder.setValidator(this.demoValidator);
		
	}

	@RequestMapping(value="/customerForm",  method = RequestMethod.GET)
	public String customerForm(@ModelAttribute("customerForm") CustomerFormDTO dto){
		return "customerForm";
	} 

	@RequestMapping(value="/customerSearch",  method = RequestMethod.GET)
	public String customerSearch( @ModelAttribute("customerSearch") CustomerSearchDTO customerSearch, @ModelAttribute("balanceTransfer") BalanceTransferFormDTO dto){
		customerSearch.setSearchBy(0);
		return "customerSearch";
	}


	// By the time we enter this method, validations have already been done.
	@RequestMapping(value="/customerForm",  method = RequestMethod.POST)
	public @ResponseBody Long customerPost(HttpServletRequest request, @Valid @ModelAttribute("customerForm") CustomerFormDTO customerForm){
		Customer customer = dozerMapper.map(customerForm, Customer.class);

		// I could use more dozer mapper violence here but let's keep things boringly simple...
		Address a1 = new Address();
		a1.setLine1(customerForm.getAddress1Line1());
		a1.setLine2(customerForm.getAddress1Line2());
		a1.setCity(customerForm.getAddress1City());
		a1.setCountry(customerForm.getAddress1Country());

		Address a2 = new Address();
		a2.setLine1(customerForm.getAddress2Line1());
		a2.setLine2(customerForm.getAddress2Line2());
		a2.setCity(customerForm.getAddress2City());
		a2.setCountry(customerForm.getAddress2Country());

		customer.setAddress1(a1);
		customer.setAddress2(a2);

		return service.saveOrUpdateClient(customer);
	}

	@RequestMapping(value="/customerSearch",  method = RequestMethod.POST)
	public @ResponseBody CustomerFormDTO customerSearch(@ModelAttribute("customerSearch") CustomerSearchDTO customerSearch){


		CustomerFormDTO result = null;

		switch(customerSearch.getSearchBy()){
		case 0:  
			Customer c = service.getClientByID(Long.parseLong(customerSearch.getSearchTerm())); // id
			result = dozerMapper.map(c, CustomerFormDTO.class);
			break;

		case 1: // name 
			c = service.getClientByName(customerSearch.getSearchTerm()); 
			result = dozerMapper.map(c, CustomerFormDTO.class);
			break;

		default:  // can never happen thanks to @Min/@Max on dto
			throw new IllegalStateException("Invalid id");
		}

		return result;
	}
	
	@RequestMapping(value="/balanceTransfer",method=RequestMethod.POST)
	public @ResponseBody String postBalanceTransfer(@Valid @ModelAttribute(value="balanceTransfer") BalanceTransferFormDTO btfd){
		service.balanceTransfer(btfd.getSourceAccount(), btfd.getTargetAccount(), btfd.getTransferAmount());
		// again if we're here: no exceptions have been thrown (= automatic validation error thrown) and validation has succeeded so we're done
		return "[]";
	}



}

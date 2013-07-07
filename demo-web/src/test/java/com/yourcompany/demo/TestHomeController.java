/**
 * 
 */
package com.yourcompany.demo;

import static org.easymock.EasyMock.anyLong;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.List;

import javassist.bytecode.Descriptor.Iterator;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yourcompany.demo.controller.dto.CustomerFormDTO;
import com.yourname.demo.model.Account;
import com.yourname.demo.model.Customer;
import com.yourname.demo.model.CustomerTransaction;
import com.yourname.demo.model.enums.db.AccountAcTypeEnum;
import com.yourname.demo.model.enums.db.CustomerTransactionDrcrEnum;
import com.yourname.demo.model.factories.DemoDataPoolFactory;
import com.yourname.demo.service.data.DataLayerDemo;


/**
 * @author wwadge
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={
		"file:src/test/resources/beans.forms.test.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@ActiveProfiles("test")
public class TestHomeController {

	@Autowired
	private WebApplicationContext wac;


	@Autowired
	SharedService service; // mock injected via spring

	private MockMvc mockMvc;

	@Autowired
	DataLayerDemo dataLayerDemo;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}


	/** Creates a bunch of records. */
	@Ignore
	@Test
	@Rollback(false)
	@Transactional
	@SuppressWarnings("unchecked")
	public void testCreateGoldenDataset(){
		// this is only used to pre-populate the database with valid records.
		List<Customer> customers = dataLayerDemo.createQuery("from Customer").list();
		if (customers.isEmpty()){
			// 1st time only
			Customer customer = DemoDataPoolFactory.getCustomer();
			customer.setName("Wallace");
			customer.setSurname("Wadge");
			customer.setCurrentAccountOpeningBalance(new BigDecimal(1000));
			customer.setSavingsAccountOpeningBalance(new BigDecimal(1000));
			
			
			Account account1 = new Account();
			account1.setBalance(new BigDecimal(1000));
			account1.setAcType(AccountAcTypeEnum.CURRENT);
			
			Account account2 = new Account();
			account2.setBalance(new BigDecimal(1000));
			account2.setAcType(AccountAcTypeEnum.SAVINGS);
			
			CustomerTransaction ct1 = new CustomerTransaction();
			ct1.setAmount(new BigDecimal(5));
			ct1.setDrcr(CustomerTransactionDrcrEnum.DR);
			ct1.setOriginatingAccount(account1);
			ct1.setDestinationAccount(account2);
			ct1.setTransactionDate(new DateTime().minusHours(1));
			
			CustomerTransaction ct2 = new CustomerTransaction();
			ct2.setAmount(new BigDecimal(5));
			ct2.setDrcr(CustomerTransactionDrcrEnum.CR);
			ct2.setDestinationAccount(account1);
			ct2.setOriginatingAccount(account2);
			ct2.setTransactionDate(new DateTime().minusDays(1));
			
			
			customer.addCustomerTransaction(ct1);
			customer.addCustomerTransaction(ct2);
			customer.addAccount(account1);
			customer.addAccount(account2);
			
			dataLayerDemo.saveOrUpdate(customer);
			
		}
	}
	
	/* A sample test that verifies /customerSearch. Mocking + profiles is in place via spring to cut out backend calls. */
	@Test
	public void testHomeController() throws Exception {

		Customer customer = new Customer();
		customer.setName("test");

		expect(service.getClientByID(anyLong())).andReturn(customer);
		replay(service);

		this.mockMvc.perform(post("/customerSearch")
				.param("searchBy", "0")
				.param("searchTerm", "123"))
				.andExpect(status().isOk())
				.andDo(new ResultHandler() {

					@Override
					public void handle(MvcResult result) throws Exception {
						ObjectMapper mapper = new ObjectMapper();

						CustomerFormDTO c = mapper.readValue(result.getResponse().getContentAsString(), CustomerFormDTO.class);
						assertEquals("test", c.getName());

					}
				}).andReturn();
	}

}

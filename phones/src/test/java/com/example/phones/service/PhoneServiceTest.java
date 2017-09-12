package com.example.phones.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.phones.PhonesApplicationTests;
import com.example.phones.entity.Phone;
import com.example.phones.repository.PhoneRepository;
import com.example.phones.service.impl.PhoneServiceImpl;

/**
 * @author rb611j
 *
 */
// @DataJpaTest
// @Transactional
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PhoneServiceTest extends PhonesApplicationTests {

	@InjectMocks
	PhoneServiceImpl phoneService;
	
	//@Mock   -- Mockito
	@MockBean //-- Spring Boot 
	PhoneRepository phonerepository;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void getPhoneByIdTest() throws Exception {
		Phone mockPhone = new Phone("Iphone 6", "Apple");
		//Phone mockPhone1 = null;
		
		//Argument Matchers (Term in Mokito) ----  Mockito.anyLong()
		Mockito.when(
				phonerepository.findById(Mockito.anyLong())).thenReturn(mockPhone);//.thenReturn(mockPhone1);
		Phone actual = phoneService.getPhoneById(1L);
		
		Phone expected = new Phone("Iphone 6", "Apple");
//		Phone expected1 = null;
		
		//assertEquals(expected, actual); // This should fail.
		assertEquals(expected.getPhoneName(), actual.getPhoneName());
		//assertEquals(expected1, actual);
		
	}

}

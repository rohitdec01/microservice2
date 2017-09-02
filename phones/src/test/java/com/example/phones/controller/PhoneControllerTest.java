package com.example.phones.controller;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.phones.model.Phone;
import com.example.phones.service.PhoneService;

/**
 * @author rb611j
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = PhoneContoller.class, secure = false)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PhoneControllerTest {	

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	PhoneService phoneServiceMock;
	
	//@Value("${local.server.port}")   // 6
    //int port;

	@Before
	public void setUp() {
		//mockMvc = MockMvcBuilders.standaloneSetup(new PhoneContoller()).build();
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * @throws Exception
	 * 
	 * Controller test method.
	 */
	//@Test
	public void getPhoneByIdTest_positiveCase() throws Exception {
		Phone mockPhones = new Phone("Iphone 6", "Apple");
		
		Mockito.when(
				phoneServiceMock.getPhoneById(Mockito.anyLong())).thenReturn(mockPhones);

		String url = "/phone?id=1";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON_VALUE);
		System.out.println("Inside Get Phone By Id   " + requestBuilder.toString());
		
		//Actual Result
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		//Expected Result
		String expectedPhoneJson = " {\"phoneName\": \"Iphone 6\",\"phonemanufacturer\": \"Apple\"}";
		
		JSONAssert.assertEquals(expectedPhoneJson, result.getResponse().getContentAsString(), false); //result.getResponse().getContentAsString()
	}
	
	/**
	 * @throws Exception
	 */
	//@Test
	public void getPhoneByIdTest_noPhoneExist() throws Exception {
		Phone mockPhone = null;
		Mockito.when(
				phoneServiceMock.getPhoneById(Mockito.anyLong())).thenReturn(mockPhone);
		String url = "/phone?id=100000000";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON_VALUE);
		
		//Actual Result
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println("my exception result     " + result.getResponse().getContentAsString());
		
		//Expected Result
		String expectedPhoneJson = "{\"errorCode\": 404,\"message\": \"Phone with this id does not exist\"}";
		JSONAssert.assertEquals(expectedPhoneJson, result.getResponse().getContentAsString(), false); //result.getResponse().getContentAsString()
	}
	
	/**
	 * @throws Exception
	 */
	@Test//(expected = Exception.class)
	public void getPhoneByIdTest_missingPhoneName() throws Exception {
		Phone mockPhone = new Phone("", "Apple");
		//Mockito.when(
			//	phoneServiceMock.getPhoneById(Mockito.anyLong())).thenThrow(new Exception("There is some serious issue."));
		
		Mockito.when(
				phoneServiceMock.getPhoneById(Mockito.anyLong())).thenReturn(mockPhone);
		
		String url = "/phone?id=100000000";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON_VALUE);
		
		//Actual Result
		MvcResult result =	mockMvc.perform(requestBuilder).andReturn();
		
		//Expected Result
		String expectedPhoneJson = "{\"errorCode\": 400,\"message\": \"The request could not be understood by the server due to malformed syntax.\"}";
		JSONAssert.assertEquals(expectedPhoneJson, result.getResponse().getContentAsString(), false); //result.getResponse().getContentAsString()
	}
	

}

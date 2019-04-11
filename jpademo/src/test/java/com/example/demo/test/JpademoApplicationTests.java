package com.example.demo.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JpademoApplicationTests {
	
	@Autowired
	UserService userService;
	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	private static Logger log= LoggerFactory.getLogger(JpademoApplicationTests.class);
	@Ignore
	@Test
	public void contextLoads() {
		List<User> user=userService.findByFlagAndParentIsNullOrderByDeptIndexAsc(1,"用户3");
		for(User us:user) {
			System.out.println(us.toString());			
		}
//		for(int i=0;i<9;i++) {
//			User user=new User();
//			user.setUsername("用户"+i);
//			user.setPassword("1234");
//			user.setFlag(1);
//			user.setId(i);
//			userService.saveUser(user);
//			
//		}
		
	}
//	@Ignore
	@Test
	public void testPage() {
		String map = "{\"page\" : 1,\"pageSize\" : 5, \"filter\":{ \"filters\":[{ \"field\" : \"username\", \"value\":\"机构8\"}]}}";
		Map<Object,Object> searchParameters = new HashMap<Object,Object>();
		try {
			searchParameters = objectMapper.readValue(map, new TypeReference<Map<Object,Object>>() {
			});
		} catch (JsonParseException e) {
			log.error("JsonParseException{}:", e.getMessage());
		} catch (JsonMappingException e) {
			log.error("JsonMappingException{}:", e.getMessage());
		} catch (IOException e) {
			log.error("IOException{}:", e.getMessage());
		}
		Map<Object,Object> mapDept = userService.getPage(searchParameters);

		System.out.println(mapDept.get("total").toString());

		System.out.println(mapDept.get("users").toString());
	}

}

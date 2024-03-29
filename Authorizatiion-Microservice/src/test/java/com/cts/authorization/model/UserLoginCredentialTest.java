package com.cts.authorization.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserLoginCredentialTest {

	private UserLoginCredential jwtReqAllArg = new UserLoginCredential("admin", "password");

	@Test
	void testUserNameGetter() {
		assertThat(jwtReqAllArg.getUserName().equals("admin")).isTrue();
	}
	
	@Test
    void testPensionerBean() {
        final BeanTester beanTester = new BeanTester();
        beanTester.getFactoryCollection();
        beanTester.testBean(UserLoginCredential.class);
    }


}

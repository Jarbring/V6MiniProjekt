package com.example.V6MiniProjekt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class V6MiniProjektApplicationTests {

	@Autowired
	ListRepository listRepository;

	@Autowired
	ListServices listServices;

/*	@Test
	public void getValidateLogin() {

		//Nedan testar om det fungerar när vi lägger till en användare
		listRepository.addAccount("test", "test2");
		Assertions.assertEquals(true, listServices.validateLogin("test", "test2"));

		//Nedan testar hårdkodade accounts
		Assertions.assertEquals(true, listServices.validateLogin("Mikael", "Mikael"));
		Assertions.assertEquals(false, listServices.validateLogin("Mika", "Mikael"));
		Assertions.assertEquals(false, listServices.validateLogin("Mikael", "Mik"));
		Assertions.assertEquals(false, listServices.validateLogin("Mikael", "Oskar"));
		Assertions.assertEquals(true, listServices.validateLogin("Oskar", "Oskar"));

	}*/

	@Test
	public void validateArraySize() {
		//Kolla så att ArrayList inte ersätter med nya accounts
	}



	@Test
	void contextLoads() {
	}

	@Test //Database connection test
	void testSQLServler() throws SQLException {
		Assertions.assertEquals("JMAN",listRepository.testDB());
	}


}



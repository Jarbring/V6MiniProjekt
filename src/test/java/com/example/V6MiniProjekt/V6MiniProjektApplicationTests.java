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



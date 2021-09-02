package com.iu.s1;

import static org.junit.Assert.*;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DataSourceTest extends MyJunitTest {
	@Autowired
	private DataSource datasource;
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Test
	public void test() throws Exception {
		assertNotNull(datasource.getConnection());
	}

	@Test
	public void sqlSessionTest() {
		assertNotNull(sqlSession);
	}
	
}

package com.iu.s1.bankbook;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class BankBookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.iu.s1.bankbook.BankBookDAO.";
	
	public List<BankBookDTO> getList(){
		
		return sqlSession.selectList(NAMESPACE+"getList");
		
	}
	
	
	public int setDelete(Long bookNumber) {
		
		return sqlSession.delete(NAMESPACE+"setDelete",bookNumber);
		
	}
	
	
	
	public BankBookDTO getSelect(BankBookDTO bankBookDTO) {
		
		return sqlSession.selectOne(NAMESPACE+"getSelect", bankBookDTO);
				
	}
	
	
	public int setInsert(BankBookDTO bankBookDTO) {
		
		return sqlSession.insert(NAMESPACE+"setInsert", bankBookDTO);
		
	}
	
	
	
	

	
	
}

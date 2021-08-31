package com.iu.s1.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.util.DBConnector;

@Repository
public class BankBookDAO {
	
	private DBConnector dbConnector;
	
	
	@Autowired
	public BankBookDAO(DBConnector dbConnector) {
		this.dbConnector=dbConnector;	
	}
	
	public void setDbConnector(DBConnector dbConnector) {
		this.dbConnector=dbConnector;
	}
	
	
	
	//setInsert
	
	public int setInsert(BankBookDTO bankBookDTO) {
		Connection con = dbConnector.getConnect();
		PreparedStatement st = null;
		int result = 0; 
		String sql = "INSERT INTO BANKBOOK (bookNumber,bookName,bookRate,bookSale) "
				+ "values(BANKBOOK_SEQ.NEXTVAL,?,?,?)";
		
		try {
			
			st = con.prepareStatement(sql);
	
			st.setString(1,bankBookDTO.getBookName());
			st.setDouble(2, bankBookDTO.getBookRate());
			st.setInt(3, bankBookDTO.getBookSale());
		
			result =st.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnector.disConnect(st, con);
			
		}
		
		
		return result;
		
	}
	
		
	
	
	
	
	
	
	
	public ArrayList<BankBookDTO> getList() {
		Connection con = dbConnector.getConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();		
		String sql = "SELECT * FROM BANKBOOK";
		
		try {
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				BankBookDTO bankBookDTO = new BankBookDTO();
				bankBookDTO.setBookNumber(rs.getLong("bookNumber"));
				bankBookDTO.setBookName(rs.getString("bookName"));
				bankBookDTO.setBookRate(rs.getDouble("bookRate"));
				bankBookDTO.setBookSale(rs.getInt("bookSale"));
				ar.add(bankBookDTO);
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnector.disConnect(rs, st, con);
		}
		
		return ar;
	}
	
	
	
	
	
	
	public BankBookDTO getSelect(BankBookDTO bankBookDTO) {
		
		Connection con = dbConnector.getConnect();
		PreparedStatement st =null;
		ResultSet rs =null;
		BankBookDTO result = null; 
		
		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUMBER=?";
		
		try {
			st = con.prepareStatement(sql);
			
			st.setLong(1, bankBookDTO.getBookNumber());
			
			rs= st.executeQuery();
			
			if(rs.next()) {
				result = new BankBookDTO();
				result.setBookNumber(rs.getLong("bookNumber"));
				result.setBookName(rs.getString("bookName"));
				result.setBookRate(rs.getDouble("bookRate"));
				result.setBookSale(rs.getInt("bookSale"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			dbConnector.disConnect(rs, st, con);
			
		}
		
		return result;
				
	}
	

	
	
}

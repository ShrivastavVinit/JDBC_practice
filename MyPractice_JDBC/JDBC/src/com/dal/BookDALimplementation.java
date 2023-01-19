
package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.pojo.Book;
import com.utils.DBConnection;;

public class BookDALimplementation implements BookDAL{
	
	private Connection con;
	private Statement stmt;
	private ResultSet rset;
	private PreparedStatement pstmt1,pstmt2,pstmt3;
	
	public BookDALimplementation() throws SQLException
	{
		con = DBConnection.getCon();

		//create statement for static sql(select * from book)
		stmt = con.createStatement();
		System.out.println("--statement created for static sql---");
		
		
		//create statement for dynamic sql
		pstmt1 = con.prepareStatement("insert into books values (?,?,?,?,?)");
		pstmt2 = con.prepareStatement("delete from books where id=?");
		pstmt3 = con.prepareStatement("update books set title=? ,author=?, category=?, price=? where id=?");
		
		System.out.println("-- statement created for dynamic sql---");
		
	}

	@Override
	public List<Book> getAllBooks() {
		//stmt.executeQuery: read data: select query: select * from book
	
		 try 
		 {
			 List<Book> allBooks = new ArrayList<Book>();
			rset = stmt.executeQuery("select * from books");
			while(rset.next())
			{
			
			allBooks.add(new Book (rset.getInt("id"),
					              rset.getString("title"),
					              rset.getString("author"),
					              rset.getString("category"),
					              rset.getDouble("price")));	
			}
			
			return allBooks;
		 } 
		 catch (SQLException e) 
		 {
			e.printStackTrace();
		 }
		 
		return null;
	}

	@Override
	public int addBook(Book b) {
		//add all parameters separately
		try
		{
			pstmt1.setInt(1, b.getId());
			pstmt1.setString(2, b.getTitle());
			pstmt1.setString(3, b.getAuthor());
			pstmt1.setString(4, b.getCategory());
			pstmt1.setDouble(5, b.getPrice());
			
			//execute statment on db 
			int i = pstmt1.executeUpdate(); //it'll update everything which is added
			System.out.println("---inserted obj--:"+b);
			return i;
		}
		
		 catch (SQLException e) 
		 {
			e.printStackTrace();
		 }
		 
		return 0;
	}

	@Override
	public int deleteBook(int id) {
		try
		{
			pstmt2.setInt(1, id);
			int i = pstmt2.executeUpdate();
			return i;
		}
		catch (SQLException e) 
		 {
			e.printStackTrace();
		 }
		 
		return 0;
	}

	@Override
	public int updateBook(Book b) {
		try
		{
			pstmt3.setString(1, b.getTitle());
			pstmt3.setString(2, b.getAuthor());
			pstmt3.setString(3, b.getCategory());
			pstmt3.setDouble(4, b.getPrice());
			
			int i = pstmt3.executeUpdate();
			return i;
					
		}
		catch (SQLException e) 
		 {
			e.printStackTrace();
		 }
		return 0;
	}
	
	

}

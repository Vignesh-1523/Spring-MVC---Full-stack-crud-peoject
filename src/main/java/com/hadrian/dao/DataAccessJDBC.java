package com.hadrian.dao;

import com.hadrian.model.Student;

import java.sql.*;
import java.util.ArrayList;

public class DataAccessJDBC {
	
	public void delete(int id) {
		String link = "jdbc:mysql://localhost:3306/SpringStudent";
		String user = "root";
		String pass = "8778363157";
		String query = "DELETE FROM studentDetails WHERE id = ?";

		Connection con = null;
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(link, user, pass);
			ps = con.prepareStatement(query);
            
			ps.setInt(1, id);
			int res = ps.executeUpdate();
			System.out.print(res);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (!(ps == null)) {
					ps.close();
				}
				if (!(con == null)) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	// Update records..
    public void update(Student s) {
    	String link = "jdbc:mysql://localhost:3306/SpringStudent";
		String user = "root";
		String pass = "8778363157";
		String query = "UPDATE studentDetails SET stName = ?, stEmail = ?, stPassword = ?, stMobile = ? WHERE id = ?";

		Connection con = null;
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(link, user, pass);
			ps = con.prepareStatement(query);
            System.out.println(s.getId());
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPassword());
			ps.setLong(4, s.getMobile());
			ps.setInt(5, s.getId());
			

			int res = ps.executeUpdate();
			System.out.print(res);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (!(ps == null)) {
					ps.close();
				}
				if (!(con == null)) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }
    
	// Getting Data By Id for updating
	public Student getDetailsById(int id) {
		
		Student s = new Student();
		String link = "jdbc:mysql://localhost:3306/SpringStudent";
		String user = "root";
		String pass = "8778363157";
		String query = "SELECT * FROM studentDetails WHERE id = ?";
		
		Connection con = null;
		PreparedStatement ps = null;
        ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(link, user, pass);
			ps = con.prepareStatement(query);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				s.setId(id);
				s.setName(rs.getString("stName"));
				s.setEmail(rs.getString("stEmail"));
				s.setPassword(rs.getString("stPassword"));
				s.setMobile(rs.getLong("stMobile"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (!(rs == null)) {
					rs.close();
				}
				if (!(ps == null)) {
					ps.close();
				}
				if (!(con == null)) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return s;
	}
	
	// Method for Inserting Records to DataBase
	public void insert(Student s) {

		// JDBC connection..
		String link = "jdbc:mysql://localhost:3306/SpringStudent";
		String user = "root";
		String pass = "8778363157";
		String query = "INSERT INTO studentDetails(stName, stEmail, stPassword, stMobile) VALUES (?,?,?,?)";

		Connection con = null;
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(link, user, pass);
			ps = con.prepareStatement(query);

			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPassword());
			ps.setLong(4, s.getMobile());

			int res = ps.executeUpdate();
			System.out.print(res);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// We make sure to close all only if these aren't null otherwise
				// NullPointerException will occur
				if (!(ps == null)) {
					ps.close();
				}
				if (!(con == null)) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// get and save the student object in an ArrayList
	public ArrayList<Student> getDetails() {
		ArrayList<Student> arr = new ArrayList<Student>();

		// JDBC connection..
		String link = "jdbc:mysql://localhost:3306/SpringStudent";
		String user = "root";
		String pass = "8778363157";
		String query = "SELECT * FROM studentDetails";

		Connection con = null;
		Statement st = null;
        ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(link, user, pass);
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("stName");
				String email = rs.getString("stEmail");
				String password = rs.getString("stPassword");
				long mobile = rs.getLong("stMobile");
				
				// creating new student object
				Student student = new Student(id, name, email, password, mobile);
				arr.add(student); // passing the student object
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (!(rs == null)) {
					rs.close();
				}
				if (!(st == null)) {
					st.close();
				}
				if (!(con == null)) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arr;
	}
}

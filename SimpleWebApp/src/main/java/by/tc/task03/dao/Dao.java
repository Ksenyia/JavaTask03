package by.tc.task03.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.tc.task03.modal.Person;

public class Dao {
	
	private static int nameColumn = 1;
	private static int surnameColumn = 2;
	private static int phoneColumn = 3;
	private static int emailColumn = 4;
	private static String connection = "jdbc:mysql://127.0.0.1/epamt3";
	private static String user = "root";
	private static String password = "password";
	private static String className = "org.gjt.mm.mysql.Driver";
	public static Person getPerson(String name,String surname){
	Person person = new Person();
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	try {
		Class.forName(className);
		try {
			con = DriverManager.getConnection(connection,user,password);
			st = con.createStatement();
			String query = "SELECT * FROM information";
			rs =st.executeQuery(query);
			while(rs.next()){
				if(isPresonFound(name, surname, person, rs)){
					String phoneColumnValue = rs.getString(phoneColumn);
					String emailColumnValue = rs.getString(emailColumn); 
					person = getPerson(name, surname, phoneColumnValue, emailColumnValue);
					break;
				}
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	return person;
	}

	private static boolean isPresonFound(String name, String surname, Person person, ResultSet rs) throws SQLException {
		String nameColumnValue = rs.getString(nameColumn);
		String surnameColumnValue = rs.getString(surnameColumn);
		if(surname.equalsIgnoreCase(surnameColumnValue)&&name.equalsIgnoreCase(nameColumnValue)){
			
			return true;
		}
		else{
			return false;
		}
	}

	private static Person getPerson(String name, String surname, String phoneColumnValue,
			String emailColumnValue) {
		Person person = new Person();
		person.setName(name);
		person.setSurname(surname);
		person.setPhoneNumber(phoneColumnValue);
		person.setEmail(emailColumnValue);
		return person;
	}
}


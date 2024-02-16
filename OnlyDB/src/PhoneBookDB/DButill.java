package PhoneBookDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DButill {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String url = "jdbc:mysql://13.124.144.111:3306/phoneBookDB";
	String user = "usrid";
	String pass = "usrpassword";
	
	public DButill() {
		conn=getConnection();
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			//1. 드라이버 세팅
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. Connection 획득
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("DB Connection 성공");
		} catch (Exception e) {
			System.out.println("DB작업중 문제 발생: " + e.getMessage());
		}
		return conn;
	}
	public void insertAddressStringBuffer(String name, String address, String phone) {
	      // ===========DB파일===========
	      // 3. Statement 생성
	      try {
	        stmt = conn.createStatement();
	    	  //StringBuffer insertQuery = new StringBuffer();
	         //insertQuery.append("INSERT INTO phone (phone_NAME, phone_ADDRESS, phone_NUMBER) VALUES ('")
	           //    .append(name + "','").append(address + "','").append(phone + "','");

	        String sql = "INSERT INTO phone (phone_NAME, phone_ADDRESS, phone_NUMBER) VALUES ('"+
	           name + "','"+address + "','"+phone + "')";
	         // stmt.executeUpdate(insertQuery);
	         stmt.executeUpdate(sql);
	         System.out.println("등록완료");
	      } catch (Exception e) {
	         System.out.println("DB 작업중 문제 발생: " + e.getMessage());
	         e.printStackTrace();
	      }
	   }
	public void updateAddress(int id, String name, String address, String phone) {
		//============== DB작업 ================
		try {
			stmt = conn.createStatement();
			String sql = String.format("UPDATE phone SET phone_NAME = '%s' , phone_ADDRESS = '%s', phone_NUMBER = '%s' WHERE phone_ID = %s", name, address, phone, id);
		stmt.executeUpdate(sql);
		System.out.println("주소록 수정 완료");
		} catch (Exception e) {
		System.out.println("DB 작업 중 문제 발생: " + e.getMessage());
		e.printStackTrace();
		}
		//=========================================
	}
	public void deleteAddress(int id) {
		//================= DB작업 ===============
		try {
			stmt = conn.createStatement();
			String sql = "DELETE FROM phone WHERE phone_ID = " + id;
			stmt.executeUpdate(sql);
			System.out.println("주소록 수정 완료");
		}catch (Exception e) {
			System.out.println("DB 작업중 문제 발생: " + e.getMessage());
			e.printStackTrace();
		}
		// ===========================================
	}
	public void makeCompany(String company) {
		//================= DB작업 ===============
				try {
					stmt = conn.createStatement();
					String sql = String.format("create database %s character set utf8mb4 collate utf8mb4_unicode_ci;", company);
					stmt.executeUpdate(sql);
					String sql1 = String.format("create table phone(\r\n"
							+ "	%s_ID int not null auto_increment primary key,\r\n"
							+ "    %s_NAME varchar(30),\r\n"
							+ "    %s_ADDRESS varchar(30),\r\n"
							+ "    %s_NUMBER varchar(13)\r\n"
							+ "    %s_POSITION varchar(13)\r\n"
							+ "    %s_PART varchar(13)\r\n"
							+ "    );", company, company, company, company,company,company);
					stmt.executeUpdate(sql1);
					System.out.printf("%s 회사 추가 완료\n", company);
				}catch (Exception e) {
					System.out.println("DB 작업중 문제 발생: " + e.getMessage());
					e.printStackTrace();
				}
				// ===========================================
	}
	public void dropCompany(String company) {
		//================= DB작업 ===============
				try {
					stmt = conn.createStatement();
					String sql = String.format("DROP %s;", company);
					stmt.executeUpdate(sql);
					System.out.println("주소록 수정 완료");
				}catch (Exception e) {
					System.out.println("DB 작업중 문제 발생: " + e.getMessage());
					e.printStackTrace();
				}
				// ===========================================
	}
	public ArrayList<Addr> getAddress() {
		
		ArrayList<Addr> AddrList = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			String sql = "select *from phone;\r\n"+"";
			
			rs = stmt.executeQuery(sql);
			
			//System.out.println("============ 주소록 목록 ================");
			while(rs.next()) {
				int id = rs.getInt("phone_ID");
				String name = rs.getString("phone_NAME");
				String address = rs.getString("phone_ADDRESS");
				String phone = rs.getString("phone_NUMBER");
				
				Addr a1 = new Addr(id, name, address, phone);
				AddrList.add(a1);
			}
		}catch (Exception e) {
			System.out.println("list DB 작업중 문제 발생!");
			e.printStackTrace();
		}
		return AddrList;
		
	}
	
}
class Addr{
	private int id;
	private String name;
	private String address;
	private String phone;
	
	public Addr(int id, String name, String address, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}

}

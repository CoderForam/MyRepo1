package com.java.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java.DTO.CompanyDTO;

public class CompanyDAO {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://192.168.100.55:3306/practical", "javauser", "java@123");

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int save(CompanyDTO cmpDto) {
		int status = 0;
		try {
			Connection con = CompanyDAO.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into company_tbl(Name,Email,Address,City,Gender,Date,Language,Blood_Group) values (?,?,?,?,?,?,?,?)");
			ps.setString(1, cmpDto.getName());
			ps.setString(2, cmpDto.getEmail());
			ps.setString(3, cmpDto.getAddress());
			ps.setString(4, cmpDto.getCity());
			ps.setString(5, cmpDto.getGender());
			ps.setString(6, cmpDto.getDate_of_Birth());
			ps.setString(7, cmpDto.getLanguage());
			ps.setString(8, cmpDto.getBlood_Group());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(CompanyDTO dto) {
		int updateStatus = 0;
		try {
			Connection con = CompanyDAO.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update company_tbl set Name=?,Email=?,Address=?,City=?,Gender=?,Language=?,Date=?,Blood_Group=? where id=?");
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getAddress());
			ps.setString(3, dto.getEmail());
			ps.setString(4, dto.getCity());
			ps.setString(5, dto.getGender());
			ps.setString(6, dto.getLanguage());
			ps.setString(7, dto.getDate_of_Birth());
			ps.setString(8, dto.getBlood_Group());
			ps.setInt(9, dto.getId());
			System.out.println("ps = " + ps);
			updateStatus = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return updateStatus;
	}

	public static int delete(int id) {
		int deleteStatus = 0;
		try {
			Connection con = CompanyDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from company_tbl where id=?");
			ps.setInt(1, id);
			deleteStatus = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return deleteStatus;
	}

	public static List<CompanyDTO> getAllEmployees() {
		List<CompanyDTO> list = new ArrayList<CompanyDTO>();

		try {
			Connection con = CompanyDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from company_tbl");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CompanyDTO cmpDto = new CompanyDTO();
				cmpDto.setId(rs.getInt(1));
				cmpDto.setName(rs.getString(2));
				cmpDto.setEmail(rs.getString(3));
				cmpDto.setAddress(rs.getString(4));
				cmpDto.setCity(rs.getString(5));
				cmpDto.setGender(rs.getString(6));
				cmpDto.setDate_of_Birth(rs.getString(8));
				cmpDto.setLanguage(rs.getString(9));
				cmpDto.setBlood_Group(rs.getString(10));
				list.add(cmpDto);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public static CompanyDTO getEmployeeById(int id) {
		CompanyDTO e = new CompanyDTO();

		try {
			Connection con = CompanyDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from company_tbl where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setAddress(rs.getString(4));
				e.setCity(rs.getString(5));
				e.setGender(rs.getString(6));
				e.setDate_of_Birth(rs.getString(8));
				e.setLanguage(rs.getString(9));
				e.setBlood_Group(rs.getString(10));

			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}
}

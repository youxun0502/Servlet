package com.liu.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.liu.bean.EmpBean;

public class MidDao {
	public EmpBean Insert(EmpBean emp) {
		Connection conn;
		try {
			Context context;
			context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			conn = ds.getConnection();
			
			String empno = emp.getEmpno();
			String ename = emp.getEname();
			String hiredate = emp.getHiredate();
			String salary = emp.getSalary();
			String deptno = emp.getDeptno();
			String title = emp.getTitle();
			List<EmpBean> empContainer = new ArrayList<>();

			String sql = "Insert into employee values(?,?,?,?,?,?);";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, empno);
			stmt.setString(2, ename);
			stmt.setString(3, hiredate);
			stmt.setString(4, salary);
			stmt.setString(5, deptno);
			stmt.setString(6, title);
			stmt.executeUpdate();

			//request.setAttribute("finish", row);

			String sql1 = "select * from employee where empno =?";
			PreparedStatement stmt1 = conn.prepareStatement(sql1);
			stmt1.setString(1, empno);
			ResultSet rs = stmt1.executeQuery();

			while (rs.next()) {
				EmpBean emp = new EmpBean();
				emp.setEmpno(rs.getString("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getString("hiredate"));
				emp.setSalary(rs.getString("salary"));
				emp.setDeptno(rs.getString("deptno"));
				emp.setTitle(rs.getString("title"));
				empContainer.add(emp);
			}
			stmt.close();
			conn.close();
			return empContainer;

		} catch (NamingException | SQLException e) {

			e.printStackTrace();
			return null;
		}

	}
}

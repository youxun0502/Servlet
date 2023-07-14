package com.liu.controller;

import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


import com.liu.bean.EmpBean;

@WebServlet("/EmpDelete")
public class EmpDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EmpDelete() {
        super();
     
    }

	Connection conn ;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Context context;
		try {
			String empno = request.getParameter("empno");
			context = new InitialContext();		
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			conn = ds.getConnection();
			
			String sql1 = "select * from employee where empno =?";
			PreparedStatement stmt1 = conn.prepareStatement(sql1);
			stmt1.setString(1,empno);
			ResultSet rs = stmt1.executeQuery();
			EmpBean emp = new EmpBean();
			if(rs.next()) {
				emp.setEmpno(rs.getString("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getString("hiredate"));
				emp.setSalary(rs.getString("salary"));
				emp.setDeptno(rs.getString("deptno"));		
				emp.setTitle(rs.getString("title"));
			}
			
			String sql = "delete from employee where empno =?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, empno);	
			int row =stmt.executeUpdate();

			request.setAttribute("finish", row);
			
			
			stmt.close();
			request.setAttribute("emp", emp);
			request.getRequestDispatcher("/hwJSP/EmpDelete.jsp").forward(request, response);
		} catch (NamingException | SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}

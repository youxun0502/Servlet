package com.liu.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.liu.Dao.MidDao;
import com.liu.bean.EmpBean;

@WebServlet("/EmpInsert")
public class EmpInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpInsert() {
		super();

	}

	Connection conn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Context context;
//		try {
//			String empno = request.getParameter("empno");
//			String ename = request.getParameter("ename");
//			String hiredate= request.getParameter("hiredate");
//			String salary = request.getParameter("salary");
//			String deptno = request.getParameter("deptno");
//			String title = request.getParameter("title");
//			context = new InitialContext();		
//			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
//			conn = ds.getConnection();
//			String sql = "Insert into employee values(?,?,?,?,?,?);";
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setString(1, empno);
//			stmt.setString(2, ename);
//			stmt.setString(3, hiredate);
//			stmt.setString(4, salary);
//			stmt.setString(5, deptno);
//			stmt.setString(6, title);
//			int row =stmt.executeUpdate();
//
//			request.setAttribute("finish", row);
//			
//			String sql1 = "select * from employee where empno =?";
//			PreparedStatement stmt1 = conn.prepareStatement(sql1);
//			stmt1.setString(1,empno);
//			ResultSet rs = stmt1.executeQuery();
//			EmpBean emp = new EmpBean();
//			if(rs.next()) {
//				emp.setEmpno(rs.getString("empno"));
//				emp.setEname(rs.getString("ename"));
//				emp.setHiredate(rs.getString("hiredate"));
//				emp.setSalary(rs.getString("salary"));
//				emp.setDeptno(rs.getString("deptno"));		
//				emp.setTitle(rs.getString("title"));
//			}
//			stmt.close();		
		EmpBean emp = new EmpBean();
		emp.setEmpno(request.getParameter("empno"));
		emp.setEname(request.getParameter("ename"));
		emp.setHiredate(request.getParameter("hiredate")); 
		emp.setSalary(request.getParameter("salary")); 
		emp.setDeptno(request.getParameter("deptno"));
		emp.setTitle(request.getParameter("title")); 
		MidDao dao = new MidDao();
		EmpBean empContainer = new EmpBean();		
		empContainer = dao.Insert(emp);
		request.setAttribute("emp", empContainer);
		request.getRequestDispatcher("/hwJSP/EmpInsert.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

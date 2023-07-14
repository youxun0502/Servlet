<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            /* border: dashed 2px black; */
        }

        .formContainer {
            border: dashed 2px black;
            width: 600px;
            display: flex;
            justify-content: center;
            border-radius: 20px 20px;
            padding-top: 20px;
            padding-bottom: 20px;
        }

        form {
            width: 300px;
        }

        input {
            margin: 5px;
        }

        .inputTitle {
            margin: 0;
            width: 80px;
            float: left;
        }

        .submit {
            width: 60px;
            margin-right: 80px;
            margin-left: 20px;
        }

        .reset {
            width: 60px;
        }
        .inputTitle1 {
            margin: 0;
            width: 150px;
            float: left;
        }
    </style>
    <title>Insert</title>
</head>

<body>
<% int row = (int)request.getAttribute("finish"); %>
    <h2>刪除員工資料</h2>
	<jsp:useBean id="emp" scope="request" class="com.liu.bean.EmpBean"/>
    <div class="container">
        <div class="formContainer">
            <form method="post" action="../InsertEmpJNDI">
                <div class="inputTitle">員工編號 :</div>
                <input type="text" name="empno" disabled value="<%= emp.getEmpno() %>"/>
                <br>
                <div class="inputTitle">員工姓名 :</div>
                <input type="text" name="ename" disabled value="<%= emp.getEname() %>"/>
                <br>
                <div class="inputTitle">雇用日期 :</div>
                <input type="text" name="hiredata" disabled value="<%= emp.getHiredate() %>"/>
                <br>
                <div class="inputTitle">薪水 :</div>
                <input type="text" name="salary" disabled value="<%= emp.getSalary() %>"/>
                <br>
                <div class="inputTitle">部門編號 :</div>
                <input type="text" name="deptno" disabled value="<%= emp.getDeptno() %>"/>
                <br>
                <div class="inputTitle">職稱 :</div>
                <input type="text" name="title" disabled value="<%= emp.getTitle() %>"/>
                <h3 class="inputTitle1">共刪除  <%= row %>  筆資料</h3>
            </form>
           
        </div>
         	
    </div>

</body>

</html>
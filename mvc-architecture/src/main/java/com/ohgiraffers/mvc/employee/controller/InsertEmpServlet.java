package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/employee/insert")
public class InsertEmpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String empName = request.getParameter("empName");
        String empNo = request.getParameter("empNo");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String deptCode = request.getParameter("deptCode");
        String jobCode = request.getParameter("jobCode");
        String salLevel = request.getParameter("salLevel");
        int salary = Integer.parseInt(request.getParameter("salary"));
        double bonus = Double.parseDouble(request.getParameter("bonus"));
        String managerId = request.getParameter("managerId");
        Date hireDate = Date.valueOf(request.getParameter("hireDate"));

        EmployeeDTO emp = new EmployeeDTO();
        emp.setEmpName(empName);
        emp.setEmpNo(empNo);
        emp.setEmail(email);
        emp.setPhone(phone);
        emp.setDeptCode(deptCode);
        emp.setJobCode(jobCode);
        emp.setSalLevel(salLevel);
        emp.setSalary(salary);
        emp.setBonus(bonus);
        emp.setManagerId(managerId);
        emp.setHireDate(hireDate);

        System.out.println("insert request emp : " + emp);

        EmployeeService employeeService = new EmployeeService();
        int result = employeeService.insertEmp(emp);

        if(result > 0) {
            response.sendRedirect(request.getContextPath() + "/employee/list");

        } else {
            request.setAttribute("message", "신규 직원 등록에 실패하였습니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
        }

    }

}
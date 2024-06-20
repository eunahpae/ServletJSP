package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/employee/update")
public class UpdateEmpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String empId = request.getParameter("empId");
        String empName = request.getParameter("empName");

        EmployeeDTO emp = new EmployeeDTO();
        emp.setEmpId(empId);
        emp.setEmpName(empName);

        EmployeeService employeeService = new EmployeeService();
        int result = employeeService.updateEmp(emp);

        if(result > 0) {
            response.sendRedirect(request.getContextPath() + "/employee/list");

        } else {
            request.setAttribute("message", "직원 정보 수정에 실패하였습니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
        }

    }

}
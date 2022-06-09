package com.luv2code.springboot.tymeleafdemo.controller;

import com.luv2code.springboot.tymeleafdemo.entity.Employee;
import com.luv2code.springboot.tymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
        private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }



        @GetMapping("/list")
    public String listEmployees(Model theModel){

            List<Employee> theEmployees=employeeService.findAll();
            theModel.addAttribute("employees",theEmployees);
            return "list-employees";
        }
        @GetMapping("showFormForAdd")
        public String showForAdd(Model theModel){
            Employee theEmployee = new Employee();
            theModel.addAttribute("employee",theEmployee);
            return "employees/employe-form";


        }
}

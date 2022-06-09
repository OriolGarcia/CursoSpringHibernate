package com.luv2code.springboot.tymeleafdemo.controller;

import com.luv2code.springboot.tymeleafdemo.model.Employee;
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

        private List<Employee> theEmployees;
        @PostConstruct
        private void loadData(){
            Employee emp1 =new Employee(1,"leslie","Andrews","fa@foo.com");
            Employee emp2 =new Employee(2,"Oriol","Garcia","ogs@foo.com");
            Employee emp3 =new Employee(3,"Mark","Zurerberg","ma@foo.com");
            theEmployees=new ArrayList<>();
            theEmployees.add(emp1);
            theEmployees.add(emp2);
            theEmployees.add(emp3);
        }
        @GetMapping("/list")
    public String listEmployees(Model theModel){
            theModel.addAttribute("employees",theEmployees);
            return "list-employees";
        }

}

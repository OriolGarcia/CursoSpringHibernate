package com.luv2code.springboot.tymeleafdemo.controller;

import com.luv2code.springboot.tymeleafdemo.entity.Employee;
import com.luv2code.springboot.tymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
            return "employees/list-employees";
        }
        @GetMapping("showFormForAdd")
        public String showForAdd(Model theModel){
            Employee theEmployee = new Employee();
            theModel.addAttribute("employee",theEmployee);
            return "employees/employee-form";


        }
        @GetMapping("/showFormForUpdate")
        public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){
           Employee theEmployee = employeeService.findById(theId);

            theModel.addAttribute("employee",theEmployee);

            return "employees/employee-form";
        }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId, Model theModel){
       employeeService.deleteById(theId);
        return "redirect:/employees/list";
    }
        @PostMapping("/save")
        public  String  saveEmployee(@ModelAttribute("employee") Employee theEmployee){
            employeeService.save(theEmployee);
            return "redirect:/employees/list";
        }
}

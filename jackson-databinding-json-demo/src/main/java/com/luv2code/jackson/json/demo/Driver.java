package com.luv2code.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luv2code.jackson.json.demo.Student;

import java.io.File;

public class Driver {

    public static void main(String[] args) {
        try{
            //crate bject mapper

            ObjectMapper mapper = new ObjectMapper();
            Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
            System.out.println("fIrstName= " +theStudent.getFirstName());
            System.out.println("lastName= " +theStudent.getLastName());
            Address tempAddress= theStudent.getAddress();

            System.out.println("Street ="+tempAddress.getStreet());
            System.out.println("City ="+tempAddress.getCity());
            for (String tempLang : theStudent.getLanguages()){

                System.out.println("Language "+tempLang);
            }
        }catch (Exception exc){
            exc.printStackTrace();
        }
    }
}

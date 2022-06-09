package com.example.mvc;

import com.example.mvc.validation.CourseCode;

import javax.validation.constraints.*;

public class Customer {

    private String firstName;
    @NotNull(message = "is required")
    @Size(min=1,message = "is required")
    private String lastName;
    @NotNull(message = "is required")
    @Min(value=0, message="must be greater than or equea to zero")
    @Max(value=10, message="must be less than or equea to 10")
    private Integer freePasses;
   @Pattern(regexp="[a-zA-Z0-9]{5}",message ="only 5 chars/digits")
    private String postalCode;
    public String getFirstName() {
        return firstName;
    }
    @CourseCode(value="LUV", message="must start with LUV")
    private String courseCode
            ;
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {

        return freePasses;
    }

    public void setFreePasses(Integer freePases) {
        this.freePasses = freePases;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}

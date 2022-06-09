package com.luv2code.hibernate.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Course")
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
   private int id;
   @Column(name="title")
   private String title;
   @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
   @JoinColumn(name = "course_id")
   private List<Review> reviews;
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST})
    @JoinTable(name = "course_student",joinColumns = @JoinColumn(name="course_id"),inverseJoinColumns = @JoinColumn(name ="student_id"))
   private List<Student> students;
   @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
   @JoinColumn(name = "instructor_id")
   private Instructor instructor;

   public Course() {
   }

   public Course(String title) {
      this.title = title;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public Instructor getInstructor() {
      return instructor;
   }

   public void setInstructor(Instructor instructor) {
      this.instructor = instructor;
   }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
public void addReview(Review review){
       if (reviews==null){
           reviews=new ArrayList<>();
       }
       reviews.add(review);

}

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudens(Student student){
        if (students==null){
            students=new ArrayList<>();
        }
        students.add(student);

    }

    @Override
   public String toString() {
      return "Course{" +
              "id=" + id +
              ", title='" + title + '\'' +
              '}';
   }
}

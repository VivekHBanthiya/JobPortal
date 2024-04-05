package com.example.springboot.jobs.JobPortal.jobs.Entity;

import com.example.springboot.jobs.JobPortal.Company.Entity.Company;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor //lombok annotation for constructor with full value
@Data
@NoArgsConstructor //lombok annotation for constructor with  null value
@Getter //lombok annotation for getter method
@Setter //lombok annotation for setter method
@ToString //for to string method
@Entity // to make entity of the following variable
//@Table(name = "job_table") // to change table name
public class Jobs {
    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //to auto generate the unique value of primary key i.e. id
    private long id;
    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private double maxSalary;
    @Column(nullable = false)
    private double minSalary;

    private boolean bond;

    @ManyToOne
    private Company company;



    //if we havent use AllArgsConstructor we need to manually call constructor
//    public Jobs(long id, String role, String company, String location, double maxSalary, double minSalary, boolean bond) {
//        this.id = id;
//        this.role = role;
//        this.company = company;
//        this.location = location;
//        this.maxSalary = maxSalary;
//        this.minSalary = minSalary;
//        this.bond = bond;
//    }
    //default constructor is needed for jpa repository
    //without this default constructor JPA won't able to instantiate any entity object
    // JPA need this default constructor for retrieve of data from data base
//    public Jobs(){
//    }

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    public String getCompany() {
//        return company;
//    }
//
//    public void setCompany(String company) {
//        this.company = company;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public double getMaxSalary() {
//        return maxSalary;
//    }
//
//    public void setMaxSalary(double maxSalary) {
//        this.maxSalary = maxSalary;
//    }
//
//    public double getMinSalary() {
//        return minSalary;
//    }
//
//    public void setMinSalary(double minSalary) {
//        this.minSalary = minSalary;
//    }
//
//    public boolean isBond() {
//        return bond;
//    }
//
//    public void setBond(boolean bond) {
//        this.bond = bond;
//    }
}

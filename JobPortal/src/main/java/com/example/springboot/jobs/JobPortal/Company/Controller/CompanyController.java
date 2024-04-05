package com.example.springboot.jobs.JobPortal.Company.Controller;

import com.example.springboot.jobs.JobPortal.Company.Entity.Company;
import com.example.springboot.jobs.JobPortal.Company.Service.CompanyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController
{
    @Autowired
    private CompanyServices companyServices;

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
        return new ResponseEntity<>(companyServices.getAllCompanies(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Company company = companyServices.getCompanyById(id);
        if(company != null){
            return new ResponseEntity<>(company, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,
                                                @RequestBody Company company){
        boolean companyUpdated = companyServices.updateCompany(company, id);
        if(companyUpdated) {
            return new ResponseEntity<>("Company updated Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Company Not Found", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        companyServices.createaCompay(company);
        return new ResponseEntity<>("Company added Successfully",
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id) {
        boolean delete = companyServices.deleteCompanyById(id);
        if (delete) {
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
    }
}

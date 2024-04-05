package com.example.springboot.jobs.JobPortal.Company.Service;

import com.example.springboot.jobs.JobPortal.Company.Entity.Company;

import java.util.List;

public interface CompanyServices {
    List<Company> getAllCompanies();

    Company getCompanyById(Long id);
    void createaCompay(Company company);
    boolean updateCompany(Company company, Long id);
    boolean deleteCompanyById(Long id);
}

package com.example.springboot.jobs.JobPortal.Company.Service.Implementation;

import com.example.springboot.jobs.JobPortal.Company.Entity.Company;
import com.example.springboot.jobs.JobPortal.Company.Repository.CompanyRepository;
import com.example.springboot.jobs.JobPortal.Company.Service.CompanyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServicesImpl implements CompanyServices {
    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {

            return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void createaCompay(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if(optionalCompany.isPresent()){
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

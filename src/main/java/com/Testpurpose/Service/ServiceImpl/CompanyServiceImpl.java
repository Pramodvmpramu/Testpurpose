package com.Testpurpose.Service.ServiceImpl;

import com.Testpurpose.Service.CompanyService;
import com.Testpurpose.DTO.CompanyDTO;
import com.Testpurpose.Repository.CompanyRepository;
import com.Testpurpose.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public CompanyDTO getCompanyById(Long id) {
        Company company = companyRepository.findById(id).orElse(null);
        if (company != null) {
            return convertToDTO(company);
        } else {
            return null;
        }
    }

    @Override
    public void updateCompany(CompanyDTO companyDTO) {
        Company company = convertToEntity(companyDTO);
        companyRepository.save(company);
    }

    private Company convertToEntity(CompanyDTO companyDTO) {
        // Implement conversion logic here
        Company company = new Company();
        company.setId(companyDTO.getId());
        company.setCompanyName(companyDTO.getCompanyName());
        // Set other properties
        return company;
    }

    private CompanyDTO convertToDTO(Company company) {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(company.getId());
        companyDTO.setCompanyName(company.getCompanyName());
        // Set other properties
        return companyDTO;
    }
}

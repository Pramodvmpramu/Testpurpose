package com.Testpurpose.Service;

import com.Testpurpose.DTO.CompanyDTO;

public interface CompanyService {
    CompanyDTO getCompanyById(Long id);

    public void updateCompany(CompanyDTO companyDTO);
}

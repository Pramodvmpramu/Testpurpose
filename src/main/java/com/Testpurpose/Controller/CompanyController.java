package com.Testpurpose.Controller;

import com.Testpurpose.DTO.CompanyDTO;
import com.Testpurpose.DTO.CompanyPatchRequest;
import com.Testpurpose.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies/{id}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable Long id) {
        CompanyDTO companyDTO = companyService.getCompanyById(id);
        if (companyDTO != null) {
            return new ResponseEntity<>(companyDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdateCompany(@PathVariable Long id, @RequestBody @Valid CompanyPatchRequest request) {
        CompanyDTO existingCompany = companyService.getCompanyById(id);
        if (existingCompany == null) {
            return ResponseEntity.notFound().build();
        }

        // Apply partial updates
        if (request.getCompanyName() != null) {
            existingCompany.setCompanyName(request.getCompanyName());
        }
        if (request.getEmail() != null) {
            existingCompany.setEmail(request.getEmail());
        }
        if (request.getStrength() != null) {
            existingCompany.setStrength(request.getStrength());
        }
        if (request.getWebSiteURL() != null) {
            existingCompany.setWebSiteURL(request.getWebSiteURL());
        }

        // Apply partial update to the company
        companyService.updateCompany(existingCompany);

        return ResponseEntity.ok().build();
    }
}

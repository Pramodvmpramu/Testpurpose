package com.Testpurpose.DTO;

import com.Testpurpose.Annotation.EvenNumberOrZero;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Valid
@Data
public class CompanyDTO {

    @NotEmpty(message = "Company name is mandatory")
    @Size(min = 5, message = "Company name should be at least 5 characters")
    private String companyName;

    @NotEmpty(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @EvenNumberOrZero
    @PositiveOrZero(message = "Strength should be a positive number or zero")
    private Integer strength;

    private String webSiteURL;


    //Task 2
    @Pattern(regexp = "^[A-Za-z]{2}\\d{2}[ENen]$", message = "Company code format is invalid")
    @Size(min = 5, max = 5, message = "Company code should be 5 characters long")
    @Column(unique = true) // Assuming JPA
    private String companyCode;


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public String getWebSiteURL() {
        return webSiteURL;
    }

    public void setWebSiteURL(String webSiteURL) {
        this.webSiteURL = webSiteURL;
    }

    public void setId(Long id) {
    }

    public Long getId() {
        return null;
    }

}
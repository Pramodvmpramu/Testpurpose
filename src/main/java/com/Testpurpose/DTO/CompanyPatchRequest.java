package com.Testpurpose.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class CompanyPatchRequest {
    @Size(min = 5, message = "Company name should be at least 5 characters")
    private String companyName;

    @Email(message = "Email should be valid")
    private String email;

    @PositiveOrZero(message = "Strength should be a positive number or zero")
    private Integer strength;

    private String webSiteURL;

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
}


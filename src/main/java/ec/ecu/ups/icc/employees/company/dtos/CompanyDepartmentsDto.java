package ec.ecu.ups.icc.employees.company.dtos;

import java.math.BigDecimal;
import java.util.List;

import ec.ecu.ups.icc.employees.departament.dtos.DepartmentDto;

public class CompanyDepartmentsDto {

    private Long companyId;
    private String companyName;
    private String country;
    private int departmentCount;
    private List<DepartmentDto> departments;
    private BigDecimal totalBudget;

    public CompanyDepartmentsDto() {
    }

    public CompanyDepartmentsDto(Long companyId, String companyName, String country, List<DepartmentDto> departments, int departmentCount, BigDecimal totalBudget) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.country = country;
        this.departments = departments;
        this.departmentCount = departmentCount;
        this.totalBudget = totalBudget;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<DepartmentDto> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentDto> departments) {
        this.departments = departments;
    }

    public int getDepartmentCount() {
        return departmentCount;
    }

    public void setDepartmentCount(int departmentCount) {
        this.departmentCount = departmentCount;
    }

    public BigDecimal getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(BigDecimal totalBudget) {
        this.totalBudget = totalBudget;
    }
}
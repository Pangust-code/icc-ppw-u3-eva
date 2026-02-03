package ec.ecu.ups.icc.employees.departament.dtos;

import java.math.BigDecimal;
import java.util.List;

import ec.ecu.ups.icc.employees.company.models.companyEntity;
import ec.ecu.ups.icc.employees.employee.dtos.EmployeeDto;

public class DepartmentWithEmployeesDto {
    
    private Long departmentId;
    private String departmentName;
    private BigDecimal budget;
    private List<companyEntity> companies;
    private List<EmployeeDto> employees;
    private int employeeCount;
    private BigDecimal totalSalaries;


    public DepartmentWithEmployeesDto() {
    }


    public DepartmentWithEmployeesDto(Long departmentId, String departmentName, List<EmployeeDto> employees, BigDecimal budget, List<companyEntity> companies, int employeeCount, BigDecimal totalSalaries) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.employees = employees;
        this.budget = budget;
        this.companies = companies;
        this.employeeCount = employeeCount;
        this.totalSalaries = totalSalaries;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public List<companyEntity> getCompanies() {
        return companies;
    }

    public void setCompanies(List<companyEntity> companies) {
        this.companies = companies;
    }


    public int getEmployeeCount() {
        return employeeCount;
    }


    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }


    public BigDecimal getTotalSalaries() {
        return totalSalaries;
    }


    public void setTotalSalaries(BigDecimal totalSalaries) {
        this.totalSalaries = totalSalaries;
    }

}
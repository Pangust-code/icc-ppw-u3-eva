package ec.ecu.ups.icc.employees.departament.dtos;

import java.math.BigDecimal;
import java.util.List;

import ec.ecu.ups.icc.employees.company.models.companyEntity;
import ec.ecu.ups.icc.employees.employee.dtos.EmployeeDto;

public class DepartmentWithEmployeesDto {
    
    private Long id;
    private String name;
    private BigDecimal budget;
    private companyEntity company;
    private List<EmployeeDto> employees;
    private int employeeCount;
    private BigDecimal totalSalaries;


    public DepartmentWithEmployeesDto() {
    }


    public DepartmentWithEmployeesDto(Long id, String name, List<EmployeeDto> employees, BigDecimal budget, companyEntity company, int employeeCount, BigDecimal totalSalaries) {
        this.id = id;
        this.name = name;
        this.employees = employees;
        this.budget = budget;
        this.company = company;
        this.employeeCount = employeeCount;
        this.totalSalaries = totalSalaries;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public companyEntity getCompany() {
        return company;
    }

    public void setCompany(companyEntity company) {
        this.company = company;
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
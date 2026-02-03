package ec.ecu.ups.icc.employees.company.dtos;

import java.math.BigDecimal;
import java.util.List;

import ec.ecu.ups.icc.employees.employee.dtos.EmployeeDto;

public class EmplooyeesResponseDto {
    
    private String companyName;
    private BigDecimal minSalary;
    private BigDecimal count;
    private List<EmployeeDto> employees;
    
    public EmplooyeesResponseDto() {
    }

    public EmplooyeesResponseDto(String companyName, BigDecimal minSalary, BigDecimal count,
            List<EmployeeDto> employees) {
        this.companyName = companyName;
        this.minSalary = minSalary;
        this.count = count;
        this.employees = employees;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public BigDecimal getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(BigDecimal minSalary) {
        this.minSalary = minSalary;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }

    

}

package ec.ecu.ups.icc.employees.departament.models;

import java.math.BigDecimal;
import java.util.List;

import ec.ecu.ups.icc.employees.company.models.companyEntity;
import ec.ecu.ups.icc.employees.core.entities.BaseModel;
import ec.ecu.ups.icc.employees.employee.models.employeeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "departments")
public class departmentEntity extends BaseModel {
    
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "budget", nullable = false, precision = 15, scale = 2)
    private BigDecimal budget;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private companyEntity company;

    @OneToMany(mappedBy = "department")
    private List<employeeEntity> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<employeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<employeeEntity> employees) {
        this.employees = employees;
    }

}

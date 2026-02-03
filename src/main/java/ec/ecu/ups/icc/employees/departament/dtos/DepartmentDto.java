package ec.ecu.ups.icc.employees.departament.dtos;

import java.math.BigDecimal;

public class DepartmentDto {
    
    private Long id;
    private String name;
    private BigDecimal budget;

    public DepartmentDto() {
    }

    public DepartmentDto(Long id, String name, BigDecimal budget) {
        this.id = id;
        this.name = name;
        this.budget = budget;
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

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
    
}

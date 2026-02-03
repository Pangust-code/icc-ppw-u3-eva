package ec.ecu.ups.icc.employees.company.models;

import java.util.List;

import ec.ecu.ups.icc.employees.core.entities.BaseModel;
import ec.ecu.ups.icc.employees.departament.models.departmentEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "companies")
public class companyEntity extends BaseModel {
    
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @OneToMany(mappedBy = "company")
    private List<departmentEntity> departments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
    public List<departmentEntity> getDepartments() {
        return departments;
    }

    public void setDepartments(List<departmentEntity> departments) {
        this.departments = departments;
    }
}

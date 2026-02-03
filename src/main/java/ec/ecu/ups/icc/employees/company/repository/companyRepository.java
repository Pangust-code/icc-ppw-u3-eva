package ec.ecu.ups.icc.employees.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.ecu.ups.icc.employees.company.models.companyEntity;

public interface companyRepository extends JpaRepository<companyEntity, Long> {
    
}

package ec.ecu.ups.icc.employees.departament.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import ec.ecu.ups.icc.employees.departament.models.departmentEntity;
public interface departmentRepository extends JpaRepository<departmentEntity, Long> {
    
}

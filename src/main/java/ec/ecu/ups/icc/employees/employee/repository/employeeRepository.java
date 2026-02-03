package ec.ecu.ups.icc.employees.employee.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.ecu.ups.icc.employees.employee.models.employeeEntity;

@Repository
public interface employeeRepository extends JpaRepository<employeeEntity, Long> {
    
    @Query("SELECT e FROM employeeEntity e WHERE e.department.company.id = :companyId AND e.salary >= :minSalary ORDER BY e.salary DESC")
    List<employeeEntity> findHighSalaryEmployeesByCompany(@Param("companyId") Long companyId, @Param("minSalary") BigDecimal minSalary);
    
    @Query("SELECT AVG(e.salary) FROM employeeEntity e WHERE e.department.company.id = :companyId")
    BigDecimal findAverageSalaryByCompany(@Param("companyId") Long companyId);
    
}

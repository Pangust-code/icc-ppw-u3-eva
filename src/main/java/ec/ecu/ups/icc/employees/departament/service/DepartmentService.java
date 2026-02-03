package ec.ecu.ups.icc.employees.departament.service;

import ec.ecu.ups.icc.employees.departament.dtos.DepartmentWithEmployeesDto;

public interface DepartmentService {
    
    DepartmentWithEmployeesDto getDepartmentWithEmployees(Long departmentId);

    
}

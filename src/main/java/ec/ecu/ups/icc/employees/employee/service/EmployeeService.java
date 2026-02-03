package ec.ecu.ups.icc.employees.employee.service;

import ec.ecu.ups.icc.employees.employee.dtos.EmployeeTransferResponseDto;

public interface EmployeeService {
    
    EmployeeTransferResponseDto transferEmployee(Long employeeId, Long targetDepartmentId);

}

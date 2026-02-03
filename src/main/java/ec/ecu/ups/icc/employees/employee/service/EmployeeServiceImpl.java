package ec.ecu.ups.icc.employees.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ec.ecu.ups.icc.employees.departament.dtos.DepartmentDto;
import ec.ecu.ups.icc.employees.departament.models.departmentEntity;
import ec.ecu.ups.icc.employees.departament.repository.departmentRepository;
import ec.ecu.ups.icc.employees.employee.dtos.EmployeeTransferResponseDto;
import ec.ecu.ups.icc.employees.employee.models.employeeEntity;
import ec.ecu.ups.icc.employees.employee.repository.employeeRepository;
import exceptions.domain.ConflictException;
import exceptions.domain.NotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    
    private employeeRepository employeeRepository;
    private departmentRepository departmentRepository;

    
    
    public EmployeeServiceImpl(employeeRepository employeeRepository, departmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }



    @Override
    public EmployeeTransferResponseDto transferEmployee(Long employeeId, Long targetDepartmentId) {
        employeeEntity employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NotFoundException("Empleado no encontrado con id: " + employeeId));
        
        departmentEntity targetDepartment = departmentRepository.findById(targetDepartmentId)
                .orElseThrow(() -> new NotFoundException("Departamento no encontrado con id: " + targetDepartmentId));
        
        departmentEntity oldDepartment = employee.getDepartment();
        
        if (oldDepartment.getId().equals(targetDepartment.getId())) {
            throw new ConflictException("El empleado ya pertenece a este departamento");
        }
        
        employee.setDepartment(targetDepartment);
        employeeRepository.save(employee);
        
        List<DepartmentDto> oldDeptList = new ArrayList<>();
        oldDeptList.add(new DepartmentDto(oldDepartment.getId(), oldDepartment.getName(), oldDepartment.getBudget()));
        
        DepartmentDto newDeptDto = new DepartmentDto(
                targetDepartment.getId(),
                targetDepartment.getName(),
                targetDepartment.getBudget()
        );
        
        EmployeeTransferResponseDto response = new EmployeeTransferResponseDto();
        response.setEmployeeId(employee.getId());
        response.setEmployeeName(employee.getFirstName() + " " + employee.getLastName());
        response.setOldDepartment(oldDeptList);
        response.setNewDepartment(newDeptDto);
        response.setMessage("Empleado transferido exitosamente");
        
        return response;
    }
}

package ec.ecu.ups.icc.employees.departament.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import ec.ecu.ups.icc.employees.departament.dtos.DepartmentWithEmployeesDto;
import ec.ecu.ups.icc.employees.departament.models.departmentEntity;
import ec.ecu.ups.icc.employees.departament.repository.departmentRepository;
import ec.ecu.ups.icc.employees.employee.dtos.EmployeeDto;
import ec.ecu.ups.icc.employees.employee.models.employeeEntity;
import exceptions.domain.NotFoundException;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private departmentRepository departmentRepository;

    public DepartmentServiceImpl(departmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentWithEmployeesDto getDepartmentWithEmployees(Long departmentId) {
        departmentEntity department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new NotFoundException("Departamento no encontrado con id: " + departmentId));

        List<EmployeeDto> employeeDtos = new ArrayList<>();
        if (department.getEmployees() != null) {
            employeeDtos = department.getEmployees().stream()
                    .map(this::convertToEmployeeDto)
                    .collect(Collectors.toList());
        }

        // Calcular el total de salarios
        BigDecimal totalSalaries = employeeDtos.stream()
                .map(EmployeeDto::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // Crear el DTO de respuesta
        DepartmentWithEmployeesDto dto = new DepartmentWithEmployeesDto();
        dto.setDepartmentId(department.getId());
        dto.setDepartmentName(department.getName());
        dto.setBudget(department.getBudget());
        dto.setEmployees(employeeDtos);
        dto.setEmployeeCount(employeeDtos.size());
        dto.setTotalSalaries(totalSalaries);

        return dto;
    }

    private EmployeeDto convertToEmployeeDto(employeeEntity employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getSalary()
        );
    }
}
